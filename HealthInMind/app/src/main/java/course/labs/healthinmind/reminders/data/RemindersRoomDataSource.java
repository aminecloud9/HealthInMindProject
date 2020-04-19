package course.labs.healthinmind.reminders.data;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import course.labs.healthinmind.database.HealthData;
import course.labs.healthinmind.reminders.data.abstractions.Reminder;
import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderDao;
import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderRoomImpl;

public class RemindersRoomDataSource implements RemindersDataSource {
    private ReminderDao reminderDao;

    public RemindersRoomDataSource(HealthData database){
        reminderDao = database.reminderDao();
    }

    @Override
    public void insertNewRemindersOnly(List<LocalTime> takingTimes) {
        List<ReminderRoomImpl> existingReminders = reminderDao.fetchAllRemindersOf(takingTimes);
        List<ReminderRoomImpl> newReminders = filterReminders(takingTimes, existingReminders);
        reminderDao.insertReminders(newReminders);
    }

    private List<ReminderRoomImpl> filterReminders(List<LocalTime> takingTimes, List<ReminderRoomImpl> existingReminders) {
        List<LocalTime> existingTimes =
                existingReminders.
                        stream().
                        map(reminderRoom -> reminderRoom.time).
                        collect(Collectors.toList());

        return takingTimes.
                stream().
                filter(takingTime -> !existingTimes.contains(takingTime)).
                map(ReminderRoomImpl::new).collect(Collectors.toList());

    }
}
