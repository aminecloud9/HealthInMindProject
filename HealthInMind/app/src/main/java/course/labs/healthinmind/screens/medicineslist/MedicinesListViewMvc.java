package course.labs.healthinmind.screens.medicineslist;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import course.labs.healthinmind.R;
import course.labs.healthinmind.screens.ViewMvcFactory;
import course.labs.healthinmind.screens.views.BaseObservableViewMvc;

public class MedicinesListViewMvc extends BaseObservableViewMvc {

    private FrameLayout flMedicinesContainer;
    private ViewMvcFactory factory;

    public MedicinesListViewMvc(LayoutInflater layoutInflater, @Nullable ViewGroup parent, ViewMvcFactory factory){
        this.factory = factory;
        setRootView(layoutInflater.inflate(R.layout.medicines_view,parent,false));
        flMedicinesContainer = findViewById(R.id.medicines_list_container);
    }

    public void showMedicinesList(){

    }

    public void showEmptyMedicinesList(){

    }
}
