package course.labs.healthinmind.remindmedicine;

import java.util.List;

import course.labs.healthinmind.screens.addmedicine.reminders.ReminderDto;

public interface RemindMedicineDataSource {
    void createRemindMedicines(long createdMedicineId, List<ReminderDto> reminderDtos);
}
