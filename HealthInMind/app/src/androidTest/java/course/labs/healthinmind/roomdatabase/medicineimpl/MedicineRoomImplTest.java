package course.labs.healthinmind.roomdatabase.medicineimpl;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import course.labs.healthinmind.database.RemindMedicine;
import course.labs.healthinmind.database.RemindMedicineDao;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineDao;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineImpl;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineRoomImpl;
import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderDao;
import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderRoomImpl;
import course.labs.healthinmind.roomdatabase.BaseRoomTest;
import course.labs.healthinmind.roomdatabase.TestUtil;

public class MedicineRoomImplTest extends BaseRoomTest {

    private MedicineDao medicineDao;
    private ReminderDao reminderDao;
    private RemindMedicineDao remindMedicineDao;

    @Override
    public void createDb(){
        super.createDb();
        medicineDao = db.medicineDao();
        reminderDao = db.reminderDao();
        remindMedicineDao = db.remindMedicineDao();
    }

    @Test
    public void insertMedicineImpl(){
        try {
            MedicineRoomImpl paracetamol = TestUtil.createMedicine("Paracetamol");
            List<ReminderRoomImpl> reminders = TestUtil.createReminders();
            long medicineId = insertMedicineWithItsReminders(paracetamol, reminders);
            MedicineImpl medicine = medicineDao.fetchMedicineWithItsReminders(medicineId);
            Assert.assertNotNull(medicine.getMedicineName());
            Assert.assertEquals(reminders.size(), medicine.getTakingTimes().size());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private long insertMedicineWithItsReminders(MedicineRoomImpl paracetamol, List<ReminderRoomImpl> reminders) {
        long medicineId = medicineDao.insert(paracetamol);
        List<Long> remindersIds = reminderDao.insertReminders(reminders);
        List<RemindMedicine> remindMedicines = new ArrayList<>();
        for (long reminderId : remindersIds){
            remindMedicines.add(new RemindMedicine(medicineId, reminderId));
        }
        remindMedicineDao.insertRemindMedicines(remindMedicines);
        return medicineId;
    }


}
