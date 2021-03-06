package course.labs.healthinmind.medecine.domain.addmedicineusecase;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import course.labs.healthinmind.common.AppExecutors;
import course.labs.healthinmind.medecine.data.abstractions.Medicine;
import course.labs.healthinmind.medecine.data.abstractions.MedicineRepository;
import course.labs.healthinmind.reminders.data.abstractions.RemindersRepository;
import course.labs.healthinmind.remindmedicine.RemindMedicinesRepository;
import course.labs.healthinmind.screens.addmedicine.reminders.ReminderDto;

public class AddMedicineUseCase {
    public interface AddMedicineUseCaseOutputPort{
        void onSuccess(AddMedicineResponse response);
        void onProgress();
        void onFailure(AddMedicineResponse response);
    }

    private MedicineRepository medicineRepository;
    private RemindersRepository remindersRepository;
    private AddMedicineUseCaseOutputPort outputPort;
    private RemindMedicinesRepository remindMedicinesRepository;

    private AddMedicineResponse response;

    public AddMedicineUseCase(MedicineRepository medicineRepository, RemindersRepository remindersRepository, AddMedicineUseCaseOutputPort outputPort, RemindMedicinesRepository remindMedicinesRepository) {
        this.medicineRepository = medicineRepository;
        this.remindersRepository = remindersRepository;
        this.outputPort = outputPort;
        this.remindMedicinesRepository = remindMedicinesRepository;

        response = new AddMedicineResponse();
    }

    public void addMedicine(CreateMedicineRequest createMedicineRequest){
        Medicine medicine = createMedicineRequest.medicine;
        List<ReminderDto> reminderDtos = createMedicineRequest.reminderDtoList;

        validateRequest(medicine,reminderDtos);

        List<LocalTime> takingTimes =
                reminderDtos.
                        stream().
                        map(ReminderDto::getTime).
                        collect(Collectors.toList());

        AppExecutors.getInstance().diskIO().execute(() -> {
            Long createdMedicineId = medicineRepository.createMedicine(medicine);

            createMedicineReminders(takingTimes);
            createRemindMedicine(createdMedicineId,reminderDtos);
            outputPort.onSuccess(response);
        });

    }



    private void validateRequest(Medicine medicine, List<ReminderDto> reminderDtos) {
        if(!medicine.isPermanent && medicine.endDate == null){
            response.addMessage("No permanent medicines must have an ending date");
            response.setSuccessful(false);
        }else if(medicine.isPermanent && medicine.endDate != null){
            response.addMessage("Permanent medicines can't have and ending date");
            response.setSuccessful(false);
        }

        if(reminderDtos.isEmpty()){
            response.setSuccessful(false);
            response.addMessage("Medicines must have at least one reminder");
        }

        if (!response.isSuccessful()){
            outputPort.onFailure(response);
        }
    }

    private void createMedicineReminders(List<LocalTime> takingTimes) {
       List<Long> insertedIds =  remindersRepository.insertNewRemindersOnly(takingTimes);

    }

    private void createRemindMedicine(long createdMedicineId, List<ReminderDto> reminderDtos) {
        List<Long> ids = remindMedicinesRepository.createdRemindMedicines(createdMedicineId, reminderDtos);
    }



}
