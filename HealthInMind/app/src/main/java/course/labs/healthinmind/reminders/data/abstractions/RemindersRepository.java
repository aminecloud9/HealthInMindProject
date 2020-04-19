package course.labs.healthinmind.reminders.data.abstractions;

import java.time.LocalTime;
import java.util.List;

import course.labs.healthinmind.reminders.data.abstractions.Reminder;

public interface RemindersRepository {
    List<Reminder> fetchAllRemindersOf(List<LocalTime> takingTimes);

    void insertNewRemindersOnly(List<LocalTime> takingTimes);
}
