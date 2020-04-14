package course.labs.healthinmind.reminders.data.roomimplimentation;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.time.LocalTime;

import course.labs.healthinmind.reminders.data.abstractions.Reminder;

@Entity(tableName = "reminders")
public class ReminderRoomImpl implements Reminder {
    @PrimaryKey(autoGenerate = true)
    private long reminderId;
    private LocalTime time;

    public ReminderRoomImpl(long reminderId, LocalTime time) {
        this.time = time;
        this.reminderId = reminderId;
    }

    @Ignore
    public ReminderRoomImpl(LocalTime takingTime) {
        this.time = takingTime;
    }

    @Override
    public long getReminderId() {
        return reminderId;
    }

    @Override
    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj != null) {
            return time.equals(((ReminderRoomImpl)obj).getTime());
        }else {
            return false;
        }
    }
}
