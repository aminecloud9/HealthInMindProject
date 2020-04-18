package course.labs.healthinmind.screens.addmedicine;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import course.labs.healthinmind.screens.addmedicine.reminders.ReminderDto;
import course.labs.healthinmind.screens.views.BaseObservableViewMvc;
import course.labs.healthinmind.screens.views.ObservableViewMvc;

public interface AddMedicine {

    interface AddMedicineViewListener{
        void onSaveClicked(String medicineName,
                                 String form,
                                 int dosage,
                                 int refillQuantity,
                                 boolean refillReminder,
                                 boolean medicineHasNoEndDate,
                                 Date startDate,
                                 Date endDate,
                                 String instructions,
                                 double quantityToTake,
                                 List<LocalTime> takingTimes);

    }




}