package course.labs.healthinmind.remindmedicine;

import java.time.LocalTime;
import java.util.List;

import course.labs.healthinmind.medecine.domain.showtodaymedicine.UpcomingMedicine;
import course.labs.healthinmind.screens.addmedicine.reminders.ReminderDto;

public class RemindMedicinesRepositoryImpl implements RemindMedicinesRepository {
    private RemindMedicineDataSource remindMedicineDataSource;

    public RemindMedicinesRepositoryImpl(RemindMedicineDataSource remindMedicineDataSource) {
        this.remindMedicineDataSource = remindMedicineDataSource;
    }

    @Override
    public List<Long> createdRemindMedicines(long createdMedicineId, List<ReminderDto> reminderDtos) {
       return remindMedicineDataSource.createRemindMedicines(createdMedicineId,reminderDtos);
    }

    @Override
    public List<UpcomingMedicine> getUpcomingMedicines(LocalTime time) {
        return remindMedicineDataSource.getUpcomingMedicines(time);
    }
}
