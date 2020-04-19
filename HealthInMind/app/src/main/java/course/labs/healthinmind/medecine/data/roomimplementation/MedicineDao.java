package course.labs.healthinmind.medecine.data.roomimplementation;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import course.labs.healthinmind.remindmedicine.MedicineImpl;

@Dao
public interface MedicineDao {
    @Transaction
    @Insert
    long insert(MedicineRoomImpl medicineRoomImpl);

    @Update
    void update(MedicineRoomImpl medicineRoomImpl);

    @Query("SELECT * FROM medicine_table WHERE medicineId = :medicineId")
    MedicineRoomImpl fetchById(long medicineId);

    @Query("DELETE FROM medicine_table WHERE medicineId = :id")
    void deleteMedicineRoom(int id);

    @Query("DELETE FROM medicine_table")
    void deleteAllMedicines();

    @Query("SELECT * from medicine_table")
    List<MedicineRoomImpl> getAllMedcines();
}
