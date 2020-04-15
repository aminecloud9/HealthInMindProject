package course.labs.healthinmind.medecine.domain;

import course.labs.healthinmind.medecine.data.abstractions.Medicine;
import course.labs.healthinmind.medecine.data.abstractions.MedicineRepository;

public class AddMedicineUseCase {
    MedicineRepository repository;

    public AddMedicineUseCase(MedicineRepository repository) {
        this.repository = repository;
    }

    public Long addMedicine(Medicine medicine){
        return repository.createMedicine(medicine);
    }
}
