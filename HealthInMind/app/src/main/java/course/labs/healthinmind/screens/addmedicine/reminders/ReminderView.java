package course.labs.healthinmind.screens.addmedicine.reminders;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import course.labs.healthinmind.R;
import course.labs.healthinmind.screens.addmedicine.AddMedicine;
import course.labs.healthinmind.screens.views.BaseObservableViewMvc;


public class ReminderView extends BaseObservableViewMvc <ReminderView.Listener> {

    public interface Listener{

        void onItemClicked();
    }
    private TextView reminderTime;

    private TextView quantityToTake;

    public ReminderView(LayoutInflater layoutInflater, ViewGroup parent) {
        setRootView(layoutInflater.inflate(R.layout.add_medicine_view,parent,false));
        setUpComponents();
    }

    private void setUpComponents() {
        reminderTime = findViewById(R.id.tv_time_reminder_item);
        quantityToTake = findViewById(R.id.tv_quantity_reminer_item);
    }

    void bindReminder(ReminderDto reminderDto) {
        reminderTime.setText(reminderDto.getTime().toString());
        quantityToTake.setText(String.valueOf(reminderDto.quantityToTake));
    }

}
