package course.labs.healthinmind.medecine;

import java.util.List;

public class MedicineRepositoryImpl implements MedicineRepository{
    private MedicinesLocalProvider medicinesLocalProvider;

    public MedicineRepositoryImpl(MedicinesLocalProvider medicinesLocalProvider) {
        this.medicinesLocalProvider = medicinesLocalProvider;
    }

    @Override
    public Medicine getMedicine(int id) {
        return medicinesLocalProvider.getMedicine(id);
    }

    @Override
    public Medicine createMedicine(Medicine medicine) {
        return medicinesLocalProvider.createMedicine(medicine);
    }

    @Override
    public Medicine updateMedicine(Medicine medicine) {
        return medicinesLocalProvider.updateMedicine(medicine);
    }

    @Override
    public void deleteMedicine(int id) {
        medicinesLocalProvider.deleteMedicine(id);
    }

    @Override
    public List<Medicine> showExistingMedicines() {
        return medicinesLocalProvider.showExistantMedicines();
    }

}
