package course.labs.healthinmind.medecine.data.abstractions;

import java.util.Date;

import course.labs.healthinmind.common.Form;

public abstract class Medicine {
    public final String medicineName;
    public final int dosage;
    public final Form form;
    public final int refillQuantity;
    public final boolean toBeRemindedToRefill;
    public final boolean isPermanent;
    public final Date startDate;
    public final Date endDate;
    public final String instructions;

    public abstract long getMedicineId();

    protected Medicine(String medicineName,
                       int dosage,
                       Form form,
                       int refillQuantity,
                       boolean toBeRemindedToRefill,
                       boolean isPermanent,
                       Date startDate,
                       Date endDate, String instructions) {
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.form = form;
        this.refillQuantity = refillQuantity;
        this.toBeRemindedToRefill = toBeRemindedToRefill;
        this.isPermanent = isPermanent;
        this.startDate = startDate;
        this.endDate = endDate;
        this.instructions = instructions;
    }





}
