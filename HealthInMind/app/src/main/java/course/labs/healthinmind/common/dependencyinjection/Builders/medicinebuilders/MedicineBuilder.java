package course.labs.healthinmind.common.dependencyinjection.Builders.medicinebuilders;

import java.util.Date;

import course.labs.healthinmind.common.Form;
import course.labs.healthinmind.medecine.data.abstractions.Medicine;

public interface MedicineBuilder {

        MedicineBuilder setMedicineName(String medicineName);
        MedicineBuilder setDosage(int dosage);
        MedicineBuilder setForm(Form form);
        MedicineBuilder setRefillQuantity(int refillQuantity);
        MedicineBuilder toBeRemindedToRefill(boolean toBeReminded);
        MedicineBuilder isPermanent(boolean isPermanent);
        MedicineBuilder setStartingDate(Date startingDate);
        MedicineBuilder addEndingDate(Date endingDate);
        MedicineBuilder setInstructions(String instructions);

        Medicine create();
}
