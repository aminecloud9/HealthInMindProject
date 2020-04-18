package course.labs.healthinmind;


import android.os.Bundle;

import course.labs.healthinmind.screens.commons.BaseActivity;
import course.labs.healthinmind.screens.commons.ScreensNavigator;

public class MainActivity extends BaseActivity {
    private ScreensNavigator screensNavigator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        screensNavigator = getCompositionRoot().getScreensNavigator();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_medicine_view);
        if(savedInstanceState == null){
            screensNavigator.toAddMedicineActivity();
        }

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
}
