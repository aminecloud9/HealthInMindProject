package course.labs.healthinmind.remindmedicine;

import java.util.ArrayList;
import java.util.List;

import course.labs.healthinmind.database.HealthData;
import course.labs.healthinmind.screens.addmedicine.reminders.ReminderDto;

public class RemindMedicineRoomDataSource implements RemindMedicineDataSource{

    private RemindMedicineDao remindMedicineDao;

    public RemindMedicineRoomDataSource(HealthData database){
        remindMedicineDao = database.remindMedicineDao();
    }

    @Override
    public List<Long> createRemindMedicines(long createdMedicineId, List<ReminderDto> reminderDtos) {
        List<RemindMedicineRoomImpl> remindMedicines = new ArrayList<>();

        for (ReminderDto reminderDto : reminderDtos){
            Long reminderId = remindMedicineDao.fetchReminderByTime(reminderDto.getTime());
            remindMedicines.add(
                    new RemindMedicineRoomImpl(
                            createdMedicineId,
                            reminderId,
                            reminderDto.quantityToTake
                    )
            );
        }
        return remindMedicineDao.insertRemindMedicines(remindMedicines);
    }
}
