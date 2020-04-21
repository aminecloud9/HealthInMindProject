package course.labs.healthinmind.screens.addmedicine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import java.util.Date;
import java.util.List;

import course.labs.healthinmind.common.Form;
import course.labs.healthinmind.common.dependencyinjection.Builders.medicinebuilders.MedicineBuilder;
import course.labs.healthinmind.common.dependencyinjection.Builders.medicinebuilders.MedicineCreationException;
import course.labs.healthinmind.medecine.data.abstractions.Medicine;
import course.labs.healthinmind.medecine.domain.addmedicineusecase.AddMedicineResponse;
import course.labs.healthinmind.medecine.domain.addmedicineusecase.AddMedicineUseCase;
import course.labs.healthinmind.medecine.domain.addmedicineusecase.CreateMedicineRequest;
import course.labs.healthinmind.screens.addmedicine.reminders.ReminderDto;
import course.labs.healthinmind.screens.commons.BaseActivity;

public class AddMedicineActivity
        extends BaseActivity
        implements AddMedicine.AddMedicineViewListener,
        AddReminderDialogController.DialogControllerListener, AddMedicineUseCase.AddMedicineUseCaseOutputPort {

    public static void start(Context context){
        Intent intent = new Intent(context,AddMedicineActivity.class);
        context.startActivity(intent);
    }

    private AddMedicineViewMvc view;
    private AddMedicineUseCase addMedicineUseCase;
    private AddReminderDialogController addReminderDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         addMedicineUseCase = getCompositionRoot().getAddMedicineUseCase(this);
        view = getCompositionRoot().
                getViewMvcFactory().
                getAddMedicineViewMvc(null);

        setContentView(view.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        view.registerListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        view.unregisterListener(this);
    }

    @Override
    public void onSaveClicked(String medicineName, Form form, int dosage, int refillQuantity, boolean refillReminder, boolean medicineHasNoEndDate, Date startDate, Date endDate, String instructions, List<ReminderDto> reminderDtoList) {
        MedicineBuilder builder = getCompositionRoot().getMedicineBuilder();
        builder
                .setMedicineName(medicineName)
                .setDosage(dosage)
                .setForm(form)
                .setRefillQuantity(refillQuantity)
                .setInstructions(instructions)
                .isPermanent(medicineHasNoEndDate)
                .toBeRemindedToRefill(refillReminder)
                .setStartingDate(startDate);
        if(!medicineHasNoEndDate){
            builder.addEndingDate(endDate);
        }
        Medicine medicine = null;
        try {
            medicine = builder.create();
        } catch (MedicineCreationException e) {
            e.printStackTrace();
        }

        AddMedicineResponse response
                = addMedicineUseCase
                .addMedicine(new CreateMedicineRequest(medicine,reminderDtoList));
        handleAddMedicineUseCaseResponse(response);

    }

    private void handleAddMedicineUseCaseResponse(AddMedicineResponse response) {
        finish();
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

    @Override
    public void onSuccess(AddMedicineResponse response) {

    }

    @Override
    public void onProgress() {

    }

    @Override
    public void onFailure(AddMedicineResponse response) {

    }
}
