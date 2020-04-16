package course.labs.healthinmind.screens;

import android.app.DatePickerDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import course.labs.healthinmind.R;
import course.labs.healthinmind.medecine.data.abstractions.MedicineFactory;
import course.labs.healthinmind.screens.views.BaseObservableViewMvc;
import course.labs.healthinmind.screens.views.BaseViewMvc;

public class AddMedicineControllerMvc implements AddMedicine.Listener {

    public AddMedicineControllerMvc(LayoutInflater layoutInflater, @Nullable ViewGroup parent, MedicineFactory medicineFactory) {

    }

    @Override
    public void onButtonSaveClicked() {

    }
}
