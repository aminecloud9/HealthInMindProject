package course.labs.healthinmind.remindmedicine;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.time.LocalTime;

import course.labs.healthinmind.common.Quantity;

@Entity(primaryKeys = {"medicineId","reminderId"}, tableName = "remind_medicines")

public class RemindMedicineRoomImpl extends RemindMedicine{

  public RemindMedicineRoomImpl(long medicineId, long reminderId, Quantity takingQuantity) {
        super(medicineId, reminderId, takingQuantity);
    }
}
