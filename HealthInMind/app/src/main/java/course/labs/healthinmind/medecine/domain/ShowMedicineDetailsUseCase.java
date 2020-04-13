package course.labs.healthinmind.medecine.domain;

import course.labs.healthinmind.medecine.data.abstractions.Medicine;
import course.labs.healthinmind.medecine.data.abstractions.MedicineRepository;

public class ShowMedicineDetailsUseCase {
    private MedicineRepository repository;

    public ShowMedicineDetailsUseCase(MedicineRepository repository) {
        this.repository = repository;
    }

    public Medicine fetchMedicine(int id){
            return repository.getMedicine(id);
        }
}
