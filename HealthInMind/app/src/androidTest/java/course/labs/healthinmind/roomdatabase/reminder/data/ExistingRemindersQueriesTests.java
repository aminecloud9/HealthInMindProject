package course.labs.healthinmind.roomdatabase.reminder.data;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderDao;
import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderRoomImpl;
import course.labs.healthinmind.roomdatabase.BaseRoomTest;
import course.labs.healthinmind.roomdatabase.TestUtil;

public class ExistingRemindersQueriesTests extends BaseRoomTest {

    private ReminderDao reminderDao;

    @Override
    public void createDb() {
        super.createDb();
        reminderDao = db.reminderDao();
        List<ReminderRoomImpl> reminders = TestUtil.getReminders();
        List<Long> remindersId = reminderDao.insertReminders(reminders);
    }

    @Test
    public void fetchExistingRemindersBeforeInsertion(){
        List<LocalTime> takingTimes = getTakingTimes(TestUtil.getReminders(3));
        List<ReminderRoomImpl> existingReminders = reminderDao.fetchAllRemindersOf(takingTimes);
        Assert.assertEquals(takingTimes.size(), existingReminders.size());
        for (ReminderRoomImpl existingReminder : existingReminders){
            Assert.assertTrue(takingTimes.contains(existingReminder.time));
        }
    }

    private List<LocalTime> getTakingTimes(List<ReminderRoomImpl> reminders) {
        List<LocalTime> takingTimes = new ArrayList<>();
        for (ReminderRoomImpl reminder : reminders){
            takingTimes.add(reminder.time);
        }

        return takingTimes;
    }

    @Test
    public void insertConflicts(){
        List<ReminderRoomImpl> existingReminders = TestUtil.getReminders(3);
        List<LocalTime> takingTimes = getTakingTimes(existingReminders);
        existingReminders = reminderDao.fetchAllRemindersOf(takingTimes);
        int numberOfRemindersBeforeInsertion = (reminderDao.fetchAllReminders()).size();
        reminderDao.insertReminders(existingReminders);
        int numberOfRemindersAfterInsertion = (reminderDao.fetchAllReminders()).size();
        Assert.assertEquals(numberOfRemindersBeforeInsertion,numberOfRemindersAfterInsertion);
    }
}
