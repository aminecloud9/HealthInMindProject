package course.labs.healthinmind.remindmedicine;

import java.util.List;

import course.labs.healthinmind.screens.addmedicine.reminders.ReminderDto;

public interface RemindMedicinesRepository {
    void createdRemindMedicines(long createdMedicineId, List<ReminderDto> reminderDtos);

}
