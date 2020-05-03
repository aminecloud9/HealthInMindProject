package course.labs.healthinmind.screens.addmedicine;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;

import java.util.Date;
import java.util.List;

import course.labs.healthinmind.common.AppExecutors;
import course.labs.healthinmind.common.Form;
import course.labs.healthinmind.common.dependencyinjection.Builders.medicinebuilders.MedicineBuilder;
import course.labs.healthinmind.common.dependencyinjection.Builders.medicinebuilders.MedicineCreationException;
import course.labs.healthinmind.medecine.data.abstractions.Medicine;
import course.labs.healthinmind.medecine.domain.addmedicineusecase.AddMedicineResponse;
import course.labs.healthinmind.medecine.domain.addmedicineusecase.AddMedicineUseCase;
import course.labs.healthinmind.medecine.domain.addmedicineusecase.CreateMedicineRequest;
import course.labs.healthinmind.screens.addmedicine.reminders.ReminderDto;
import course.labs.healthinmind.screens.commons.BaseFragment;
import course.labs.healthinmind.screens.commons.ScreensNavigator;

public class AddMedicineFragment extends BaseFragment implements AddMedicine.AddMedicineViewListener,
        AddReminderDialogController.DialogControllerListener,
        AddMedicineUseCase.AddMedicineUseCaseOutputPort{

    private AddMedicineViewMvc view;
    private AddMedicineUseCase addMedicineUseCase;
    private AddReminderDialogController addReminderDialog;
    private ScreensNavigator screensNavigator;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        addMedicineUseCase = getCompositionRoot().getAddMedicineUseCase(this);
        view = getCompositionRoot().
                getViewMvcFactory().
                getAddMedicineViewMvc(null,new StringFormsMapper(getContext()));
        this.screensNavigator = getCompositionRoot().getScreensNavigator();

        return view.getRootView();

    }

    @Override
    public void onStart() {
        super.onStart();
        view.registerListener(this);
    }

    @Override
    public void onStop() {
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

        addMedicineUseCase.addMedicine(new CreateMedicineRequest(medicine,reminderDtoList));
        screensNavigator.finishAddMedicine();
    }


    @Override
    public void onAddReminderClick() {
        openReminderCreationDialog();
    }

    private void openReminderCreationDialog() {
        addReminderDialog = getCompositionRoot().getAddReminderDialogController();
        addReminderDialog.setListener(this);
        addReminderDialog.show(requireFragmentManager());
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

    @UiThread
    @Override
    public void onSuccess(AddMedicineResponse response) {
        AppExecutors
                .getInstance()
                .mainThread()
                .execute(
                        () -> Toast.makeText(getContext(),"Medicine Added successfully",Toast.LENGTH_SHORT).show()
                );

    }

    @Override
    public void onProgress() {

    }
    @UiThread
    @Override
    public void onFailure(AddMedicineResponse response) {
        AppExecutors.getInstance().mainThread().execute(() -> Toast.makeText(getContext(),"An error accrued when adding medicine",Toast.LENGTH_SHORT).show());
    }

}
