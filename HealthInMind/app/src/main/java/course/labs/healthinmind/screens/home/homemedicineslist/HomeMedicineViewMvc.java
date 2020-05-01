package course.labs.healthinmind.screens.home.homemedicineslist;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.Locale;

import course.labs.healthinmind.R;
import course.labs.healthinmind.medecine.domain.showtodaymedicine.UpcomingMedicine;
import course.labs.healthinmind.screens.FormIconLoader;
import course.labs.healthinmind.screens.addmedicine.reminders.StringQuantityMapper;
import course.labs.healthinmind.screens.views.BaseViewMvc;

public class HomeMedicineViewMvc extends BaseViewMvc {

    private TextView tvMedicineTime;
    private TextView tvMedicineDescription;
    private ImageView ivMedicineFormImage;
    private TextView tvMedicineQuantity;
    private StringQuantityMapper mapper;
    private FormIconLoader formIconLoader;

    public HomeMedicineViewMvc(LayoutInflater layoutInflater, @Nullable ViewGroup parent){
        setRootView(layoutInflater.inflate(R.layout.home_medicine_view,parent,false));
        setUpComponents();
        mapper = new StringQuantityMapper(getContext());
        formIconLoader = new FormIconLoader(getContext());
    }

    private void setUpComponents() {
        tvMedicineTime = findViewById(R.id.txt_home_medicine_time);
        tvMedicineDescription = findViewById(R.id.txt_home_medicine_name_dose);
        tvMedicineQuantity = findViewById(R.id.txt_home_medicine_quantity_to_take);
        ivMedicineFormImage = findViewById(R.id.image_home_medicine);
    }

    public void bindMedicine(UpcomingMedicine medicine){
        tvMedicineTime.setText(medicine.time.toString());
        tvMedicineDescription.setText(String.format(Locale.ENGLISH,"%s %d",medicine.medicineName,medicine.dosage));
        tvMedicineQuantity.setText(mapper.getString(medicine.takingQuantity));
        formIconLoader.loadFormIcon(medicine.form,ivMedicineFormImage);
    }
}
