package course.labs.healthinmind.common;

import java.util.HashMap;
import java.util.Map;

import course.labs.healthinmind.R;

import static android.provider.Settings.Secure.getString;


public enum Quantity {
    QUARTER(0.25),
    HALF(0.5),
    QUARTER_AND_HALF(0.75),
    ONE(1),
    ONE_AND_QUARTER(1.25),
    ONE_AND_HALF(1.5),
    ONE_AND_TREE_QUARTERS(1.75),
    TWO(2);

    private double value;

    Quantity(double value){
        this.value = value;
    }

    public double getValue(){
        return value;
    }



}
