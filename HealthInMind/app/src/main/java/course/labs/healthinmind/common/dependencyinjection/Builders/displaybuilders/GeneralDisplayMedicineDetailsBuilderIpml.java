package course.labs.healthinmind.common.dependencyinjection.Builders.displaybuilders;


import course.labs.healthinmind.common.Form;
import course.labs.healthinmind.screens.medicineslist.medicineslist.GeneralDisplayMedicineDetails;

public class GeneralDisplayMedicineDetailsBuilderIpml implements GeneralDisplayMedicineDetailsBuilder {

    private long id;
    private String medicineName;
    private int dosage;
    private Form form;
    private int frequency;


    @Override
    public GeneralDisplayMedicineDetailsBuilder setMedicineId(long id) {
        this.id = id;
        return this;
    }

    @Override
    public GeneralDisplayMedicineDetailsBuilder setMedicineName(String medicineName) {
        this.medicineName = medicineName;
        return this;
    }

    @Override
    public GeneralDisplayMedicineDetailsBuilder setMedicineDosage(int dosage) {
        this.dosage = dosage;
        return this;
    }

    @Override
    public GeneralDisplayMedicineDetailsBuilder setMedicineForm(Form form) {
        this.form = form;
        return this;
    }

    @Override
    public GeneralDisplayMedicineDetailsBuilder setFrequency(int frequency) {
        this.frequency = frequency;
        return this;
    }

    @Override
    public GeneralDisplayMedicineDetails build() {
        return new GeneralDisplayMedicineDetails(id,medicineName,dosage,form , frequency);
    }
}
