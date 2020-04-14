package course.labs.healthinmind.screens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.annotation.Nullable;

import course.labs.healthinmind.R;
import course.labs.healthinmind.medecine.domain.AddMedicineUseCase;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineRoomImpl;
import course.labs.healthinmind.screens.views.BaseObservableViewMvc;

public class AddMedicineViewMvc extends BaseObservableViewMvc {
    AddMedicineUseCase addMedicineUseCase;
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

    public AddMedicineViewMvc(LayoutInflater layoutInflater, @Nullable ViewGroup parent) {
        setRootView(layoutInflater.inflate(R.layout.add_medicine_view, parent, false));
        setUpComponents();
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

//        //getActionBar().setTitle("Add Medicine");
//        saveButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addMedicineUseCase.addMedicine(new MedicineRoomImpl(etName.getText().toString(),etForm.getText().toString()
//                        ,Integer.parseInt(etDosage.getText().toString()),Integer.parseInt(etFrequency.getText().toString())
//                        ,Integer.parseInt(etRefillQuantity.getText().toString()),refillReminderSwitch.isActivated()
//                        ,new SimpleDateFormat("dd/MM/yyyy").parse(etMedicineStartDate.getText().toString())
//                        ,medicineHasNoEndDateSwitch.isActivated()
//                        ,new SimpleDateFormat("dd/MM/yyyy").parse(etMedicineEndDate.getText().toString())
//                        ,etInstructions.getText().toString(),Integer.parseInt(etQuantityToTake.toString()))) ;
//            }
//        });
    }
}
