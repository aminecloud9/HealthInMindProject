package course.labs.healthinmind.screens;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import course.labs.healthinmind.medecine.data.abstractions.MedicineFactory;

public class ViewMvcFactory {

    private final LayoutInflater mLayoutInflater;

    public ViewMvcFactory(LayoutInflater layoutInflater) {
        mLayoutInflater = layoutInflater;
    }

    public AddMedicineViewMvc getAddMedicineViewMvc(@Nullable ViewGroup parent, MedicineFactory medicineFactory){
        return new AddMedicineViewMvc(mLayoutInflater,parent,medicineFactory);
    }

}
