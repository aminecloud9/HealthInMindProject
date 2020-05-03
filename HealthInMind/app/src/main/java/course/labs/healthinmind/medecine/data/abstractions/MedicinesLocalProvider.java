package course.labs.healthinmind.medecine.data.abstractions;

import java.util.List;

import course.labs.healthinmind.medecine.domain.showmedicineslist.GeneralMedicineDetails;

public interface MedicinesLocalProvider {
    Medicine getMedicine(long id);
    Long createMedicine(Medicine medicine);
    Medicine updateMedicine(Medicine medicine);
    void deleteMedicine(int id);

    List<Medicine> showExistantMedicines();

    List<GeneralMedicineDetails> getGeneralMedicinesDetailsList();
}
