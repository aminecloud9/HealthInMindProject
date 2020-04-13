package course.labs.healthinmind.database;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.TypeConverter;

import java.time.LocalTime;
import java.util.Date;

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
    public static LocalTime toDate(String timeString) {
        if (timeString == null) {
            return null;
        } else {
            return LocalTime.parse(timeString);
        }
    }

    @TypeConverter
    public static String toDateString(LocalTime time) {
        if (time == null) {
            return null;
        } else {
            return time.toString();
        }
    }
}
