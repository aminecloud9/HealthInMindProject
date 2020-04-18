package course.labs.healthinmind.screens;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import course.labs.healthinmind.R;
import course.labs.healthinmind.medecine.data.abstractions.MedicineFactory;
import course.labs.healthinmind.reminders.data.abstractions.Reminder;
import course.labs.healthinmind.screens.views.BaseObservableViewMvc;

public class AddMedicineViewMvc extends BaseObservableViewMvc<AddMedicine.ListenerForReminders> implements AddMedicine {


    private RecyclerView remindersRecycler;
    private RemindersRecyclerAdapter remindersAdapter;
    private EditText etName;
    private EditText etDosage;
    private EditText etForm;
    private EditText etFrequency;
    private EditText etRefillQuantity;
    private EditText etMedicineStartDate;
    private EditText etMedicineEndDate;
    private EditText etInstructions;
    private EditText etQuantityToTake;
    private Button saveButton;
    private Switch refillReminderSwitch;
    private Switch medicineHasNoEndDateSwitch;
    private RecyclerView recyclerReminders;
    ListenerForButtonSave listener;

    public AddMedicineViewMvc(LayoutInflater layoutInflater, @Nullable ViewGroup parent) {
        setRootView(layoutInflater.inflate(R.layout.add_medicine_view, parent, false));
        setUpComponents();
        saveButton.setOnClickListener(v -> listener.onButtonSaveClicked(
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
                getTakingTimes())
        );
    }

    private void setUpComponents() {
        etName = findViewById(R.id.medicine_name_edit_text_id_add_view);
        etDosage = findViewById(R.id.dosage_edit_text_id_add_view);
        etForm = findViewById(R.id.form_edit_text_id_add_view);
        etFrequency = findViewById(R.id.frequency_edit_text_id_add_view);
        etRefillQuantity = findViewById(R.id.refill_quantity_edit_text_id_add_view);
        etMedicineStartDate = findViewById(R.id.medicine_start_date_edit_text_id_add_view);
        etMedicineEndDate = findViewById(R.id.medicine_end_date_edit_text_id_add_view);
        etQuantityToTake = findViewById(R.id.quantity_to_take_edit_text_add_view);
        etInstructions = findViewById(R.id.medicine_instruction_edit_text_id_add_view);
        refillReminderSwitch = findViewById(R.id.switch1_add_view);
        medicineHasNoEndDateSwitch = findViewById(R.id.switch2_add_view);
        inflateCalenderSetDateFrom(etMedicineEndDate);
        recyclerReminders = findViewById(R.id.recycler_medicine_reminders_add_view);
        //.....
    }


//    public List<LocalTime> getTakingTimes() {
//        List<LocalTime> takingTimes = new ArrayList<>();
//        for (int i = 0; i < RemindersRecyclerAdapter; i++) {
//            takingTimes.add(setTextToTime(recyclerReminders.getChildItemId()));
//        }
//        return takingTimes;
//    }

    public void onReminderClicked(ReminderDto reminderDto) {
        for (ListenerForReminders listener : getListeners()) {
            listener.onReminderClicked(reminderDto);
        }
    }

    public void bindReminders(Reminder reminder){

    }
}
