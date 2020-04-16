package course.labs.healthinmind.screens;

import android.app.DatePickerDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import course.labs.healthinmind.R;
import course.labs.healthinmind.common.dependencyinjection.ControllerCompositionRoot;
import course.labs.healthinmind.medecine.data.abstractions.MedicineFactory;
import course.labs.healthinmind.medecine.domain.AddMedicineUseCase;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineRoomImpl;
import course.labs.healthinmind.screens.views.BaseObservableViewMvc;

public class AddMedicineViewMvc extends BaseObservableViewMvc implements AddMedicine {
    final Calendar myCalendar = Calendar.getInstance();
    private RecyclerView remindersRecycler;
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

    public AddMedicineViewMvc(LayoutInflater layoutInflater, @Nullable ViewGroup parent, MedicineFactory medicineFactory) {
        setRootView(layoutInflater.inflate(R.layout.add_medicine_view, parent, false));
        setUpComponents();
        if (medicineHasNoEndDateSwitch.isActivated()) {
            medicineFactory.createMedicineThatDoesNotEnd(setTextToString(etName),
                    setTextToInt(etDosage), setTextToString(etForm), setTextToInt(etFrequency)
                    , setTextToInt(etRefillQuantity), refillReminderSwitch.isActivated(), setTextToDate(etMedicineStartDate),
                    Double.parseDouble(setTextToString(etQuantityToTake)), setTextToString(etInstructions), getTakingTimes());
        } else {
            medicineFactory.createMedicineThatEnds(etName.getText().toString(),
                    setTextToInt(etDosage), etForm.getText().toString(), setTextToInt(etFrequency)
                    , setTextToInt(etRefillQuantity), refillReminderSwitch.isActivated(), setTextToDate(etMedicineStartDate),
                    setTextToDate(etMedicineEndDate), Double.parseDouble(etQuantityToTake.getText().toString()),
                    etInstructions.getText().toString(), getTakingTimes());
        }
    }

    public void setUpComponents() {
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
        //.....
    }

    public List<LocalTime> getTakingTimes() {
        List<LocalTime> takingTimes = new ArrayList<>();
        for (EditText editTextreminder : findViewById(R.id.recycler_medicine_reminders_add_view).getContext()) {
            takingTimes.add(setTextToTime(editTextreminder));
        }
        return takingTimes;
    }

    public Date setTextToDate(EditText editText) {
        return DATE_FORMATEER.parse(setTextToString(editText));
    }

    public LocalTime setTextToTime(EditText editText) {
        return LocalTime.parse(setTextToString(editText));
    }

    public void updateLabel(EditText editText) {
        editText.setText(DATE_FORMATEER.format(myCalendar.getTime()));
    }

    public int setTextToInt(EditText editText) {
        return Integer.parseInt(setTextToString(editText));
    }

    public String setTextToString(EditText editText) {
        return editText.getText().toString();
    }


    public void inflateCalenderSetDateFrom(EditText editTextDate) {

        etMedicineStartDate.setOnClickListener(new View.OnClickListener() {
            DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    // TODO Auto-generated method stub
                    myCalendar.set(Calendar.YEAR, year);
                    myCalendar.set(Calendar.MONTH, monthOfYear);
                    myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    updateLabel(etMedicineStartDate);
                }

            };

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }


}
