package course.labs.healthinmind.medecine.data.roomimplementation;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import course.labs.healthinmind.database.MedicineReminderCrossRef;
import course.labs.healthinmind.medecine.data.abstractions.Medicine;
import course.labs.healthinmind.reminders.ReminderRoomImpl;

public class MedicineImpl implements Medicine {

    public MedicineImpl(MedicineRoomImpl medicine, List<ReminderRoomImpl> reminders) {
        this.medicine = medicine;
        this.reminders = reminders;
    }

    @Embedded
    public MedicineRoomImpl medicine;
    @Relation(
            parentColumn = "playlistId",
            entityColumn = "songId",
            associateBy = @Junction(MedicineReminderCrossRef.class)
    )
    public List<ReminderRoomImpl> reminders;

    @Override
    public String getMedicineName() {
        return medicine.getMedicineName();
    }

    @Override
    public int getDosage() {
        return medicine.getDosage();
    }

    @Override
    public String getForm() {
        return medicine.getForm();
    }

    @Override
    public int getFrequency() {
        return medicine.getFrequency();
    }

    @Override
    public int getRefillQuantity() {
        return medicine.getRefillQuantity();
    }

    @Override
    public boolean isRefillReminder() {
        return medicine.isRefillReminder();
    }

    @Override
    public boolean isMedicineHasNoEndDate() {
        return medicine.isMedicineHasNoEndDate();
    }

    @Override
    public Date getStartDate() {
        return medicine.getStartDate();
    }

    @Override
    public Date getEndDate() {
        return medicine.getEndDate();
    }

    @Override
    public List<LocalTime> getTakingTimes() {
        List<LocalTime> takingTimes = new ArrayList<>();
        for (ReminderRoomImpl reminder : reminders){
            takingTimes.add(reminder.getTime());
        }
        return takingTimes;
    }

    @Override
    public double getQuantityToTake() {
        return medicine.getQuantityToTake();
    }

    @Override
    public String getInstructions() {
        return medicine.getInstructions();
    }


}
