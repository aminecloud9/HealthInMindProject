package course.labs.healthinmind.screens;

import android.app.DatePickerDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import course.labs.healthinmind.R;
import course.labs.healthinmind.common.dependencyinjection.CompositionRoot;
import course.labs.healthinmind.common.dependencyinjection.ControllerCompositionRoot;
import course.labs.healthinmind.medecine.data.abstractions.MedicineFactory;
import course.labs.healthinmind.screens.views.BaseObservableViewMvc;
import course.labs.healthinmind.screens.views.BaseViewMvc;

public class AddMedicineControllerMvc extends ControllerCompositionRoot implements AddMedicine.Listener {


    public AddMedicineControllerMvc(CompositionRoot compositionRoot, FragmentActivity activity) {
        super(compositionRoot, activity);
    }

    @Override
    public void onButtonSaveClicked() {
        saveMedicine();
    }
    private void saveMedicine(){
        getAddMedicineUseCase().addMedicine();
    }
}
