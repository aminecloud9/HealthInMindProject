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

public class ReminderSelectQueries extends BaseRoomTest {

    private ReminderDao reminderDao;

    @Override
    public void createDb() {
        super.createDb();
        reminderDao = db.reminderDao();
        List<ReminderRoomImpl> reminders = TestUtil.createReminders();
        List<Long> remindersId = reminderDao.insertReminders(reminders);
    }

    @Test
    public void fetchExistingRemindersBeforeInsertion(){
        List<LocalTime> takingTimes = new ArrayList<LocalTime>(){
            {
                add(LocalTime.of(7,0));
                add(LocalTime.of(12,0));
            }
        };
        List<ReminderRoomImpl> existingReminders = reminderDao.fetchAllRemindersOf(takingTimes);
        Assert.assertEquals(takingTimes.size(), existingReminders.size());
        for (ReminderRoomImpl existingReminder : existingReminders){
            Assert.assertTrue(takingTimes.contains(existingReminder.getTime()));
        }
    }
}
