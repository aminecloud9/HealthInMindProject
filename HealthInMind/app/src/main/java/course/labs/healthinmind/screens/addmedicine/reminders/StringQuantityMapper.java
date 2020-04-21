package course.labs.healthinmind.screens.addmedicine.reminders;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import course.labs.healthinmind.R;
import course.labs.healthinmind.common.Quantity;

public class StringQuantityMapper extends StringEnumMapper<Quantity>{

    public StringQuantityMapper(Context context) {
        super(context);
        setEnumTypeMap(new HashMap<String, Quantity>(){{
            put(getKey(R.string.quarter),Quantity.QUARTER);
            put(getKey(R.string.half),Quantity.HALF);
            put(getKey(R.string.quarter_and_half),Quantity.QUARTER_AND_HALF);
            put(getKey(R.string.one),Quantity.ONE);
            put(getKey(R.string.one_and_quarter),Quantity.ONE_AND_QUARTER);
            put(getKey(R.string.one_and_half),Quantity.ONE_AND_HALF);
            put(getKey(R.string.one_and_three_quarters),Quantity.ONE_AND_TREE_QUARTERS);
            put(getKey(R.string.two),Quantity.TWO);
        }});
    }
}
