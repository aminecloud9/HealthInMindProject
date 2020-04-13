package course.labs.healthinmind.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.time.LocalTime;

@Entity(primaryKeys = {"medicineId","reminderId"}, tableName = "remind_medicines")

public class RemindMedicine {

    public RemindMedicine(long medicineId, long reminderId) {
        this.medicineId = medicineId;
        this.reminderId = reminderId;
    }

    public long medicineId;
    public long reminderId;
}
