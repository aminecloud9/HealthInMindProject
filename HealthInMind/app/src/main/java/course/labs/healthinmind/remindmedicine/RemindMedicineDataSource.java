package course.labs.healthinmind.remindmedicine;

import java.util.List;

import course.labs.healthinmind.screens.addmedicine.reminders.ReminderDto;

public interface RemindMedicineDataSource {
    List<Long> createRemindMedicines(long createdMedicineId, List<ReminderDto> reminderDtos);
}
