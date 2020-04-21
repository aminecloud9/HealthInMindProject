package course.labs.healthinmind.screens.home.homemedicineslist;

import java.time.LocalTime;

import course.labs.healthinmind.common.Form;
import course.labs.healthinmind.common.Quantity;

public class HomeMedicineDto {

    public final String medicineName;
    public final int dosage;
    public final Form form;
    public final LocalTime time;
    public final Quantity quantity;

    HomeMedicineDto(String medicineName, int dosage, Form form, LocalTime time, Quantity quantity) {
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.form = form;
        this.time = time;
        this.quantity = quantity;
    }
}
