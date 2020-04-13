package course.labs.healthinmind.screens;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;

import course.labs.healthinmind.R;
import course.labs.healthinmind.medecine.data.abstractions.Medicine;
import course.labs.healthinmind.screens.views.BaseViewMvc;

public class MedicineDetailsViewMvc extends BaseViewMvc {
    private TextView dosage;
    private TextView form;
    private TextView frequency;
    private TextView refillQuantity;
    private TextView reminder;
    private TextView medicineStartDate;
    private TextView medicineEndDate;
    private TextView instructions;
    private Switch refillReminderSwitch;
    private Switch medicineHasNoEndDateSwitch;

    public void bindMedicineInfos(Medicine medicine){
        dosage.setText(medicine.getDosage());
        form.setText(medicine.getForm());
        frequency.setText(String.valueOf(medicine.getFrequency()));
        refillQuantity.setText(medicine.getRefillQuantity());

        refillReminderSwitch.setChecked(medicine.isRefillReminder());
        medicineStartDate.setText(medicine.getStartDate().toString());
        medicineEndDate.setText(medicine.getEndDate().toString());
        instructions.setText(medicine.getInstructions());
        medicineHasNoEndDateSwitch.setChecked(medicine.isMedicineHasNoEndDate());
        if (medicine.isMedicineHasNoEndDate()){
            medicineEndDate.setText("This medicine can't be stopped");
        }
        else {
            medicineEndDate.setText(medicine.getEndDate().toString());
        }
    }

    public MedicineDetailsViewMvc(LayoutInflater layoutInflater, @Nullable ViewGroup parent) {
        setRootView(layoutInflater.inflate(R.layout.medicine_detail_view,parent,false));
        setUpViewComponents();
    }

    private void setUpViewComponents() {
        dosage =findViewById(R.id.dosage_edit_text_id_detail_view);
        form = findViewById(R.id.form_edit_text_id_detail_view);
        frequency = findViewById(R.id.frequency_edit_text_id_detail_view);
        refillQuantity = findViewById(R.id.refill_quantity_edit_text_id_detail_view);
        reminder = findViewById(R.id.reminder_edit_text_id_detail_view);
        refillReminderSwitch = findViewById(R.id.switch1_detail_view);
        medicineStartDate = findViewById(R.id.medicine_start_date_edit_text_id_detail_view);
        medicineEndDate = findViewById(R.id.medicine_end_date_edit_text_id_detail_view);
        medicineHasNoEndDateSwitch = findViewById(R.id.switch2_detail_view);
        instructions = findViewById(R.id.medicine_instruction_edit_text_id_detail_view);
    }

}
