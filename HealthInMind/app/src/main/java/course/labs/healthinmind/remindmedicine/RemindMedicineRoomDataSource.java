package course.labs.healthinmind.remindmedicine;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import course.labs.healthinmind.database.HealthData;
import course.labs.healthinmind.screens.addmedicine.reminders.ReminderDto;

public class RemindMedicineRoomDataSource implements RemindMedicineDataSource{

    private RemindMedicineDao remindMedicineDao;

    public RemindMedicineRoomDataSource(HealthData database){
        remindMedicineDao = database.remindMedicineDao();
    }

    @Override
    public void createRemindMedicines(long createdMedicineId, List<ReminderDto> reminderDtos) {
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
        remindMedicineDao.insertRemindMedicines(remindMedicines);
    }
}
