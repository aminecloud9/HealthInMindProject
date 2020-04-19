package course.labs.healthinmind.medecine.domain;

import java.util.List;

import course.labs.healthinmind.medecine.data.abstractions.Medicine;
import course.labs.healthinmind.screens.addmedicine.reminders.ReminderDto;

public class CreateMedicineRequest {
    public final Medicine medicine;
    public final List<ReminderDto> reminderDtoList;


    public CreateMedicineRequest(Medicine medicine, List<ReminderDto> reminderDtoList) {
        this.medicine = medicine;
        this.reminderDtoList = reminderDtoList;
    }
}
