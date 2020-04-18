package course.labs.healthinmind.screens.addmedicine.reminders;

import java.time.LocalTime;

public class ReminderDto {
    private final LocalTime time;
    public final Double quantityToTake;

    public ReminderDto(LocalTime time, Double quantityToTake) {
        this.time = time;
        this.quantityToTake = quantityToTake;
    }

    public LocalTime getTime() {
        return time;
    }
}
