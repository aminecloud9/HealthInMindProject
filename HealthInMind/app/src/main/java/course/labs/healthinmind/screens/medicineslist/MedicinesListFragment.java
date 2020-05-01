package course.labs.healthinmind.screens.medicineslist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import java.util.stream.Collectors;

import course.labs.healthinmind.common.dependencyinjection.Builders.displaybuilders.GeneralDisplayMedicineDetailsBuilder;
import course.labs.healthinmind.medecine.domain.showmedicineslist.GeneralMedicineDetails;
import course.labs.healthinmind.medecine.domain.showmedicineslist.ShowMedicinesUseCase;
import course.labs.healthinmind.screens.commons.BaseFragment;
import course.labs.healthinmind.screens.commons.ScreensNavigator;
import course.labs.healthinmind.screens.medicineslist.medicineslist.GeneralDisplayMedicineDetails;

public class MedicinesListFragment extends BaseFragment
        implements ShowMedicinesUseCase.ShowMedicinesUseCaseOutputPort,
        AvailableMedicinesViewMvc.Listener {

    private AvailableMedicinesViewMvc availableMedicinesViewMvc;
    private ShowMedicinesUseCase showMedicinesUseCase;
    private ScreensNavigator screensNavigator;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        availableMedicinesViewMvc = getCompositionRoot().getViewMvcFactory().getAvailableMedicinesViewMvc(container);
        showMedicinesUseCase = getCompositionRoot().getShowMedicinesUseCase();
        this.screensNavigator = getCompositionRoot().getScreensNavigator();
        return availableMedicinesViewMvc.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        availableMedicinesViewMvc.registerListener(this);
        showMedicinesUseCase.registerOutputPort(this);
        showMedicinesUseCase.showMedicines();
    }

    @Override
    public void showMedicinesList(List<GeneralMedicineDetails> medicines) {
        GeneralDisplayMedicineDetailsBuilder builder = getCompositionRoot().generalDisplayMedicineDetailsBuilder();
        List<GeneralDisplayMedicineDetails> displayedMedicines
                =
                medicines
                .stream()
                .map((medicine) -> builder
                        .setMedicineId(medicine.medicineId)
                        .setMedicineDosage(medicine.dosage)
                        .setMedicineName(medicine.medicineName)
                        .setFrequency(medicine.frequency)
                        .setMedicineForm(medicine.form)
                        .build()).collect(Collectors.toList());
        availableMedicinesViewMvc.showMedicinesList(displayedMedicines);
    }

    @Override
    public void handleNoMedicines() {
        availableMedicinesViewMvc.showEmptyMedicinesList();
    }

    @Override
    public void onAddMedicinePressed() {
        screensNavigator.toAddMedicine();
    }

    @Override
    public void onStop() {
        super.onStop();
        availableMedicinesViewMvc.unregisterListener(this);
    }
}
