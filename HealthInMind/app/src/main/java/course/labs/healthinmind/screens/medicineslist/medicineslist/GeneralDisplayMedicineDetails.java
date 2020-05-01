package course.labs.healthinmind.screens.medicineslist.medicineslist;

import android.graphics.drawable.Drawable;

import course.labs.healthinmind.common.Form;

public class GeneralDisplayMedicineDetails {
    public final long medicineId;
    public final String medicineName;
    public final int dosage;
    public final Form form;
    public final int frequency;

    public GeneralDisplayMedicineDetails(long medicineId, String medicineName, int dosage, Form form, int frequency) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.form = form;
        this.frequency = frequency;
    }
}
