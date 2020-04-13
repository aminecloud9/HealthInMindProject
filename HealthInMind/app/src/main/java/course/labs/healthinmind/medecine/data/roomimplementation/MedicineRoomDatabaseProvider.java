package course.labs.healthinmind.medecine.data.roomimplementation;

import android.app.Application;

import java.util.List;

import course.labs.healthinmind.database.HealthData;
import course.labs.healthinmind.database.MedicineDao;
import course.labs.healthinmind.medecine.data.abstractions.Medicine;
import course.labs.healthinmind.medecine.data.abstractions.MedicinesLocalProvider;

public class MedicineRoomDatabaseProvider implements MedicinesLocalProvider {


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
