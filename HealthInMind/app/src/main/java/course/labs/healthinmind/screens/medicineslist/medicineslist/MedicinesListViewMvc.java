package course.labs.healthinmind.screens.medicineslist.medicineslist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import course.labs.healthinmind.R;
import course.labs.healthinmind.medecine.domain.showmedicineslist.GeneralMedicineDetails;
import course.labs.healthinmind.screens.ViewMvcFactory;
import course.labs.healthinmind.screens.views.BaseObservableViewMvc;

public class MedicinesListViewMvc extends BaseObservableViewMvc {

    private ViewMvcFactory viewMvcFactory;

    public interface Listener{
        void addMedicine(GeneralMedicineDetails medicine);
        void deleteMedicine(GeneralMedicineDetails medicine);
    }

    private MedicinesAdapter adapter;

    public MedicinesListViewMvc(LayoutInflater layoutInflater, @Nullable ViewGroup parent, ViewMvcFactory viewMvcFactory, List<GeneralDisplayMedicineDetails> medicines){
        this.viewMvcFactory = viewMvcFactory;
        setRootView(layoutInflater.inflate(R.layout.items_list,parent,false));
        setUpRecyclerView(medicines);
    }

    private void setUpRecyclerView(List<GeneralDisplayMedicineDetails> medicines) {
        RecyclerView recyclerView = findViewById(R.id.generic_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MedicinesAdapter(viewMvcFactory);
        adapter.setMedicines(medicines);
        recyclerView.setAdapter(adapter);
    }


}
