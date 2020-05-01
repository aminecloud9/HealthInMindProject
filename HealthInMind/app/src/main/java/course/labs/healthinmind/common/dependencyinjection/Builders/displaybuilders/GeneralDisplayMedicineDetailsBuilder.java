package course.labs.healthinmind.common.dependencyinjection.Builders.displaybuilders;

import course.labs.healthinmind.common.Form;
import course.labs.healthinmind.screens.medicineslist.medicineslist.GeneralDisplayMedicineDetails;

public interface GeneralDisplayMedicineDetailsBuilder {
    GeneralDisplayMedicineDetailsBuilder setMedicineId(long id);
    GeneralDisplayMedicineDetailsBuilder setMedicineName(String medicineName);
    GeneralDisplayMedicineDetailsBuilder setMedicineDosage(int dosage);
    GeneralDisplayMedicineDetailsBuilder setMedicineForm(Form form);
    GeneralDisplayMedicineDetailsBuilder setFrequency(int frequency);
    GeneralDisplayMedicineDetails build();
}
