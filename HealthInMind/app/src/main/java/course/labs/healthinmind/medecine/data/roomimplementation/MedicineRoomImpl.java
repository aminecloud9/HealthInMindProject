package course.labs.healthinmind.medecine.data.roomimplementation;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

import course.labs.healthinmind.common.Form;
import course.labs.healthinmind.medecine.data.abstractions.Medicine;

@Entity(tableName = "medicine_table")

public class MedicineRoomImpl extends Medicine {

    @PrimaryKey(autoGenerate = true)
    public long medicineId;

    public MedicineRoomImpl(String medicineName, int dosage, Form form, int refillQuantity, boolean toBeRemindedToRefill, boolean isPermanent, Date startDate,Date endDate ,String instructions, long medicineId) {
        super(medicineName, dosage, form, refillQuantity, toBeRemindedToRefill, isPermanent, startDate, endDate, instructions);
        this.medicineId = medicineId;
    }

    @Ignore
    public MedicineRoomImpl(
            String medicineName,
            int dosage,
            Form form,
            int refillQuantity,
            boolean toBeRemindedToRefill,
            boolean isPermanent,
            Date startDate,
            Date endDate,
            String instructions
    ) {
        super(medicineName,
                dosage,
                form,
                refillQuantity,
                toBeRemindedToRefill,
                isPermanent,
                startDate,
                endDate, instructions
        );
    }



    @Override
    public long getMedicineId() {
        return medicineId;
    }

}
