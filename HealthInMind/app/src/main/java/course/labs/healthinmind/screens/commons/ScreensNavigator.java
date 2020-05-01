package course.labs.healthinmind.screens.commons;

import android.content.Context;
import android.util.Log;

import androidx.navigation.NavController;

import course.labs.healthinmind.R;
import course.labs.healthinmind.screens.addmedicine.AddMedicineActivity;

public class ScreensNavigator {

    private NavController navController;

    public ScreensNavigator(NavController navController) {
        this.navController = navController;
    }

    public void toAddMedicine(){
        navController.navigate(R.id.action_medicines_to_add_medicine);
    }

    public void finishAddMedicine(){
        navController.navigate(R.id.action_finish_add_medicine);
    }
}
