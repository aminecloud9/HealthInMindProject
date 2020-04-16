package course.labs.healthinmind.screens;

import android.app.DatePickerDialog;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;

import java.text.ParseException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import course.labs.healthinmind.R;
import course.labs.healthinmind.medecine.data.abstractions.MedicineFactory;
import course.labs.healthinmind.screens.views.BaseObservableViewMvc;

public class AddMedicineViewMvc extends BaseObservableViewMvc<AddMedicine.Listener> implements AddMedicine {

    private static final String TAG_DATE_PARSE_ERROR = "date_parse_error";

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
    private RecyclerView recyclerReminders;
    Listener listener;

    public AddMedicineViewMvc(LayoutInflater layoutInflater, @Nullable ViewGroup parent, MedicineFactory medicineFactory) {
        setRootView(layoutInflater.inflate(R.layout.add_medicine_view, parent, false));
        setUpComponents();

        saveButton.setOnClickListener(v -> listener.onButtonSaveClicked(, , , , , , , , , , ));
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


    public List<LocalTime> getTakingTimes() {
        List<LocalTime> takingTimes = new ArrayList<>();
        for (int i=0 ; i < recyclerReminders.getChildCount(); i++) {
            takingTimes.add(setTextToTime(recyclerReminders.getChildItemId()));
        }
        return takingTimes;
    }

    public Date setTextToDate(EditText editText) {
        Date date = new Date();
        try {
            date = getDataFormat().parse(setTextToString(editText));
        } catch (ParseException e) {
            Log.e(TAG_DATE_PARSE_ERROR, Objects.requireNonNull(e.getMessage()));
        }

        return date;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public LocalTime setTextToTime(EditText editText) {
        return LocalTime.parse(setTextToString(editText));
    }

    public void updateLabel(EditText editText) {
        editText.setText(getDataFormat().format(myCalendar.getTime()));
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
