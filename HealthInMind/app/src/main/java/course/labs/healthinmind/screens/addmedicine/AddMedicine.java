package course.labs.healthinmind.screens.addmedicine;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import course.labs.healthinmind.common.Form;
import course.labs.healthinmind.screens.addmedicine.reminders.ReminderDto;
import course.labs.healthinmind.screens.views.BaseObservableViewMvc;
import course.labs.healthinmind.screens.views.ObservableViewMvc;

public interface AddMedicine {

    interface AddMedicineViewListener{
        void onSaveClicked(String medicineName,
                           Form form,
                           int dosage,
                           int refillQuantity,
                           boolean refillReminder,
                           boolean medicineHasNoEndDate,
                           Date startDate,
                           Date endDate,
                           String instructions,
                           List<ReminderDto> reminderDtoList);

        void onAddReminderClick();

    }


    void addReminder(ReminderDto reminderDto);

}