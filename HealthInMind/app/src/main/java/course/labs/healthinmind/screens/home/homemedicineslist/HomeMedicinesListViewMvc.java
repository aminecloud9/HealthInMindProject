package course.labs.healthinmind.screens.home.homemedicineslist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import course.labs.healthinmind.R;
import course.labs.healthinmind.screens.ViewMvcFactory;
import course.labs.healthinmind.screens.views.BaseViewMvc;

public class HomeMedicinesListViewMvc extends BaseViewMvc {

    private HomeMedicinesAdapter adapter;

    public HomeMedicinesListViewMvc(LayoutInflater layoutInflater, @Nullable ViewGroup parent, ViewMvcFactory factory) {
        setRootView(layoutInflater.inflate(R.layout.items_list,parent,false));
        RecyclerView recyclerView = findViewById(R.id.generic_recycler);
        adapter = new HomeMedicinesAdapter(factory);
        recyclerView.setAdapter(adapter);
    }

    public void setMedicines(List<HomeMedicineDto> medicines) {
        adapter.setMedicines(medicines);
    }

    public void addMedicine(HomeMedicineDto medicine){
        adapter.addMedicine(medicine);
    }
}
