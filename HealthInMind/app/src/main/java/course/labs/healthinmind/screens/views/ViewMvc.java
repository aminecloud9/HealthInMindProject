package course.labs.healthinmind.screens.views;

import android.view.View;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public interface ViewMvc {
    public static final String MY_DATE_FORMAT = "dd/MM/yyyy";
    public static final DateFormat DATE_FORMATEER = new SimpleDateFormat(MY_DATE_FORMAT);


    View getRootView();
}
