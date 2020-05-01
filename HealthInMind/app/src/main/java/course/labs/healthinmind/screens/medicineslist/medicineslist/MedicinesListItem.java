package course.labs.healthinmind.screens.medicineslist.medicineslist;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import course.labs.healthinmind.R;
import course.labs.healthinmind.screens.views.BaseViewMvc;

public class MedicinesListItem extends BaseViewMvc {

    private ImageView formIcon;
    private TextView medicineName;
    private TextView medicineDosage;
    private TextView medicineFrequency;

    public MedicinesListItem(LayoutInflater layoutInflater, @Nullable ViewGroup parent){
        setRootView(layoutInflater.inflate(R.layout.medicines_medicine_view,parent,false));
        formIcon = findViewById(R.id.medicines_medicine_image);
        medicineName = findViewById(R.id.medicine_name);
        medicineDosage = findViewById(R.id.medicine_dosage);
        medicineFrequency = findViewById(R.id.medicine_frequency);
    }

    public void bindMedicine(GeneralDisplayMedicineDetails medicine){
        medicineName.setText(medicine.medicineName);
        medicineDosage.setText(String.valueOf(medicine.dosage));
        medicineFrequency.setText(String.valueOf(medicine.frequency));
    }
}
