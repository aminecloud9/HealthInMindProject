package course.labs.healthinmind.remindmedicine;

import java.time.LocalTime;
import java.util.List;

import course.labs.healthinmind.medecine.domain.showtodaymedicine.UpcomingMedicine;
import course.labs.healthinmind.screens.addmedicine.reminders.ReminderDto;

public interface RemindMedicineDataSource {
    List<Long> createRemindMedicines(long createdMedicineId, List<ReminderDto> reminderDtos);

    List<UpcomingMedicine> getUpcomingMedicines(LocalTime time);
}
