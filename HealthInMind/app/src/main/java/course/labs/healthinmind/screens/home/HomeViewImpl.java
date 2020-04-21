package course.labs.healthinmind.screens.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import course.labs.healthinmind.R;
import course.labs.healthinmind.screens.ViewMvcFactory;
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
        EmptyListView emptyListView = viewMvcFactory.getEmptyListView(flMedicinesContainer,getString(R.string.no_medicines));
        flMedicinesContainer.removeAllViews();
        flMedicinesContainer.addView(emptyListView.getRootView());
    }

    @Override
    public void showMedicinesList() {

    }

    @Override
    public void showEmptyUpcomingAppointments() {
        EmptyListView emptyListView = viewMvcFactory.getEmptyListView(flAppointmentsContainer,getString(R.string.no_appointments));
        flAppointmentsContainer.removeAllViews();
        flAppointmentsContainer.addView(emptyListView.getRootView());
    }

    @Override
    public void showUpcomingAppointments() {

    }
}
