package course.labs.healthinmind.screens.home.homemedicineslist;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import course.labs.healthinmind.medecine.domain.showtodaymedicine.UpcomingMedicine;
import course.labs.healthinmind.screens.ViewMvcFactory;

public class HomeMedicinesAdapter extends RecyclerView.Adapter<HomeMedicinesAdapter.HomeMedicineViewHolder> {

    private List<UpcomingMedicine> medicines = new ArrayList<>();
    private ViewMvcFactory viewMvcFactory;

    public HomeMedicinesAdapter(ViewMvcFactory viewMvcFactory) {
        this.viewMvcFactory = viewMvcFactory;
    }

    static class HomeMedicineViewHolder extends RecyclerView.ViewHolder {
        HomeMedicineViewMvc viewMvc;
        public HomeMedicineViewHolder(@NonNull HomeMedicineViewMvc viewMvc) {
            super(viewMvc.getRootView());
            this.viewMvc = viewMvc;
        }
    }

    @NonNull
    @Override
    public HomeMedicineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        HomeMedicineViewMvc medicineView = viewMvcFactory.getHomeMedicineView(parent);
        return new HomeMedicineViewHolder(medicineView);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeMedicineViewHolder holder, int position) {
        holder.viewMvc.bindMedicine(medicines.get(position));
    }

    @Override
    public int getItemCount() {
        return medicines.size();
    }

    public void setMedicines(List<UpcomingMedicine> medicines){
        this.medicines = medicines;
        notifyDataSetChanged();
    }

    public void addMedicine(UpcomingMedicine medicineDto){
        medicines.add(medicineDto);
        notifyDataSetChanged();
    }
}
