package course.labs.healthinmind.screens.addmedicine;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

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

public class AddMedicineViewMvc
        extends BaseObservableViewMvc<AddMedicineViewListener>
        implements AddMedicine, AdapterView.OnItemSelectedListener {



    private List<ReminderDto> reminders = new ArrayList<>();
    private List<ReminderView> reminderViews = new ArrayList<>();
    private Form selectedForm;
    private StringFormsMapper formsMapper;

    private EditText etName;
    private EditText etDosage;
    private EditText etRefillQuantity;
    private TextView etMedicineStartDate;
    private TextView etMedicineEndDate;
    private ImageButton btnStatingDate;
    private ImageButton btnEndingDate;
    private EditText etInstructions;
    private Spinner selectFormSpinner;
    private Button saveButton;
    private Switch refillReminderSwitch;
    private Switch medicineHasNoEndDateSwitch;
    private Button addReminderButton;
    private LinearLayout remindersContainer;
    private ViewMvcFactory viewMvcFactory;

    public AddMedicineViewMvc(LayoutInflater layoutInflater, @Nullable ViewGroup parent, StringFormsMapper formsMapper, ViewMvcFactory viewMvcFactory) {
        this.formsMapper = formsMapper;
        this.viewMvcFactory = viewMvcFactory;
        setRootView(layoutInflater.inflate(R.layout.add_medicine_view, parent, false));
        setUpComponents();
        setUpSaveButtonClick();
        setUpAddReminderClick();


    }

    private void setUpComponents() {
        remindersContainer = findViewById(R.id.reminders_container);
        etName = findViewById(R.id.medicine_name_edit_text_id_add_view);
        etDosage = findViewById(R.id.dosage_edit_text_id_add_view);
        etRefillQuantity = findViewById(R.id.refill_quantity_edit_text_id_add_view);
        etInstructions = findViewById(R.id.medicine_instruction_edit_text_id_add_view);
        refillReminderSwitch = findViewById(R.id.switch1_add_view);
        medicineHasNoEndDateSwitch = findViewById(R.id.switch2_add_view);
        saveButton = findViewById(R.id.save_medicine_button_id_add_view);
        addReminderButton = findViewById(R.id.btn_add_reminder);
        setUpStartingDateInput();
        setUpEndingDateInput();
        setUpFormsSpinner();
    }

    private void setUpEndingDateInput() {
        etMedicineEndDate = findViewById(R.id.medicine_end_date_edit_text_id_add_view);
        btnEndingDate = findViewById(R.id.btn_add_medicine_ending_date);
        inflateCalenderSetDateFrom(btnEndingDate,etMedicineEndDate);
    }

    private void setUpStartingDateInput() {
        etMedicineStartDate = findViewById(R.id.medicine_start_date_edit_text_id_add_view);
        btnStatingDate = findViewById(R.id.btn_add_medicine_starting_date);
        inflateCalenderSetDateFrom(btnStatingDate,etMedicineStartDate);
    }

    private void setUpFormsSpinner() {
        selectFormSpinner = findViewById(R.id.spinner_form_add_view);
        List<String> quantities = formsMapper.getStringArray();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getContext(),
                R.layout.spinner_text_view,
                quantities
        );

        adapter.setDropDownViewResource(R.layout.spinner_text_view);
        selectFormSpinner.setAdapter(adapter);
        selectFormSpinner.setOnItemSelectedListener(this);    }


    private void setUpSaveButtonClick() {
        saveButton.setOnClickListener(v -> {
            for (AddMedicineViewListener listener : getListeners()){
                listener.onSaveClicked(
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
                );
            }
        });
    }

    private void setUpAddReminderClick() {
        addReminderButton.setOnClickListener(view -> {
            for(AddMedicineViewListener listener : getListeners()){
                listener.onAddReminderClick();
            }
        });
    }

//    public void setListener(AddMedicineViewListener listener){
//        this.listener = listener;
//    }

    @Override
    public void addReminder(ReminderDto reminderDto) {
        ReminderView reminderView = viewMvcFactory.getReminderView(remindersContainer);
        reminders.add(reminderDto);
        reminderView.bindReminder(reminderDto);
        reminderViews.add(reminderView);
        remindersContainer.addView(reminderView.getRootView());
    }

    public void updateReminder(ReminderDto reminderDto, int position){
        reminderViews.get(position).bindReminder(reminderDto);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedForm = formsMapper.getValue((String) parent.getItemAtPosition(position));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
