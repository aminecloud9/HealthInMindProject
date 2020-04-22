package course.labs.healthinmind;


import android.os.Bundle;

import java.util.List;

import course.labs.healthinmind.common.AppExecutors;
import course.labs.healthinmind.medecine.domain.showtodaymedicine.GetTodayUpcomingMedicines;
import course.labs.healthinmind.medecine.domain.showtodaymedicine.GetTodayUpcomingMedicinesOutputPort;
import course.labs.healthinmind.medecine.domain.showtodaymedicine.UpcomingMedicine;
import course.labs.healthinmind.screens.addmedicine.AddMedicineActivity;
import course.labs.healthinmind.screens.commons.BaseActivity;
import course.labs.healthinmind.screens.commons.ScreensNavigator;
import course.labs.healthinmind.screens.home.HomeViewImpl;

public class MainActivity extends BaseActivity implements GetTodayUpcomingMedicinesOutputPort {
    private ScreensNavigator screensNavigator;
    private HomeViewImpl homeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        screensNavigator = getCompositionRoot().getScreensNavigator();

        super.onCreate(savedInstanceState);
        homeView = getCompositionRoot().getViewMvcFactory().getHomeView(null);
        GetTodayUpcomingMedicines useCase = getCompositionRoot().getTodayUpcomingMedicinesUseCase(this);
        useCase.getUpcomingMedicines();
        homeView.showEmptyUpcomingAppointments();
        setContentView(homeView.getRootView());

        //AddMedicineActivity.start(this);

//        FloatingActionButton buttonAddMedicine = findViewById(R.id.button_add);
//
//        buttonAddMedicine.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, AddMedicineViewMvc.class);
//                startActivityForResult(intent,1);
//            }
//        });

//        ViewPager viewPager = findViewById(R.id.home_image_slider);
//        ImageSlideAdapter imageSlideAdapter = new ImageSlideAdapter(this);
//        viewPager.setAdapter(imageSlideAdapter);
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
