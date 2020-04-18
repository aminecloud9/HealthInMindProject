package course.labs.healthinmind.screens;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import course.labs.healthinmind.R;
import course.labs.healthinmind.reminders.data.abstractions.Reminder;
import course.labs.healthinmind.screens.views.BaseObservableViewMvc;


public class ReminderView extends BaseObservableViewMvc <ReminderView.Listener> implements AddMedicine.ListenerForReminders {

    @Override
    public void onReminderClicked(ReminderDto reminderDto) {
        bindReminder();
    }

    public interface Listener{
        void onItemClicked();
    }

    private TextView reminderTime;
    private TextView quantityToTake;
    private Listener mlistener;


    public ReminderView(LayoutInflater layoutInflater, ViewGroup parent) {
        setRootView(layoutInflater.inflate(R.layout.add_medicine_view,parent,false));
        setUpComponents();
    }

    private void setUpComponents() {
        reminderTime = findViewById(R.id.tv_time_reminder_item);
        quantityToTake = findViewById(R.id.tv_quantity_reminer_item);
    }

    private void onItemClicked(ReminderDto reminderDto){
        for (Listener listener : getListeners()){
            listener.onItemClicked();
        }
    }

}
