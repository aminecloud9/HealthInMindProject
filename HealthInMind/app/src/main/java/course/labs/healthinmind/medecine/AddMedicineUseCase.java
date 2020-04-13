package course.labs.healthinmind.medecine;

public class AddMedicineUseCase {
    MedicineRepository repository;

    public AddMedicineUseCase(MedicineRepository repository) {
        this.repository = repository;
    }

    public Medicine addMedicine(Medicine medicine){
        return repository.createMedicine(medicine);
    }
}
