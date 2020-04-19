package course.labs.healthinmind.reminders.data.roomimplimentation;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.time.LocalTime;

import course.labs.healthinmind.reminders.data.abstractions.Reminder;

@Entity(tableName = "reminders")
public class ReminderRoomImpl extends Reminder {
    @PrimaryKey(autoGenerate = true)
    public long reminderId;

    public ReminderRoomImpl(long reminderId, LocalTime time) {
        super(time);
        this.reminderId = reminderId;
    }

    @Ignore
    public ReminderRoomImpl(LocalTime takingTime) {
        super(takingTime);
    }


    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj != null) {
            return time.equals(((ReminderRoomImpl)obj).time);
        }else {
            return false;
        }
    }

    public long getReminderId() {
        return reminderId;
    }
}
