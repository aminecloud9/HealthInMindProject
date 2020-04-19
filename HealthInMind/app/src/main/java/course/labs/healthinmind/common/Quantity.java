package course.labs.healthinmind.common;

import java.util.HashMap;
import java.util.Map;

import course.labs.healthinmind.R;

import static android.provider.Settings.Secure.getString;


public enum Quantity {
    QUARTER(0.25,"QUARTER"),
    HALF(0.5,"HALF"),
    QUARTER_AND_HALF(0.75,"QUARTER_AND_HALF"),
    ONE(1,"ONE"),
    ONE_AND_QUARTER(1.25,"ONE_AND_QUARTER"),
    ONE_AND_HALF(1.5,"ONE_AND_HALF"),
    ONE_AND_TREE_QUARTERS(1.75,"ONE_AND_THREE_QUARTERS"),
    TWO(2,"TOW");

    private double value;
    private String string;
    Quantity(double value,String string)
    {
        this.value = value;
        this.string = string;
    }

    public double getValue(){
        return value;
    }

    public String getString(){
        return string;
    }


}
