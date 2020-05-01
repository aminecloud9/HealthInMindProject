package course.labs.healthinmind.screens.medicineslist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.annotation.UiThread;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import course.labs.healthinmind.R;
import course.labs.healthinmind.screens.ViewMvcFactory;
import course.labs.healthinmind.screens.home.EmptyListView;
import course.labs.healthinmind.screens.medicineslist.medicineslist.GeneralDisplayMedicineDetails;
import course.labs.healthinmind.screens.medicineslist.medicineslist.MedicinesListViewMvc;
import course.labs.healthinmind.screens.views.BaseObservableViewMvc;

public class AvailableMedicinesViewMvc extends BaseObservableViewMvc<AvailableMedicinesViewMvc.Listener> {

    public interface Listener{
        void onAddMedicinePressed();
    }

    private FrameLayout flMedicinesContainer;
    private FloatingActionButton addMedicineButton;
    private ViewMvcFactory factory;


    public AvailableMedicinesViewMvc(LayoutInflater layoutInflater, @Nullable ViewGroup parent, ViewMvcFactory factory){
        this.factory = factory;
        setRootView(layoutInflater.inflate(R.layout.medicines_view,parent,false));
        flMedicinesContainer = findViewById(R.id.medicines_list_container);
        setUpAddMedicineButton();
    }

    private void setUpAddMedicineButton() {
        addMedicineButton = findViewById(R.id.button_add);
        addMedicineButton.setOnClickListener(view -> {
            for (Listener listener : AvailableMedicinesViewMvc.this.getListeners()) {
                listener.onAddMedicinePressed();
            }
        });
    }

    @UiThread
    public void showMedicinesList(List<GeneralDisplayMedicineDetails> medicines){
        flMedicinesContainer.removeAllViews();
        MedicinesListViewMvc medicinesListViewMvc = factory.getMedicinesList(flMedicinesContainer, medicines);
        flMedicinesContainer.addView(medicinesListViewMvc.getRootView());
    }

    @UiThread
    public void showEmptyMedicinesList(){
        flMedicinesContainer.removeAllViews();
        EmptyListView emptyListView = factory.getEmptyListView(flMedicinesContainer,getString(R.string.no_medicines));
        flMedicinesContainer.addView(emptyListView.getRootView());
    }
}
