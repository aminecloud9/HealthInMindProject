package course.labs.healthinmind.medecine;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "medicine_table")
public class MedicineRoomImpl{
    @PrimaryKey(autoGenerate = true)
    private int medicineId;
    private String medicineName;
    private String form;
    private int dosage;
    private int frequency;
    private int refillQuantity;
    private boolean refillReminder;
    private boolean medicineHasNoEndDate;
    private Date startDate;
    private Date endDate;
    private String instructions;
    private double quantityToTake;

    public MedicineRoomImpl(String medicineName, String form, int dosage, int frequency, int refillQuantity,
                             boolean refillReminder, Date startDate, boolean medicineHasNoEndDate,
                            Date endDate, String instructions, double quantityToTake) {
        this.medicineName = medicineName;
        this.form = form;
        this.dosage = dosage;
        this.frequency = frequency;
        this.refillQuantity = refillQuantity;
        this.refillReminder = refillReminder;
        this.medicineHasNoEndDate = medicineHasNoEndDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.instructions = instructions;
        this.quantityToTake = quantityToTake;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public String getForm() {
        return form;
    }

    public int getDosage() {
        return dosage;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getRefillQuantity() {
        return refillQuantity;
    }

    public boolean isRefillReminder() {
        return refillReminder;
    }

    public boolean isMedicineHasNoEndDate() {
        return medicineHasNoEndDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getInstructions() {
        return instructions;
    }

    public double getQuantityToTake() {
        return quantityToTake;
    }
}
