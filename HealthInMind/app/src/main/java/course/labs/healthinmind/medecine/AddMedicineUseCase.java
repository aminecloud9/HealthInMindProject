package course.labs.healthinmind.medecine;

public class AddMedicineUseCase {
    MedicineRepository repository;

    public AddMedicineUseCase(MedicineRepository repository) {
        this.repository = repository;
    }

    public MedicineRoomImpl addMedicine(MedicineRoomImpl medicineRoomImpl){
        return repository.createMedicine(medicineRoomImpl);
    }
}
