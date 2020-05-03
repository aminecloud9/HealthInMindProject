package course.labs.healthinmind.medecine.data.roomimplementation;

import java.util.List;

import course.labs.healthinmind.medecine.data.abstractions.Medicine;
import course.labs.healthinmind.medecine.data.abstractions.MedicineRepository;
import course.labs.healthinmind.medecine.data.abstractions.MedicinesLocalProvider;
import course.labs.healthinmind.medecine.domain.showmedicineslist.GeneralMedicineDetails;
import course.labs.healthinmind.screens.medicineslist.medicineslist.GeneralDisplayMedicineDetails;

public class MedicineRepositoryImpl implements MedicineRepository {
    private MedicinesLocalProvider medicinesLocalProvider;

    public MedicineRepositoryImpl(MedicinesLocalProvider medicinesLocalProvider) {
        this.medicinesLocalProvider = medicinesLocalProvider;
    }

    @Override
    public Medicine getMedicine(long id) {
        return medicinesLocalProvider.getMedicine(id);
    }

    @Override
    public Long createMedicine(Medicine medicine) {
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
    public List<GeneralMedicineDetails> getGeneralMedicinesDetailsList() {
        return medicinesLocalProvider.getGeneralMedicinesDetailsList();
    }

    @Override
    public List<Medicine> showExistingMedicines() {
        return medicinesLocalProvider.showExistantMedicines();
    }

}
