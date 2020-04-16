package course.labs.healthinmind.screens;

import android.widget.EditText;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import course.labs.healthinmind.screens.views.ObservableViewMvc;

public interface AddMedicine extends ObservableViewMvc {

    public interface Listener{
        void onButtonSaveClicked();
    }

    void setUpComponents();

    String setTextToString(EditText editText);

    List<LocalTime> getTakingTimes();

    void updateLabel(EditText editText);

    Date setTextToDate(EditText editText);

    int setTextToInt(EditText editText);

    LocalTime setTextToTime(EditText editText);

    void inflateCalenderSetDateFrom(EditText editTextDate);
}
