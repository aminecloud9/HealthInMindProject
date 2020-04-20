package course.labs.healthinmind.reminders.data.abstractions;

import java.time.LocalTime;
import java.util.List;

public interface RemindersRepository {
    List<Reminder> fetchAllRemindersOf(List<LocalTime> takingTimes);

    List<Long> insertNewRemindersOnly(List<LocalTime> takingTimes);
}
