package course.labs.healthinmind.medecine.data.roomimplementation;

import android.util.Log;

import java.util.List;
import java.util.stream.Collectors;

import course.labs.healthinmind.database.HealthData;
import course.labs.healthinmind.medecine.data.abstractions.Medicine;
import course.labs.healthinmind.medecine.data.abstractions.MedicinesLocalProvider;
import course.labs.healthinmind.medecine.domain.showmedicineslist.GeneralMedicineDetails;
import course.labs.healthinmind.remindmedicine.MedicineWithReminder;

public class MedicineRoomDatabaseProvider implements MedicinesLocalProvider {

     private MedicineDao medicineDao;


    public MedicineRoomDatabaseProvider(HealthData db) {
        medicineDao  = db.medicineDao();
    }

    @Override
    public Medicine getMedicine(long id) {
        return medicineDao.fetchById(id);
    }

    @Override
    public Long createMedicine(Medicine medicine) {
        Log.i("AddMedicineProcess","createMedicine from MedicineDataProvider");
        return medicineDao.insert((MedicineRoomImpl) medicine);
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

    @Override
    public List<GeneralMedicineDetails> getGeneralMedicinesDetailsList() {
        List<MedicineWithReminder> medicinesWithReminders =  medicineDao.fetchMedicinesWithReminders();
         return medicinesWithReminders
                .stream()
                .map((
                        medicineWithReminder ->
                                new GeneralMedicineDetails(
                                        medicineWithReminder.medicine.medicineId,
                                        medicineWithReminder.medicine.medicineName,
                                        medicineWithReminder.medicine.dosage,
                                        medicineWithReminder.medicine.form,
                                        medicineWithReminder.reminders.size()
                                )))
                .collect(Collectors.toList());
    }
}
