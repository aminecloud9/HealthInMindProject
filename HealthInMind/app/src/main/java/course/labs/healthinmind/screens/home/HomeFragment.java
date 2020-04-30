package course.labs.healthinmind.screens.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import course.labs.healthinmind.common.AppExecutors;
import course.labs.healthinmind.medecine.domain.showtodaymedicine.GetTodayUpcomingMedicines;
import course.labs.healthinmind.medecine.domain.showtodaymedicine.GetTodayUpcomingMedicinesOutputPort;
import course.labs.healthinmind.medecine.domain.showtodaymedicine.UpcomingMedicine;
import course.labs.healthinmind.screens.commons.BaseFragment;

public class HomeFragment extends BaseFragment implements GetTodayUpcomingMedicinesOutputPort {
    private HomeViewImpl homeView;
    private GetTodayUpcomingMedicines showMedicinesUseCase;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeView = getCompositionRoot().getViewMvcFactory().getHomeView(container);
        showMedicinesUseCase = getCompositionRoot().getTodayUpcomingMedicinesUseCase(this);
        return homeView.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        showMedicinesUseCase.getUpcomingMedicines();
    }

    @Override
    public void onNoUpcomingMedicines() {
        AppExecutors.getInstance().mainThread().execute(() ->{
            homeView.showEmptyMedicines();
        });

    }

    @Override
    public void onUpcomingMedicines(List<UpcomingMedicine> upcomingMedicine) {
        AppExecutors.getInstance().mainThread().execute(() ->{
            homeView.showMedicinesList(upcomingMedicine);
        });

    }
}
