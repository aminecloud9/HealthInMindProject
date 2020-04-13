package course.labs.healthinmind.database;

import androidx.room.Dao;
import androidx.room.Insert;

import java.util.List;

@Dao
public interface RemindMedicineDao {
    @Insert
    void insert(RemindMedicine remindMedicine);

    @Insert
    void insertRemindMedicines(List<RemindMedicine> remindMedicines);
}
