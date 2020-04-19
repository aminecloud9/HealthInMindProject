package course.labs.healthinmind.medecine.domain;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import course.labs.healthinmind.medecine.data.abstractions.Medicine;
import course.labs.healthinmind.medecine.data.abstractions.MedicineRepository;
import course.labs.healthinmind.reminders.data.abstractions.RemindersRepository;
import course.labs.healthinmind.remindmedicine.RemindMedicinesRepository;
import course.labs.healthinmind.screens.addmedicine.reminders.ReminderDto;

public class AddMedicineUseCase {
    private MedicineRepository medicineRepository;
    private RemindersRepository remindersRepository;
    private RemindMedicinesRepository remindMedicinesRepository;

    public AddMedicineUseCase(MedicineRepository medicineRepository, RemindersRepository remindersRepository, RemindMedicinesRepository remindMedicinesRepository) {
        this.medicineRepository = medicineRepository;
        this.remindersRepository = remindersRepository;
        this.remindMedicinesRepository = remindMedicinesRepository;
    }

    public long addMedicine(CreateMedicineRequest createMedicineRequest){
        Medicine medicine = createMedicineRequest.medicine;
        List<ReminderDto> reminderDtos = createMedicineRequest.reminderDtoList;
        List<LocalTime> takingTimes =
                reminderDtos.
                        stream().
                        map(ReminderDto::getTime).
                        collect(Collectors.toList());
        Long createdMedicineId = medicineRepository.createMedicine(medicine);
        createMedicineReminders(takingTimes);
        createRemindMedicine(createdMedicineId,reminderDtos);

        return createdMedicineId;
    }

    private void createMedicineReminders(List<LocalTime> takingTimes) {
        remindersRepository.insertNewRemindersOnly(takingTimes);
    }

    private void createRemindMedicine(long createdMedicineId, List<ReminderDto> reminderDtos) {
        remindMedicinesRepository.createdRemindMedicines(createdMedicineId, reminderDtos);
    }

}
