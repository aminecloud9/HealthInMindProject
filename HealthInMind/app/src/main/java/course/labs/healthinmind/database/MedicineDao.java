package course.labs.healthinmind.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import course.labs.healthinmind.medecine.Medicine;
import course.labs.healthinmind.medecine.MedicineImpl;
import course.labs.healthinmind.medecine.MedicineRoomImpl;

@Dao
public interface MedicineDao {
    @Insert
    void insert(MedicineImpl medicineRoomImpl);

    @Update
    void update(MedicineImpl medicineRoomImpl);

    @Query("SELECT * FROM medicine_table WHERE medicineId = :medicineId")
    Medicine fetchById(int medicineId);

    @Query("DELETE FROM medicine_table WHERE medicineId = :id")
    void deleteMedicineRoom(int id);

    @Query("DELETE FROM medicine_table")
    void deleteAllMedicines();

    @Query("SELECT * FROM medicine_table ORDER By frequency DESC")
    List<Medicine> getAllMedicines();

    @Query("SELECT * FROM medicine_table")
    List<Medicine> fetchMedicinesWithReminders();

    @Query("SELECT * FROM medicine_table WHERE medicineId = :medicineId")
    Medicine fetchMedicineWithItsReminders(int medicineId);

}
