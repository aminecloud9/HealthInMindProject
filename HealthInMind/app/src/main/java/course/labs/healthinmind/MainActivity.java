package course.labs.healthinmind;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import course.labs.healthinmind.common.CustomApplication;
import course.labs.healthinmind.screens.commons.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicines_view);

      //  getActionBar().setTitle("Add Medicine");
//        ViewPager viewPager = findViewById(R.id.home_image_slider);
//        ImageSlideAdapter imageSlideAdapter = new ImageSlideAdapter(this);
//        viewPager.setAdapter(imageSlideAdapter);
    }
}
