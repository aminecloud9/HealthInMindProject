package course.labs.healthinmind.reminders;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalTime;

@Entity
public class ReminderRoomImpl implements Reminder{
    @PrimaryKey
    private LocalTime reminderId;

    private LocalTime time;
    public ReminderRoomImpl(LocalTime time) {
        this.time = time;
        reminderId = time;
    }

    public LocalTime getReminderId() {
        return reminderId;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
