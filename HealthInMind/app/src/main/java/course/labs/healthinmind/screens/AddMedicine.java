package course.labs.healthinmind.screens;

import android.widget.EditText;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import course.labs.healthinmind.screens.views.ObservableViewMvc;

public interface AddMedicine extends ObservableViewMvc {

    public interface Listener{
        void onButtonSaveClicked(String medicineName, String form, int dosage, int refillQuantity, boolean refillReminder, boolean medicineHasNoEndDate, Date startDate, Date endDate, String instructions, double quantityToTake, List<LocalTime> takingTimes);
    }


    String setTextToString(EditText editText);

    List<LocalTime> getTakingTimes();

    void updateLabel(EditText editText);

    Date setTextToDate(EditText editText);

    int setTextToInt(EditText editText);

    LocalTime setTextToTime(EditText editText);

    void inflateCalenderSetDateFrom(EditText editTextDate);
}
