package course.labs.healthinmind.screens.medicineslist.medicineslist;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import course.labs.healthinmind.screens.ViewMvcFactory;

public class MedicinesAdapter extends RecyclerView.Adapter<MedicinesAdapter.MedicinesViewHolder> {

    private List<GeneralDisplayMedicineDetails> medicines;
    private ViewMvcFactory viewMvcFactory;

    public MedicinesAdapter(ViewMvcFactory viewMvcFactory) {
        this.viewMvcFactory = viewMvcFactory;
    }

    public static class MedicinesViewHolder extends RecyclerView.ViewHolder {
        MedicinesListItemViewMvc medicinesListItemViewMvc;
        public MedicinesViewHolder(@NonNull MedicinesListItemViewMvc medicinesListItemViewMvc) {
            super(medicinesListItemViewMvc.getRootView());
            this.medicinesListItemViewMvc = medicinesListItemViewMvc;
        }
    }

    @NonNull
    @Override
    public MedicinesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MedicinesListItemViewMvc medicinesListItemViewMvc = viewMvcFactory.getMedicinesListItemViewMvc(parent);
        return new MedicinesViewHolder(medicinesListItemViewMvc);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicinesViewHolder holder, int position) {
        holder.medicinesListItemViewMvc.bindMedicine(medicines.get(position));
    }

    @Override
    public int getItemCount() {
        return medicines.size();
    }

    public void setMedicines(List<GeneralDisplayMedicineDetails> medicines){
        this.medicines = medicines;
        notifyDataSetChanged();
    }

}
