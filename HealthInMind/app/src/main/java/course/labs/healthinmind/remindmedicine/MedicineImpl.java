package course.labs.healthinmind.remindmedicine;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import course.labs.healthinmind.medecine.data.roomimplementation.MedicineRoomImpl;
import course.labs.healthinmind.remindmedicine.RemindMedicineRoomImpl;
import course.labs.healthinmind.medecine.data.abstractions.Medicine;
import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderRoomImpl;

public class MedicineImpl{

    public MedicineImpl(MedicineRoomImpl medicine, List<ReminderRoomImpl> reminders) {
        this.medicine = medicine;
        this.reminders = reminders;
    }

    @Embedded
    public final MedicineRoomImpl medicine;
    @Relation(
            parentColumn = "medicineId",
            entityColumn = "reminderId",
            associateBy = @Junction(RemindMedicineRoomImpl.class)
    )
    public final List<ReminderRoomImpl> reminders;
    
}
