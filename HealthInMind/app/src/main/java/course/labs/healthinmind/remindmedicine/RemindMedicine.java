package course.labs.healthinmind.remindmedicine;

import course.labs.healthinmind.common.Quantity;

public abstract class RemindMedicine {
    public final long medicineId;
    public final long reminderId;
    public final Quantity takingQuantity;

    public RemindMedicine(long medicineId, long reminderId, Quantity takingQuantity) {
        this.medicineId = medicineId;
        this.reminderId = reminderId;
        this.takingQuantity = takingQuantity;
    }
}
