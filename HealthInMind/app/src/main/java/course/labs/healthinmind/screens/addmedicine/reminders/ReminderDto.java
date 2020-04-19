package course.labs.healthinmind.screens.addmedicine.reminders;

import java.time.LocalTime;

import course.labs.healthinmind.common.Quantity;

public class ReminderDto {
    private final LocalTime time;
    public final Quantity quantityToTake;

    public ReminderDto(LocalTime time, Quantity quantityToTake) {
        this.time = time;
        this.quantityToTake = quantityToTake;
    }

    public LocalTime getTime() {
        return time;
    }
}
