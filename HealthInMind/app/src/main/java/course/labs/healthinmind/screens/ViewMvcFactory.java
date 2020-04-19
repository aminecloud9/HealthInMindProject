package course.labs.healthinmind.screens;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import course.labs.healthinmind.screens.addmedicine.AddMedicineViewMvc;
import course.labs.healthinmind.screens.addmedicine.AddReminderDialogWindow;
import course.labs.healthinmind.screens.addmedicine.reminders.ReminderView;
import course.labs.healthinmind.screens.addmedicine.reminders.StringQuantityMapper;

public class ViewMvcFactory {

    private final LayoutInflater mLayoutInflater;

    public ViewMvcFactory(LayoutInflater layoutInflater) {
        mLayoutInflater = layoutInflater;
    }

    public AddMedicineViewMvc getAddMedicineViewMvc(@Nullable ViewGroup parent){
        return new AddMedicineViewMvc(mLayoutInflater,parent,this);
    }

    public ReminderView getReminderView(@Nullable ViewGroup parent){
        return new ReminderView(mLayoutInflater,parent);
    }

    public AddReminderDialogWindow getAddReminderDialogWindow(ViewGroup parent, StringQuantityMapper quantityMapper){
        return new AddReminderDialogWindow(mLayoutInflater,parent,quantityMapper);
    }
}
