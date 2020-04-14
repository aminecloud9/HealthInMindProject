package course.labs.healthinmind.reminders.data.abstractions;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalTime;
@Entity
public interface Reminder {
    long getReminderId();
    LocalTime getTime();
}
