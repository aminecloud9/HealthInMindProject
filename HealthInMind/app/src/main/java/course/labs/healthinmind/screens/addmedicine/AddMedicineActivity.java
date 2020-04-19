package course.labs.healthinmind.screens.addmedicine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import course.labs.healthinmind.medecine.data.abstractions.Medicine;
import course.labs.healthinmind.medecine.data.abstractions.MedicineFactory;
import course.labs.healthinmind.medecine.domain.AddMedicineUseCase;
import course.labs.healthinmind.screens.addmedicine.reminders.ReminderDto;
import course.labs.healthinmind.screens.commons.BaseActivity;

public class AddMedicineActivity
        extends BaseActivity
        implements AddMedicine.AddMedicineViewListener,
        AddReminderDialogController.DialogControllerListener {

    public static void start(Context context){
        Intent intent = new Intent(context,AddMedicineActivity.class);
        context.startActivity(intent);
    }

    private AddMedicineViewMvc view;
    private AddMedicineUseCase addMedicineUseCase;
    private MedicineFactory medicineFactory;
    private AddReminderDialogController addReminderDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         addMedicineUseCase = getCompositionRoot().getAddMedicineUseCase();
         medicineFactory = getCompositionRoot().getMedicineFactory();
        view = getCompositionRoot().
                getViewMvcFactory().
                getAddMedicineViewMvc(null);
        view.setListener(this);
        setContentView(view.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onSaveClicked(String medicineName, String form, int dosage, int refillQuantity, boolean refillReminder, boolean medicineHasNoEndDate, Date startDate, Date endDate, String instructions, double quantityToTake, List<LocalTime> takingTimes) {
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

    @Override
    public void onAddReminderClick() {
        openReminderCreationDialog();
    }

    private void openReminderCreationDialog() {
        addReminderDialog = getCompositionRoot().getAddReminderDialogController();
        addReminderDialog.setListener(this);
        addReminderDialog.show(getSupportFragmentManager());
    }

    @Override
    public void onValidate(ReminderDto reminderDto) {
        view.addReminder(reminderDto);
        addReminderDialog.dismiss();
    }

    @Override
    public void onCancel() {
        addReminderDialog.dismiss();
    }
}
