package course.labs.healthinmind.screens;

import android.os.Bundle;

import androidx.annotation.Nullable;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import course.labs.healthinmind.medecine.data.abstractions.Medicine;
import course.labs.healthinmind.medecine.data.abstractions.MedicineFactory;
import course.labs.healthinmind.medecine.domain.AddMedicineUseCase;
import course.labs.healthinmind.screens.commons.BaseActivity;

public class AddMedicineActivity extends BaseActivity implements AddMedicineViewMvc.Listener{


    private AddMedicineViewMvc view;
    private AddMedicineUseCase addMedicineUseCase;
    private MedicineFactory medicineFactory;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         addMedicineUseCase = getCompositionRoot().getAddMedicineUseCase();
         medicineFactory = getCompositionRoot().getMedicineFactory();
        view = getCompositionRoot().
                getViewMvcFactory().
                getAddMedicineViewMvc(null,getCompositionRoot().getMedicineFactory());
        setContentView(view.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        view.registerListener(this);
    }

    @Override
    public void onButtonSaveClicked(String medicineName, String form, int dosage, int refillQuantity, boolean refillReminder, boolean medicineHasNoEndDate, Date startDate, Date endDate, String instructions, double quantityToTake, List<LocalTime> takingTimes) {
        Medicine medicine;
        if(medicineHasNoEndDate){
            medicine = medicineFactory.createMedicineThatDoesNotEnd(
                    medicineName,
                    dosage,
                    form,
                    takingTimes.size(),
                    refillQuantity,
                    refillReminder,
                    startDate,
                    quantityToTake,
                    instructions,
                    takingTimes
            );
        }else {
            medicine = medicineFactory.createMedicineThatEnds(
                    medicineName,
                    dosage,
                    form,
                    takingTimes.size(),
                    refillQuantity,
                    refillReminder,
                    startDate,
                    endDate,
                    quantityToTake,
                    instructions,
                    takingTimes
            );
        }
        addMedicineUseCase.addMedicine(medicine);
    }
}
