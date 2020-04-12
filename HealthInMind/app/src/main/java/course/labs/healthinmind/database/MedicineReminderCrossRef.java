package course.labs.healthinmind.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalTime;

@Entity(primaryKeys = {"medicineId","reminderId"}, tableName = "remind_medicines")
public class MedicineReminderCrossRef {
    public int medicineId;
    public LocalTime reminderId;
}
