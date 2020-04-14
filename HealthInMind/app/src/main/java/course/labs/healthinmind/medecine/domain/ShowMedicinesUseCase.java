package course.labs.healthinmind.medecine.domain;

import java.util.List;

import course.labs.healthinmind.medecine.data.abstractions.Medicine;
import course.labs.healthinmind.medecine.data.abstractions.MedicineRepository;

public class ShowMedicinesUseCase {
    private MedicineRepository repository;

    public ShowMedicinesUseCase(MedicineRepository repository) {
        this.repository = repository;
    }

    public List<Medicine> showMedicines(){
        return repository.showExistingMedicines();
    }
}
