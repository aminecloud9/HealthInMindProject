package course.labs.healthinmind.medecine.data.abstractions;

import java.util.List;

public interface MedicineRepository {

    Medicine getMedicine(long id);
    Long createMedicine(Medicine medicine);
    Medicine updateMedicine(Medicine medicine);
    void deleteMedicine(int id);

    List<Medicine> showExistingMedicines();
}
