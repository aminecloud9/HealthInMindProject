package course.labs.healthinmind.medecine.domain.showtodaymedicine;

import java.time.LocalTime;

import course.labs.healthinmind.common.Form;
import course.labs.healthinmind.common.Quantity;

public class UpcomingMedicine {

    public final String medicineName;
    public final int dosage;
    public final Form form;
    public final LocalTime time;
    public final Quantity takingQuantity;

    public UpcomingMedicine(String medicineName, int dosage, Form form, LocalTime time, Quantity takingQuantity) {
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.form = form;
        this.time = time;
        this.takingQuantity = takingQuantity;
    }
}
