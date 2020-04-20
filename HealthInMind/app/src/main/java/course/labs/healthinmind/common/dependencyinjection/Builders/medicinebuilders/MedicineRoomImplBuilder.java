package course.labs.healthinmind.common.dependencyinjection.Builders.medicinebuilders;

import java.util.Date;

import course.labs.healthinmind.common.Form;
import course.labs.healthinmind.medecine.data.abstractions.Medicine;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineRoomImpl;

public class MedicineRoomImplBuilder implements MedicineBuilder{
    private Medicine medicine;

    private String medicineName;
    private int dosage;
    private Form form;
    private int refillQuantity;
    private boolean toBeRemindedToRefill;
    private boolean isPermanent;
    private Date startDate;
    private Date endDate;
    private String instructions;


    @Override
    public MedicineBuilder setMedicineName(String medicineName) {
        this.medicineName = medicineName;
        return this;
    }

    @Override
    public MedicineBuilder setDosage(int dosage) {
        this.dosage = dosage;
        return this;
    }

    @Override
    public MedicineBuilder setForm(Form form) {
        this.form = form;
        return this;
    }

    @Override
    public MedicineBuilder setRefillQuantity(int refillQuantity) {
        this.refillQuantity = refillQuantity;
        return this;
    }

    @Override
    public MedicineBuilder toBeRemindedToRefill(boolean toBeRemindedToRefill) {
        this.toBeRemindedToRefill = toBeRemindedToRefill;
        return this;
    }

    @Override
    public MedicineBuilder isPermanent(boolean permanent) {
        isPermanent = permanent;
        return this;
    }

    @Override
    public MedicineBuilder setStartingDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    @Override
    public MedicineBuilder addEndingDate(Date endingDate) {
        endDate = endingDate;
        return this;
    }

    @Override
    public MedicineBuilder setInstructions(String instructions) {
        this.instructions = instructions;
        return this;
    }

    @Override
    public Medicine create() {
        return new MedicineRoomImpl(
                medicineName,
                dosage,
                form,
                refillQuantity,
                toBeRemindedToRefill,
                isPermanent,
                startDate,
                endDate,
                instructions
        );
    }
}
