package course.labs.healthinmind.reminders.data;

import java.time.LocalTime;
import java.util.List;

import course.labs.healthinmind.reminders.data.abstractions.Reminder;
import course.labs.healthinmind.reminders.data.abstractions.RemindersRepository;

public class RemindersRepositoryImp implements RemindersRepository {
    private RemindersDataSource remindersDataSource;

    public RemindersRepositoryImp(RemindersDataSource remindersDataSource) {
        this.remindersDataSource = remindersDataSource;
    }

    @Override
    public List<Reminder> fetchAllRemindersOf(List<LocalTime> takingTimes) {
        return null;
    }

    @Override
    public void insertNewRemindersOnly(List<LocalTime> takingTimes) {
        remindersDataSource.insertNewRemindersOnly(takingTimes);
    }
}
