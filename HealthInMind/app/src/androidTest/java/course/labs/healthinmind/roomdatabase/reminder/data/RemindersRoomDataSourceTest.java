package course.labs.healthinmind.roomdatabase.reminder.data;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import course.labs.healthinmind.reminders.data.RemindersRoomDataSource;
import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderDao;
import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderRoomImpl;
import course.labs.healthinmind.roomdatabase.BaseRoomTest;
import course.labs.healthinmind.roomdatabase.TestUtil;

import static java.lang.StrictMath.abs;

public class RemindersRoomDataSourceTest extends BaseRoomTest {
    private RemindersRoomDataSource remindersRoomDataSource;
    private ReminderDao reminderDao;
    @Override
    public void createDb() {
        super.createDb();

        remindersRoomDataSource = new RemindersRoomDataSource(db);
        reminderDao = db.reminderDao();
    }

    @Test
    public void given_onlyNewReminders_allShouldBeInserted(){
        int numberOfReminders = abs((new Random()).nextInt() % TestUtil.NUMBER_OF_AVAILABLE_REMINDERS) ;
        List<ReminderRoomImpl> reminders = TestUtil.getReminders(numberOfReminders);
        List<Long> insertedIds = remindersRoomDataSource.insertNewRemindersOnly(TestUtil.getTakingTimes(reminders));

        Assert.assertEquals(numberOfReminders,insertedIds.size());
    }

    @Test
    public void given_existingReminders_onlyNewShouldBeInserted(){
        List<ReminderRoomImpl> existingReminders = TestUtil.getReminders();
        reminderDao.insertReminders(existingReminders);
        List<ReminderRoomImpl> remindersToBeInserted =
                new ArrayList<ReminderRoomImpl>(){{
                    add(existingReminders.get(0));
                    add(existingReminders.get(3));
                    add(new ReminderRoomImpl(LocalTime.of(21,0)));
                }};
        List<Long> insertedIds = remindersRoomDataSource.insertNewRemindersOnly(TestUtil.getTakingTimes(remindersToBeInserted));

        Assert.assertEquals(1,insertedIds.size());
    }

    @Test
    public void given_onlyExistingReminders_noReminderShouldBeInserted(){
        List<ReminderRoomImpl> existingReminders = TestUtil.getReminders();
        reminderDao.insertReminders(existingReminders);
        List<ReminderRoomImpl> remindersToBeInserted =
                new ArrayList<ReminderRoomImpl>(){{
                    add(existingReminders.get(1));
                    add(existingReminders.get(4));
                }};
        List<Long> insertedIds = remindersRoomDataSource.insertNewRemindersOnly(TestUtil.getTakingTimes(remindersToBeInserted));

        Assert.assertEquals(0,insertedIds.size());
    }
}
