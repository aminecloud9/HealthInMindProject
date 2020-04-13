package course.labs.healthinmind.medecine.data.roomimplementation;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import course.labs.healthinmind.medecine.data.abstractions.Medicine;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineImpl;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineRoomImpl;

@Dao
public interface MedicineDao {
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

    @Query("SELECT * FROM medicine_table ORDER By frequency DESC")
    List<MedicineRoomImpl> getAllMedicines();

    @Transaction
    @Query("SELECT * FROM medicine_table")
    List<MedicineImpl> fetchMedicinesWithReminders();

    @Query("SELECT * FROM medicine_table WHERE medicineId = :medicineId")
    MedicineImpl fetchMedicineWithItsReminders(long medicineId);

}
