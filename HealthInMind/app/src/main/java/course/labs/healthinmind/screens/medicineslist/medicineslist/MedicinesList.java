package course.labs.healthinmind.screens.medicineslist.medicineslist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import course.labs.healthinmind.R;
import course.labs.healthinmind.medecine.domain.showmedicineslist.GeneralMedicineDetails;
import course.labs.healthinmind.screens.views.BaseObservableViewMvc;

public class MedicinesList extends BaseObservableViewMvc {

    public interface Listener{
        void addMedicine(GeneralMedicineDetails medicine);
        void deleteMedicine(GeneralMedicineDetails medicine);
    }



    public MedicinesList(LayoutInflater layoutInflater, @Nullable ViewGroup parent){
        setRootView(layoutInflater.inflate(R.layout.items_list,parent,false));
    }
}
