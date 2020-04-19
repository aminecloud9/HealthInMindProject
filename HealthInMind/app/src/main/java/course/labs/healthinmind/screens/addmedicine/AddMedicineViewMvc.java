package course.labs.healthinmind.screens.addmedicine;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import course.labs.healthinmind.R;
import course.labs.healthinmind.screens.ViewMvcFactory;
import course.labs.healthinmind.screens.addmedicine.AddMedicine.AddMedicineViewListener;
import course.labs.healthinmind.screens.addmedicine.reminders.ReminderDto;
import course.labs.healthinmind.screens.addmedicine.reminders.RemindersRecyclerAdapter;
import course.labs.healthinmind.screens.views.BaseObservableViewMvc;

public class AddMedicineViewMvc extends BaseObservableViewMvc<AddMedicineViewListener> implements AddMedicine{



    private RemindersRecyclerAdapter remindersAdapter;
    private EditText etName;
    private EditText etDosage;
    private EditText etForm;
    private EditText etRefillQuantity;
    private EditText etMedicineStartDate;
    private EditText etMedicineEndDate;
    private EditText etInstructions;
    private EditText etQuantityToTake;
    private Button saveButton;
    private Switch refillReminderSwitch;
    private Switch medicineHasNoEndDateSwitch;
    private RecyclerView remindersRecycler;
    private AddMedicine.AddMedicineViewListener listener;
    private Button addReminderButton;
    public AddMedicineViewMvc(LayoutInflater layoutInflater, @Nullable ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        setRootView(layoutInflater.inflate(R.layout.add_medicine_view, parent, false));
        setUpComponents(viewMvcFactory);
        setUpSaveButtonClick();
        setUpAddReminderClick();


    }

    private void setUpComponents(ViewMvcFactory viewMvcFactory) {
        setUpRemindersRecyclerView(viewMvcFactory);
        etName = findViewById(R.id.medicine_name_edit_text_id_add_view);
        etDosage = findViewById(R.id.dosage_edit_text_id_add_view);
//        etForm = findViewById(R.id.form_edit_text_id_add_view);
        etRefillQuantity = findViewById(R.id.refill_quantity_edit_text_id_add_view);
        etMedicineStartDate = findViewById(R.id.medicine_start_date_edit_text_id_add_view);
        etMedicineEndDate = findViewById(R.id.medicine_end_date_edit_text_id_add_view);
//        etQuantityToTake = findViewById(R.id.quantity_to_take_edit_text_add_view);
        etInstructions = findViewById(R.id.medicine_instruction_edit_text_id_add_view);
        refillReminderSwitch = findViewById(R.id.switch1_add_view);
        medicineHasNoEndDateSwitch = findViewById(R.id.switch2_add_view);
        inflateCalenderSetDateFrom(etMedicineEndDate);
        saveButton = findViewById(R.id.save_medicine_button_id_add_view);
        addReminderButton = findViewById(R.id.btn_add_reminder);
    }

    private void setUpRemindersRecyclerView(ViewMvcFactory viewMvcFactory){
        remindersRecycler = findViewById(R.id.recycler_medicine_reminders_add_view);
        remindersAdapter = new RemindersRecyclerAdapter(viewMvcFactory);
        remindersRecycler.setAdapter(remindersAdapter);
        remindersRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setUpSaveButtonClick(){
        saveButton.setOnClickListener(v -> listener.onSaveClicked(
                setTextToString(etName),
                setTextToString(etForm),
                setTextToInt(etDosage),
                setTextToInt(etRefillQuantity),
                refillReminderSwitch.isActivated(),
                medicineHasNoEndDateSwitch.isActivated(),
                setTextToDate(etMedicineStartDate),
                setTextToDate(etMedicineEndDate),
                setTextToString(etInstructions),
                Double.parseDouble(setTextToString(etQuantityToTake)),
                remindersAdapter.getTakingTimes()
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
        remindersAdapter.addReminder(reminderDto);
    }
}
