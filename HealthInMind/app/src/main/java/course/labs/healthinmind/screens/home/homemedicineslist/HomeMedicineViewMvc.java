package course.labs.healthinmind.screens.home.homemedicineslist;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.time.LocalTime;
import java.util.Locale;

import course.labs.healthinmind.R;
import course.labs.healthinmind.common.Form;
import course.labs.healthinmind.common.Quantity;
import course.labs.healthinmind.screens.ImageFormMapper;
import course.labs.healthinmind.screens.addmedicine.reminders.StringQuantityMapper;
import course.labs.healthinmind.screens.views.BaseViewMvc;

public class HomeMedicineViewMvc extends BaseViewMvc {

    private TextView tvMedicineTime;
    private TextView tvMedicineDescription;
    private ImageView ivMedicineFormImage;
    private TextView tvMedicineQuantity;
    private StringQuantityMapper mapper;
    private ImageFormMapper formMapper;

    public HomeMedicineViewMvc(LayoutInflater layoutInflater, @Nullable ViewGroup parent){
        setRootView(layoutInflater.inflate(R.layout.home_medicine_view,parent,false));
        setUpComponents();
    }

    private void setUpComponents() {
        tvMedicineTime = findViewById(R.id.txt_home_medicine_time);
        tvMedicineDescription = findViewById(R.id.txt_home_medicine_name_dose);
        tvMedicineQuantity = findViewById(R.id.txt_home_medicine_quantity_to_take);
        ivMedicineFormImage = findViewById(R.id.image_home_medicine);
    }

    public void bindMedicine(HomeMedicineDto medicine){
        tvMedicineTime.setText(medicine.time.toString());
        tvMedicineDescription.setText(String.format(Locale.ENGLISH,"%s %d",medicine.medicineName,medicine.dosage));
        tvMedicineQuantity.setText(mapper.getString(medicine.quantity));
        ivMedicineFormImage.setImageDrawable(formMapper.getImage(medicine.form));
    }
}
