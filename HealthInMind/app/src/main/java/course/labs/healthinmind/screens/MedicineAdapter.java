package course.labs.healthinmind.screens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import course.labs.healthinmind.R;
import course.labs.healthinmind.medecine.data.abstractions.Medicine;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.MedicineHolder> {
    private List<Medicine> medicines ;
    private OnClickItemListener listener;

    @NonNull
    @Override
    public MedicineHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicines_medicine_view,parent,false);
        return new MedicineHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicineHolder holder, int position) {
        Medicine current = medicines.get(position);
        bindInfos(holder,current);
    }

    private void bindInfos(MedicineHolder holder,Medicine currentMedicine) {
        holder.medicineName.setText(currentMedicine.medicineName);
        holder.medicineDosage.setText(currentMedicine.dosage);
//        holder.medicineFrequency.setText(currentMedicine.getFrequency());
        holder.medicineInstructions.setText(currentMedicine.instructions);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MedicineHolder extends RecyclerView.ViewHolder {
        private TextView medicineName;
        private TextView medicineDosage;
        private TextView medicineFrequency;
        private TextView medicineInstructions;
        private ImageView medicineImage;

        public MedicineHolder(@NonNull View itemView) {
            super(itemView);
            medicineName = itemView.findViewById(R.id.medicine_name);
            medicineDosage = itemView.findViewById(R.id.medicine_dosage);
            medicineFrequency = itemView.findViewById(R.id.medicine_frequency);
            medicineInstructions = itemView.findViewById(R.id.medicine_added_by);
            medicineImage = itemView.findViewById(R.id.medicines_medicine_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(medicines.get(getAdapterPosition()));
                }
            });
        }
    }
    public interface OnClickItemListener{
        void onItemClick(Medicine medicine);
    }

    void setOnItemClickListener(OnClickItemListener listener){
        this.listener = listener;
    }
}
