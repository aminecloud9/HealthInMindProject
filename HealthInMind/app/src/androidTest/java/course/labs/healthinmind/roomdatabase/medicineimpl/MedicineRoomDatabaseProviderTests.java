package course.labs.healthinmind.roomdatabase.medicineimpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import course.labs.healthinmind.medecine.data.abstractions.Medicine;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineDao;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineRoomDatabaseProvider;
import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderDao;
import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderRoomImpl;
import course.labs.healthinmind.roomdatabase.BaseRoomTest;

public class MedicineRoomDatabaseProviderTests extends BaseRoomTest {

    private MedicineRoomDatabaseProvider medicineProvider;
    private MedicineDao medicineDao;
    private ReminderDao reminderDao;

    private Medicine medicineToBeCreated;

    @Before
    public void setUp(){
        super.createDb();
        medicineProvider = new MedicineRoomDatabaseProvider(db);
        medicineDao = db.medicineDao();
        reminderDao = db.reminderDao();
        medicineToBeCreated = mock(Medicine.class);
        when(medicineToBeCreated.getMedicineName()).thenReturn("Paracetamol");
    }


    @Test
    public void createMedicineWithNewReminders(){

        List<LocalTime> takingTimes = new ArrayList<LocalTime>(){
            {
                add(LocalTime.of(7,0));
                add(LocalTime.of(12,0));
            }
        };
        when(medicineToBeCreated.getTakingTimes()).thenReturn(takingTimes);

        Long createdId = medicineProvider.createMedicine(medicineToBeCreated);
        Assert.assertNotNull(createdId);
        Medicine createdMedicine = medicineDao.fetchMedicineWithItsReminders(createdId);
        Assert.assertEquals(createdId,createdMedicine.getMedicineId());
        Assert.assertEquals(takingTimes.size(),createdMedicine.getTakingTimes().size());
    }

    @Test
    public void createMedicineWithSomeRemindersAlreadyExist(){
        final List<LocalTime> existingTimes = new ArrayList<LocalTime>(){
            {
                add(LocalTime.of(7,0));
                add(LocalTime.of(12,0));
            }
        };
        reminderDao.insertReminders(
                new ArrayList<ReminderRoomImpl>(){
                    {
                        for (LocalTime existingTime : existingTimes){
                            add(new ReminderRoomImpl(existingTime));
                        }
                    }
                }
        );

        List<LocalTime> medicineToBeCreatedReminders = new ArrayList<LocalTime>(){
            {
                addAll(existingTimes);
                add(LocalTime.of(20,0));
            }
        };
        when(medicineToBeCreated.getTakingTimes()).thenReturn(medicineToBeCreatedReminders);

        Long createdMedicineId = medicineProvider.createMedicine(medicineToBeCreated);
        List<ReminderRoomImpl> createdMedicineTimeReminders = reminderDao.fetchAllRemindersOf(medicineToBeCreatedReminders);
        Assert.assertEquals(medicineToBeCreatedReminders.size(),createdMedicineTimeReminders.size());
        Medicine createdMedicine = medicineDao.fetchMedicineWithItsReminders(createdMedicineId);
        Assert.assertEquals(medicineToBeCreatedReminders.size(),createdMedicine.getTakingTimes().size());

        for (LocalTime takingTime : createdMedicine.getTakingTimes()){
            Assert.assertTrue(medicineToBeCreatedReminders.contains(takingTime));
        }
    }

    @Test
    public void createMedicineWithAllRemindersAlreadyExist(){
        final List<LocalTime> existingTimes = new ArrayList<LocalTime>(){
            {
                add(LocalTime.of(7,0));
                add(LocalTime.of(12,0));
            }
        };
        reminderDao.insertReminders(
                new ArrayList<ReminderRoomImpl>(){
                    {
                        for (LocalTime existingTime : existingTimes){
                            add(new ReminderRoomImpl(existingTime));
                        }
                    }
                }
        );

        when(medicineToBeCreated.getTakingTimes()).thenReturn(existingTimes);

        Long createdMedicineId = medicineProvider.createMedicine(medicineToBeCreated);
        List<ReminderRoomImpl> createdMedicineTimeReminders = reminderDao.fetchAllRemindersOf(existingTimes);
        Assert.assertEquals(existingTimes.size(),createdMedicineTimeReminders.size());
        Medicine createdMedicine = medicineDao.fetchMedicineWithItsReminders(createdMedicineId);
        Assert.assertEquals(existingTimes.size(),createdMedicine.getTakingTimes().size());

        for (LocalTime takingTime : createdMedicine.getTakingTimes()){
            Assert.assertTrue(existingTimes.contains(takingTime));
        }
    }
}
