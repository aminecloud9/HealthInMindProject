package course.labs.healthinmind.reminders.data.abstractions;

import java.time.LocalTime;

public abstract class Reminder {
    public final LocalTime time;


    protected Reminder(LocalTime time) {
        this.time = time;
    }
}
