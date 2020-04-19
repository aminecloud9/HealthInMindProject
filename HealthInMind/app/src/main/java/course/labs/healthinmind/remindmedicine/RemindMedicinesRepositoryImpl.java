package course.labs.healthinmind.remindmedicine;

import java.util.List;

import course.labs.healthinmind.screens.addmedicine.reminders.ReminderDto;

public class RemindMedicinesRepositoryImpl implements RemindMedicinesRepository {
    private RemindMedicineDataSource remindMedicineDataSource;

    public RemindMedicinesRepositoryImpl(RemindMedicineDataSource remindMedicineDataSource) {
        this.remindMedicineDataSource = remindMedicineDataSource;
    }

    @Override
    public void createdRemindMedicines(long createdMedicineId, List<ReminderDto> reminderDtos) {
        remindMedicineDataSource.createRemindMedicines(createdMedicineId,reminderDtos);
    }
}
