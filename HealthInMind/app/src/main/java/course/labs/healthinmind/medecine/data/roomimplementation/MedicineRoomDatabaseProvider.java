package course.labs.healthinmind.medecine.data.roomimplementation;

import java.util.ArrayList;
import java.util.List;

import course.labs.healthinmind.database.HealthData;
import course.labs.healthinmind.database.RemindMedicine;
import course.labs.healthinmind.database.RemindMedicineDao;
import course.labs.healthinmind.medecine.data.abstractions.Medicine;
import course.labs.healthinmind.medecine.data.abstractions.MedicinesLocalProvider;
import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderDao;
import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderRoomImpl;

public class MedicineRoomDatabaseProvider implements MedicinesLocalProvider {

     private MedicineDao medicineDao;
     private ReminderDao reminderDao;
     private RemindMedicineDao remindMedicineDao;

    public MedicineRoomDatabaseProvider(HealthData db) {
        medicineDao  = db.medicineDao();
        reminderDao = db.reminderDao();
        remindMedicineDao = db.remindMedicineDao();
    }

    @Override
    public Medicine getMedicine(int id) {
        return medicineDao.fetchMedicineWithItsReminders(id);
    }

    @Override
    public Medicine createMedicine(Medicine medicine) {
        List<ReminderRoomImpl> existingReminders = reminderDao.fetchAllRemindersOf(medicine.getTakingTimes());
        List<ReminderRoomImpl> onlyNewReminders = getNewRemindersOnly(existingReminders);
        reminderDao.insertReminders(onlyNewReminders);
        long createdMedicineId = createMedicineInfo(medicine);
        createRemindMedicine(createdMedicineId, onlyNewReminders);
        return medicineDao.fetchMedicineWithItsReminders(createdMedicineId);
    }

    private List<ReminderRoomImpl> getNewRemindersOnly(List<ReminderRoomImpl> existingReminders) {
        //TODO implement
        return null;
    }

    private void createRemindMedicine(long createdMedicineId, List<ReminderRoomImpl> onlyNewReminders) {
        List<RemindMedicine> remindMedicines = new ArrayList<>();
        for (ReminderRoomImpl reminder : onlyNewReminders){
            remindMedicines.add(new RemindMedicine(createdMedicineId, reminder.getReminderId()));
        }
        remindMedicineDao.insertRemindMedicines(remindMedicines);
    }

    private long createMedicineInfo(Medicine medicine) {
        return medicineDao.insert(
                new MedicineRoomImpl(
                        medicine.getMedicineName(),
                        medicine.getForm(),
                        medicine.getDosage(),
                        medicine.getFrequency(),
                        medicine.getRefillQuantity(),
                        medicine.isRefillReminder(),
                        medicine.getStartDate(),
                        medicine.isMedicineHasNoEndDate(),
                        medicine.getEndDate(),
                        medicine.getInstructions(),
                        medicine.getQuantityToTake())
        );
    }

    @Override
    public Medicine updateMedicine(Medicine medicine) {
        //TODO implement
        return null;
    }

    @Override
    public void deleteMedicine(int medicineId) {
        medicineDao.deleteMedicineRoom(medicineId);
    }

    @Override
    public List<Medicine> showExistantMedicines() {
        //TODO implement
        return null;
    }
}
