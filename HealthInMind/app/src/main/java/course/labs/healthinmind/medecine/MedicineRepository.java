package course.labs.healthinmind.medecine;

import java.util.List;

public interface MedicineRepository {

    Medicine getMedicine(int id);
    Medicine createMedicine(Medicine medicine);
    Medicine updateMedicine(Medicine medicine);
    void deleteMedicine(int id);

    List<Medicine> showExistingMedicines();
}
