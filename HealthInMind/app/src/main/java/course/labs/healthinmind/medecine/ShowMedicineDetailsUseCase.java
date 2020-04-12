package course.labs.healthinmind.medecine;

public class ShowMedicineDetailsUseCase {
    private MedicineRepository repository;

    public ShowMedicineDetailsUseCase(MedicineRepository repository) {
        this.repository = repository;
    }

    public Medicine fetchMedicine(int id){
            return repository.getMedicine(id);
        }
}
