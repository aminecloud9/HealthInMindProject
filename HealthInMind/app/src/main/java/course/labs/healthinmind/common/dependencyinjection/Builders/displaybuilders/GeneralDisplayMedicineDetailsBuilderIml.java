package course.labs.healthinmind.common.dependencyinjection.Builders.displaybuilders;

import android.graphics.drawable.Drawable;

import course.labs.healthinmind.common.Form;
import course.labs.healthinmind.screens.ImageFormMapper;
import course.labs.healthinmind.screens.medicineslist.medicineslist.GeneralDisplayMedicineDetails;

public class GeneralDisplayMedicineDetailsBuilderIml implements GeneralDisplayMedicineDetailsBuilder {

    private long id;
    private String medicineName;
    private int dosage;
    private Form form;
    private ImageFormMapper imageFormMapper;
    private int frequency;

    public GeneralDisplayMedicineDetailsBuilderIml(ImageFormMapper imageFormMapper) {
        this.imageFormMapper = imageFormMapper;
    }

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
        Drawable formIcon = imageFormMapper.getImage(form);
        return new GeneralDisplayMedicineDetails(id,medicineName,dosage,form,formIcon, frequency);
    }
}
