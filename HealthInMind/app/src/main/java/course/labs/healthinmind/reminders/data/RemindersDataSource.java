package course.labs.healthinmind.reminders.data;

import java.time.LocalTime;
import java.util.List;

public interface RemindersDataSource {

    void insertNewRemindersOnly(List<LocalTime> takingTimes);
}
