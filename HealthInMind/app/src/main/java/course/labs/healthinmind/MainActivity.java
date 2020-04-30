package course.labs.healthinmind;


import android.os.Bundle;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;

import course.labs.healthinmind.common.AppExecutors;
import course.labs.healthinmind.medecine.domain.showtodaymedicine.GetTodayUpcomingMedicines;
import course.labs.healthinmind.medecine.domain.showtodaymedicine.GetTodayUpcomingMedicinesOutputPort;
import course.labs.healthinmind.medecine.domain.showtodaymedicine.UpcomingMedicine;
import course.labs.healthinmind.screens.addmedicine.AddMedicineActivity;
import course.labs.healthinmind.screens.commons.BaseActivity;
import course.labs.healthinmind.screens.commons.ScreensNavigator;
import course.labs.healthinmind.screens.home.HomeFragment;
import course.labs.healthinmind.screens.home.HomeViewImpl;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_container);

    }


}
