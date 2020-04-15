package course.labs.healthinmind.medecine.data.roomimplementation;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public Long createMedicine(Medicine medicine) {
        long createdMedicineId = createMedicineInfo(medicine);
        List<Long> medicineReminders = createMedicineReminders(medicine);
        createRemindMedicine(createdMedicineId,medicineReminders);
        return createdMedicineId;
    }

    private List<Long> createMedicineReminders(final Medicine medicine) {
        List<ReminderRoomImpl> existingReminders = reminderDao.fetchAllRemindersOf(medicine.getTakingTimes());
        List<ReminderRoomImpl> newReminders = getNewRemindersOnly(medicine,existingReminders);
        List<Long> insertedIds = reminderDao.insertReminders(newReminders);

        return new ArrayList<Long>(){
            {
                addAll(insertedIds);
                addAll(existingReminders.stream()
                        .map(ReminderRoomImpl::getReminderId)
                        .collect(Collectors.toList()));
            }
        };
    }

    private List<ReminderRoomImpl> getNewRemindersOnly(Medicine medicine, List<ReminderRoomImpl> existingReminders) {
        List<LocalTime> existingTakingTimes =
                existingReminders.stream().
                        map(ReminderRoomImpl::getTime).
                        collect(Collectors.toList());
       return medicine.getTakingTimes().stream().
                filter(takingTime -> !existingTakingTimes.contains(takingTime)).
                map(ReminderRoomImpl::new).
                collect(Collectors.toList());

    }

    private void createRemindMedicine(long createdMedicineId, List<Long> remindersIds) {
        List<RemindMedicine> remindMedicines = new ArrayList<>();
        for (Long reminderId : remindersIds){
            remindMedicines.add(new RemindMedicine(createdMedicineId, reminderId));
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
