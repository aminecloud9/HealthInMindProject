package course.labs.healthinmind.reminders.data.roomimplimentation;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.time.LocalTime;
import java.util.List;

import course.labs.healthinmind.reminders.data.abstractions.Reminder;
@Dao
public interface ReminderDao {
    @Insert
    long insert(ReminderRoomImpl reminder);

    @Transaction
    @Insert
    List<Long> insertReminders(List<ReminderRoomImpl> reminders);

    @Query("SELECT * FROM reminders WHERE reminderId = :reminderId")
    ReminderRoomImpl fetchById(long reminderId);

    @Query("SELECT * FROM reminders WHERE time = :time")
    ReminderRoomImpl fetchByTime(LocalTime time);
}
