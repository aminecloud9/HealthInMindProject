package course.labs.healthinmind.screens;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import java.util.List;

import course.labs.healthinmind.medecine.domain.showmedicineslist.GeneralMedicineDetails;
import course.labs.healthinmind.screens.addmedicine.AddMedicineViewMvc;
import course.labs.healthinmind.screens.addmedicine.AddReminderDialogWindow;
import course.labs.healthinmind.screens.addmedicine.StringFormsMapper;
import course.labs.healthinmind.screens.addmedicine.reminders.ReminderView;
import course.labs.healthinmind.screens.addmedicine.reminders.StringQuantityMapper;
import course.labs.healthinmind.screens.home.EmptyListView;
import course.labs.healthinmind.screens.home.HomeViewImpl;
import course.labs.healthinmind.screens.home.homemedicineslist.HomeMedicineViewMvc;
import course.labs.healthinmind.screens.home.homemedicineslist.HomeMedicinesListViewMvc;
import course.labs.healthinmind.screens.medicineslist.AvailableMedicinesViewMvc;
import course.labs.healthinmind.screens.medicineslist.medicineslist.GeneralDisplayMedicineDetails;
import course.labs.healthinmind.screens.medicineslist.medicineslist.MedicinesListViewMvc;
import course.labs.healthinmind.screens.medicineslist.medicineslist.MedicinesListItemViewMvc;

public class ViewMvcFactory {

    private final LayoutInflater mLayoutInflater;

    public ViewMvcFactory(LayoutInflater layoutInflater) {
        mLayoutInflater = layoutInflater;
    }

    public AddMedicineViewMvc getAddMedicineViewMvc(@Nullable ViewGroup parent, StringFormsMapper stringFormsMapper){
        return new AddMedicineViewMvc(mLayoutInflater,parent,stringFormsMapper,this);
    }

    public ReminderView getReminderView(@Nullable ViewGroup parent){
        return new ReminderView(mLayoutInflater,parent);
    }

    public AddReminderDialogWindow getAddReminderDialogWindow(ViewGroup parent, StringQuantityMapper quantityMapper){
        return new AddReminderDialogWindow(mLayoutInflater,parent,quantityMapper);
    }

    public EmptyListView getEmptyListView(ViewGroup parent, String displayedMessage){
        return new EmptyListView(mLayoutInflater,parent, displayedMessage);
    }

    public HomeMedicineViewMvc getHomeMedicineView(@Nullable ViewGroup parent) {
        return new HomeMedicineViewMvc(mLayoutInflater,parent);
    }

    public HomeMedicinesListViewMvc getHomeMedicinesListViewMvc(@Nullable ViewGroup parent){
        return new HomeMedicinesListViewMvc(mLayoutInflater,parent,this);
    }

    public HomeViewImpl getHomeView(@Nullable ViewGroup parent){
        return new HomeViewImpl(mLayoutInflater,parent,this);
    }

    public MedicinesListItemViewMvc getMedicinesListItemViewMvc(@Nullable ViewGroup parent) {
        return new MedicinesListItemViewMvc(mLayoutInflater, parent);
    }

    public MedicinesListViewMvc getMedicinesList(ViewGroup parent, List<GeneralDisplayMedicineDetails> medicines){
        return new MedicinesListViewMvc(mLayoutInflater,parent,this,medicines);
    }

    public AvailableMedicinesViewMvc getAvailableMedicinesViewMvc(@Nullable ViewGroup parent){
        return new AvailableMedicinesViewMvc(mLayoutInflater,parent,this);
    }


}
