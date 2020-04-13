package course.labs.healthinmind.roomdatabase.reminder.data;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.Random;

import course.labs.healthinmind.roomdatabase.BaseRoomTest;
import course.labs.healthinmind.roomdatabase.TestUtil;
import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderDao;
import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderRoomImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(AndroidJUnit4.class)
public class ReminderRoomImplTest extends BaseRoomTest {
    private ReminderDao reminderDao;

    @Override
    public void createDb(){
        super.createDb();
        reminderDao = db.reminderDao();
    }

    @Test
    public void createRemindersList(){
        List<ReminderRoomImpl> reminders = TestUtil.createReminders();
        List<Long> remindersId = reminderDao.insertReminders(reminders);
        assertFalse(remindersId.isEmpty());
        assertEquals(reminders.size(),remindersId.size());
        int reminderToBeFetchedIndex = ((new Random()).nextInt()) % reminders.size();
        ReminderRoomImpl fetchedReminder = reminderDao.fetchByTime(reminders.get(reminderToBeFetchedIndex).getTime());
        assertEquals(reminders.get(reminderToBeFetchedIndex).getTime(),fetchedReminder.getTime());
    }




}
