package course.labs.healthinmind.medecine.data.abstractions;

import java.util.List;

import course.labs.healthinmind.medecine.domain.showmedicineslist.GeneralMedicineDetails;
import course.labs.healthinmind.screens.medicineslist.medicineslist.GeneralDisplayMedicineDetails;

public interface MedicineRepository {

    Medicine getMedicine(long id);
    Long createMedicine(Medicine medicine);
    Medicine updateMedicine(Medicine medicine);
    void deleteMedicine(int id);
    List<GeneralMedicineDetails> getGeneralMedicinesDetailsList();

    List<Medicine> showExistingMedicines();
}
