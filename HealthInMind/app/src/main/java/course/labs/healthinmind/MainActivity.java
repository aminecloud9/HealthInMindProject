package course.labs.healthinmind;


import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import course.labs.healthinmind.screens.commons.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_container);
        NavController navController = Navigation.findNavController(this,R.id.nav_host_fragment);
        setUpBottomNavigation(navController);
    }

    private void setUpBottomNavigation(NavController navController) {
        BottomNavigationView navigationView = findViewById(R.id.nav_bottom_menu);
        NavigationUI.setupWithNavController(navigationView, navController);
    }


}
