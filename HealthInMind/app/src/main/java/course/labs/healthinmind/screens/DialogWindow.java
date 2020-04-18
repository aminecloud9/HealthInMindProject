package course.labs.healthinmind.screens;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.Spinner;

import course.labs.healthinmind.R;
import course.labs.healthinmind.screens.views.BaseObservableViewMvc;

public  class DialogWindow extends BaseObservableViewMvc {
    private NumberPicker hour;
    private NumberPicker minute;
    private Spinner quantityToTake;

    public DialogWindow(LayoutInflater layoutInflater, ViewGroup parent) {
        setRootView(layoutInflater.inflate(R.layout.dialog_window,parent,false));
        setUpComponents();
    }

    private void setUpComponents(){
        hour = findViewById(R.id.np_reminder_hour);
        minute = findViewById(R.id.np_reminder_minute);
        hour.setMinValue(00);hour.setMaxValue(11);
        minute.setMinValue(00);minute.setMaxValue(59);
    }
}
