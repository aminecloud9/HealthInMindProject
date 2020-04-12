package course.labs.healthinmind.screens;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.annotation.Nullable;

import course.labs.healthinmind.R;
import course.labs.healthinmind.screens.views.BaseObservableViewMvc;

public class AddMedicineViewMvc extends BaseObservableViewMvc {
    private EditText etDosage;
    private EditText etForm;
    private EditText etFrequency;
    private EditText etRefillQuantity;
    private EditText etReminder;
    private EditText etMedicineStartDate;
    private EditText etMedicineEndDate;
    private EditText etInstructions;
    private Button saveButton;
    private Switch refillReminderSwitch;
    private Switch medicineHasNoEndDateSwitch;

    public AddMedicineViewMvc(LayoutInflater layoutInflater,@Nullable ViewGroup parent) {
        setRootView(layoutInflater.inflate(R.layout.add_medicine_view,parent,false));
        setUpComponents();
    }

    private void setUpComponents() {
    }

}
