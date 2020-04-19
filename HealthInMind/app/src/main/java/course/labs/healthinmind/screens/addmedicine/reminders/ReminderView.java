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
        setRootView(layoutInflater.inflate(R.layout.et_reminder_item,parent,false));
        setUpComponents();
    }

    private void setUpComponents() {
        reminderTime = findViewById(R.id.tv_time_reminder_item);
        quantityToTake = findViewById(R.id.tv_quantity_reminder_item);
    }

    public void bindReminder(ReminderDto reminderDto) {
        reminderTime.setText(reminderDto.getTime().toString());
        quantityToTake.setText(getContext().getString(R.string.quantity_to_take, String.valueOf(reminderDto.quantityToTake)));
    }

}
