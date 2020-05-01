package course.labs.healthinmind.medecine.domain.showmedicineslist;

import java.util.List;

import course.labs.healthinmind.medecine.data.abstractions.Medicine;
import course.labs.healthinmind.medecine.data.abstractions.MedicineRepository;

public class ShowMedicinesUseCase {

    public interface ShowMedicinesUseCaseOutputPort{
        void showMedicinesList(List<GeneralMedicineDetails> medicines);
        void handleNoMedicines();
    }

    ShowMedicinesUseCaseOutputPort outputPort;

    private MedicineRepository repository;

    public ShowMedicinesUseCase(MedicineRepository repository) {
        this.repository = repository;
    }

    public void showMedicines(){
        outputPort.handleNoMedicines();
    }

    public void registerOutputPort(ShowMedicinesUseCaseOutputPort outputPort){
        this.outputPort = outputPort;
    }

}
