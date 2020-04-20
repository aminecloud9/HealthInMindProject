package course.labs.healthinmind.remindmedicine;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.time.LocalTime;
import java.util.List;

import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderRoomImpl;
import course.labs.healthinmind.remindmedicine.RemindMedicineRoomImpl;

@Dao
public interface RemindMedicineDao {
    @Insert
    void insert(RemindMedicineRoomImpl remindMedicineRoomImpl);

    @Insert
    List<Long> insertRemindMedicines(List<RemindMedicineRoomImpl> remindMedicineRoomImpls);

    @Query("SELECT reminderId FROM reminders WHERE time = :takingTime")
    Long fetchReminderByTime(LocalTime takingTime);

    @Transaction
    @Query("SELECT * FROM medicine_table")
    List<MedicineImpl> fetchMedicinesWithReminders();

    @Transaction
    @Query("SELECT * FROM medicine_table WHERE medicineId = :medicineId")
    MedicineImpl fetchMedicineWithItsReminders(long medicineId);
}
