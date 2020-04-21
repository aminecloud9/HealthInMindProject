package course.labs.healthinmind.screens.addmedicine.reminders;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import course.labs.healthinmind.R;
import course.labs.healthinmind.common.Quantity;

public abstract class StringEnumMapper<EnumType> {

    private Map<String, EnumType> enumTypeMap;
    private Context context;
    public StringEnumMapper(Context context){
        this.context = context;

    }

    protected String getKey(int id){
        return context.getString(id);
    }

    public EnumType getValue(String key){
        return enumTypeMap.get(key);
    }

    public List<String> getStringArray(){
        return new ArrayList<>(enumTypeMap.keySet());
    }

    public String getString(EnumType enumType) {
        return enumTypeMap.
                entrySet().
                stream().
                filter(entry -> entry.getValue().equals(enumType)).
                map(Map.Entry::getKey).
                collect(Collectors.toList()).get(0);
    }

    protected void setEnumTypeMap(Map<String, EnumType> enumTypeMap){
        this.enumTypeMap = enumTypeMap;
    }
}
