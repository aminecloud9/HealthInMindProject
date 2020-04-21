package course.labs.healthinmind.medecine.data.roomimplementation;

import android.util.Log;

import java.util.List;

import course.labs.healthinmind.database.HealthData;
import course.labs.healthinmind.medecine.data.abstractions.Medicine;
import course.labs.healthinmind.medecine.data.abstractions.MedicinesLocalProvider;

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
}
