package course.labs.healthinmind.screens.commons;

import android.content.Context;
import android.util.Log;

import course.labs.healthinmind.screens.addmedicine.AddMedicineActivity;

public class ScreensNavigator {

    private Context context;

    public ScreensNavigator(Context context) {
        this.context = context;
    }

    public void toAddMedicineActivity(){
        Log.i("toAddMedicineActivity:","AddMedicineActivity opened by screen navigator");
        AddMedicineActivity.start(context);
    }
}
