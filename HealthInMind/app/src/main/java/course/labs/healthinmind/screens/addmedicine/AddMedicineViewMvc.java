package course.labs.healthinmind.screens.addmedicine;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import course.labs.healthinmind.R;
import course.labs.healthinmind.common.Form;
import course.labs.healthinmind.screens.ViewMvcFactory;
import course.labs.healthinmind.screens.addmedicine.AddMedicine.AddMedicineViewListener;
import course.labs.healthinmind.screens.addmedicine.reminders.ReminderDto;
import course.labs.healthinmind.screens.addmedicine.reminders.ReminderView;
import course.labs.healthinmind.screens.views.BaseObservableViewMvc;

public class AddMedicineViewMvc extends BaseObservableViewMvc<AddMedicineViewListener> implements AddMedicine{



    private List<ReminderDto> reminders = new ArrayList<>();
    private Form selectedForm;

    private EditText etName;
    private EditText etDosage;
    private EditText etRefillQuantity;
    private EditText etMedicineStartDate;
    private EditText etMedicineEndDate;
    private EditText etInstructions;

    private Button saveButton;
    private Switch refillReminderSwitch;
    private Switch medicineHasNoEndDateSwitch;
    private AddMedicine.AddMedicineViewListener listener;
    private Button addReminderButton;
    private LinearLayout remindersContainer;
    private ViewMvcFactory viewMvcFactory;

    public AddMedicineViewMvc(LayoutInflater layoutInflater, @Nullable ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        this.viewMvcFactory = viewMvcFactory;
        setRootView(layoutInflater.inflate(R.layout.add_medicine_view, parent, false));
        setUpComponents(viewMvcFactory);
        setUpSaveButtonClick();
        setUpAddReminderClick();


    }

    private void setUpComponents(ViewMvcFactory viewMvcFactory) {
        remindersContainer = findViewById(R.id.reminders_container);
        etName = findViewById(R.id.medicine_name_edit_text_id_add_view);
        etDosage = findViewById(R.id.dosage_edit_text_id_add_view);
        etRefillQuantity = findViewById(R.id.refill_quantity_edit_text_id_add_view);
        etMedicineStartDate = findViewById(R.id.medicine_start_date_edit_text_id_add_view);
        etMedicineEndDate = findViewById(R.id.medicine_end_date_edit_text_id_add_view);
        etInstructions = findViewById(R.id.medicine_instruction_edit_text_id_add_view);
        refillReminderSwitch = findViewById(R.id.switch1_add_view);
        medicineHasNoEndDateSwitch = findViewById(R.id.switch2_add_view);
        inflateCalenderSetDateFrom(etMedicineEndDate);
        saveButton = findViewById(R.id.save_medicine_button_id_add_view);
        addReminderButton = findViewById(R.id.btn_add_reminder);
    }


    private void setUpSaveButtonClick(){
        saveButton.setOnClickListener(v -> listener.onSaveClicked(
                setTextToString(etName),
                selectedForm,
                setTextToInt(etDosage),
                setTextToInt(etRefillQuantity),
                refillReminderSwitch.isActivated(),
                medicineHasNoEndDateSwitch.isActivated(),
                setTextToDate(etMedicineStartDate),
                setTextToDate(etMedicineEndDate),
                setTextToString(etInstructions),
                reminders
                )
        );
    }

    private void setUpAddReminderClick() {
        addReminderButton.setOnClickListener(view -> {
            listener.onAddReminderClick();
        });
    }

    public void setListener(AddMedicineViewListener listener){
        this.listener = listener;
    }

    @Override
    public void addReminder(ReminderDto reminderDto) {
        ReminderView reminderView = viewMvcFactory.getReminderView(remindersContainer);
        reminders.add(reminderDto);
        reminderView.bindReminder(reminderDto);
        remindersContainer.addView(reminderView.getRootView());
    }
}
