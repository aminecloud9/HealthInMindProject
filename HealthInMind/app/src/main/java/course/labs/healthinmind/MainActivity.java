package course.labs.healthinmind;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import course.labs.healthinmind.screens.AddMedicineViewMvc;
import course.labs.healthinmind.screens.commons.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_medicine_view);

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
