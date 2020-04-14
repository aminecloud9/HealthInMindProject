package course.labs.healthinmind.medecine.data.roomimplementation;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

import course.labs.healthinmind.database.Converters;

@Entity(tableName = "medicine_table")

public class MedicineRoomImpl{
    @PrimaryKey(autoGenerate = true)
    private long medicineId;
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
    
    @Ignore
    public MedicineRoomImpl(String medicineName, String form, int dosage, int frequency, int refillQuantity,
                             boolean refillReminder, Date startDate, boolean medicineHasNoEndDate,
                            Date endDate, String instructions, double quantityToTake) {
        setProperties(
                medicineName,
                form,
                dosage,
                frequency,
                refillQuantity,
                refillReminder,
                startDate,medicineHasNoEndDate,
                endDate,
                instructions,
                quantityToTake
        );
    }

    public MedicineRoomImpl(long medicineId, String medicineName, String form, int dosage, int frequency, int refillQuantity,
                            boolean refillReminder, Date startDate, boolean medicineHasNoEndDate,
                            Date endDate, String instructions, double quantityToTake) {
        this.medicineId = medicineId;
         setProperties(
                medicineName,
                form,
                dosage,
                frequency,
                refillQuantity,
                refillReminder,
                startDate,medicineHasNoEndDate,
                endDate,
                instructions,
                quantityToTake
                );
    }

    private void setProperties(String medicineName, String form, int dosage, int frequency, int refillQuantity, boolean refillReminder, Date startDate, boolean medicineHasNoEndDate, Date endDate, String instructions, double quantityToTake) {
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

    public long getMedicineId() {
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
