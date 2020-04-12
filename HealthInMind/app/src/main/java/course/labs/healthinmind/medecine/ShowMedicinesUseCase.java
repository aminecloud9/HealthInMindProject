package course.labs.healthinmind.medecine;

import java.util.List;

public class ShowMedicinesUseCase {
    private MedicineRepository repository;

    public ShowMedicinesUseCase(MedicineRepository repository) {
        this.repository = repository;
    }

    public List<Medicine> showMedicines(){
        return repository.showExistingMedicines();
    }
}
