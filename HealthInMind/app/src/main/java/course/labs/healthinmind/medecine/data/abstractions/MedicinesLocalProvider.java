package course.labs.healthinmind.medecine.data.abstractions;

import java.util.List;

public interface MedicinesLocalProvider {
    Medicine getMedicine(int id);
    Long createMedicine(Medicine medicine);
    Medicine updateMedicine(Medicine medicine);
    void deleteMedicine(int id);

    List<Medicine> showExistantMedicines();
}
