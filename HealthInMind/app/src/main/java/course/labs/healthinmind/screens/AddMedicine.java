package course.labs.healthinmind.screens;

import android.widget.EditText;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import course.labs.healthinmind.reminders.data.abstractions.Reminder;
import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderRoomImpl;
import course.labs.healthinmind.screens.views.ObservableViewMvc;

public interface AddMedicine extends ObservableViewMvc {

    public interface ListenerForReminders {
        void onReminderClicked(ReminderDto reminderDto);
    }

    public interface ListenerForButtonSave {
        void onButtonSaveClicked(String medicineName,
                                 String form,
                                 int dosage,
                                 int refillQuantity,
                                 boolean refillReminder,
                                 boolean medicineHasNoEndDate,
                                 Date startDate,
                                 Date endDate,
                                 String instructions,
                                 double quantityToTake,
                                 List<LocalTime> takingTimes);

    }
}