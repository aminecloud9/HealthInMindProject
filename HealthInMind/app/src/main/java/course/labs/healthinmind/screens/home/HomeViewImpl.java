package course.labs.healthinmind.screens.home;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import java.util.List;

import course.labs.healthinmind.R;
import course.labs.healthinmind.screens.ViewMvcFactory;
import course.labs.healthinmind.medecine.domain.showtodaymedicine.UpcomingMedicine;
import course.labs.healthinmind.screens.home.homemedicineslist.HomeMedicinesListViewMvc;
import course.labs.healthinmind.screens.views.BaseViewMvc;

public class HomeViewImpl extends BaseViewMvc implements HomeView{

    private FrameLayout flMedicinesContainer;
    private FrameLayout flAppointmentsContainer;
    private ViewMvcFactory viewMvcFactory;
    public HomeViewImpl(LayoutInflater layoutInflater, @Nullable ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        this.viewMvcFactory = viewMvcFactory;
        setRootView(layoutInflater.inflate(R.layout.home_view, parent, false));
        flMedicinesContainer = findViewById(R.id.medicines_container);
        flAppointmentsContainer = findViewById(R.id.appointments_container);
    }

    @Override
    public void showEmptyMedicines() {
        Log.d("UpcomingMedicines","showEmptyMedicines");
        EmptyListView emptyListView = viewMvcFactory.getEmptyListView(flMedicinesContainer,getString(R.string.no_medicines));
        flMedicinesContainer.removeAllViews();
        flMedicinesContainer.addView(emptyListView.getRootView());
    }

    @Override
    public void showMedicinesList(List<UpcomingMedicine> medicines) {
        Log.d("UpcomingMedicines","showMedicinesList");
        HomeMedicinesListViewMvc medicinesListViewMvc = viewMvcFactory.getHomeMedicinesListViewMvc(flMedicinesContainer);
        medicinesListViewMvc.setMedicines(medicines);
        flMedicinesContainer.removeAllViews();
        flMedicinesContainer.addView(medicinesListViewMvc.getRootView());
    }

    @Override
    public void showEmptyUpcomingAppointments() {
        Log.d("UpcomingMedicines","showEmptyUpcomingAppointments");
        EmptyListView emptyListView = viewMvcFactory.getEmptyListView(flAppointmentsContainer,getString(R.string.no_appointments));
        flAppointmentsContainer.removeAllViews();
        flAppointmentsContainer.addView(emptyListView.getRootView());
    }

    @Override
    public void showUpcomingAppointments() {
        Log.d("UpcomingMedicines","showUpcomingAppointments");
    }
}
