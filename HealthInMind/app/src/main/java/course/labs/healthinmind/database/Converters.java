package course.labs.healthinmind.database;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.TypeConverter;

import java.time.LocalTime;
import java.util.Date;

import course.labs.healthinmind.common.Form;
import course.labs.healthinmind.common.Quantity;

public class Converters {

    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @TypeConverter
    public static LocalTime toDate(Long nanoOfDay) {
        if (nanoOfDay == null) {
            return null;
        } else {
            return LocalTime.ofNanoOfDay(nanoOfDay);
        }
    }

    @TypeConverter
    public static Long toDateString(LocalTime time) {
        if (time == null) {
            return null;
        } else {
            return time.toNanoOfDay();
        }
    }

    @TypeConverter
    public static String toQuantityString(Quantity quantity){
        return quantity.getString();
    }

    @TypeConverter
    public static Quantity toQuantity(String quantity){

        switch (quantity){
            case "QUARTER":
                return Quantity.QUARTER;
            case "HALF" :
                return Quantity.HALF;
            case "ONE_AND_QUARTER" :
                return Quantity.ONE_AND_QUARTER;
            case "ONE" :
                return Quantity.ONE;
            case "ONE_AND_HALF" :
                return Quantity.ONE_AND_HALF;
            case "ONE_AND_THREE_QUARTERS" :
                return Quantity.ONE_AND_TREE_QUARTERS;
            case "TWO" :
                return Quantity.TWO;
            default:
                return null;
        }
    }

    @TypeConverter
    public static String toFormString(Form form){
        return form.getValue();
    }

    @TypeConverter
    public static Form toForm(String form){
        switch (form){
            case "Pill" : return Form.PILL;
            case "Liquid" : return Form.LIQUID;
            case "Injections" : return Form.INJECTIONS;
            case "Tablet" : return Form.TABLET;
            default: return null;
        }
    }
}
