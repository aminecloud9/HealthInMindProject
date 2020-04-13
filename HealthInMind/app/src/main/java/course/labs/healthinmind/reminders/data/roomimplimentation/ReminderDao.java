package course.labs.healthinmind.reminders.data.roomimplimentation;

import androidx.room.Insert;
import androidx.room.Transaction;

import java.util.List;

import course.labs.healthinmind.reminders.data.abstractions.Reminder;

public interface ReminderDao {
    @Insert
    long insert(ReminderRoomImpl reminder);

    @Transaction
    @Insert
    List<Long> insertReminders(List<ReminderRoomImpl> reminders);
}
