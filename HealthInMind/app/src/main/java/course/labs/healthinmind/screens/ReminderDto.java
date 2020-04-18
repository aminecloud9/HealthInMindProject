package course.labs.healthinmind.screens;

import java.time.LocalTime;

public class ReminderDto {
    public final LocalTime time;
    public final Double quantityToTake;

    public ReminderDto(LocalTime time, Double quantityToTake) {
        this.time = time;
        this.quantityToTake = quantityToTake;
    }
}
