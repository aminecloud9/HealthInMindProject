package course.labs.healthinmind.medecine;

import android.app.Application;

import java.time.LocalTime;
import java.util.List;

import course.labs.healthinmind.database.HealthData;
import course.labs.healthinmind.database.MedicineDao;

public class MedicineRoomDatabaseProvider implements MedicinesLocalProvider{


    private MedicineDao medicineDao;

    public MedicineRoomDatabaseProvider(Application application) {
        medicineDao  = HealthData.getInstance(application).medicineDao();
    }

    @Override
    public Medicine getMedicine(int id) {
        return medicineDao.fetchMedicineWithItsReminders(id);
    }

    @Override
    public Medicine createMedicine(Medicine medicine) {
        medicineDao.insert((MedicineImpl) medicine);
        return medicine;
    }

    @Override
    public Medicine updateMedicine(Medicine medicine) {
        medicineDao.update((MedicineImpl) medicine);
        return medicine;
    }

    @Override
    public void deleteMedicine(int medicineId) {
        medicineDao.deleteMedicineRoom(medicineId);
    }

    @Override
    public List<Medicine> showExistantMedicines() {
        return medicineDao.getAllMedicines();
    }
}
