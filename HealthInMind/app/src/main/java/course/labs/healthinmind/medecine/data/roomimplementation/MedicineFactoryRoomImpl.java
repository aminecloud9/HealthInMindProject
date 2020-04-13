package course.labs.healthinmind.medecine.data.roomimplementation;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import course.labs.healthinmind.medecine.data.abstractions.Medicine;
import course.labs.healthinmind.medecine.data.abstractions.MedicineFactory;
import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderRoomImpl;

public class MedicineFactoryRoomImpl implements MedicineFactory {

    @Override
    public Medicine createMedicineThatEnds(String name, int dosage, String form, int frequency, int refillQuantity, boolean toBeRemindedToRefill, Date startingDate, Date endingDate, double quantityToTake, String instructions, List<LocalTime> takingTimes) {
        MedicineRoomImpl medicine = new MedicineRoomImpl(name,
                form,
                dosage,
                frequency,
                refillQuantity,
                toBeRemindedToRefill,
                startingDate,false, endingDate,instructions,quantityToTake);


        List<ReminderRoomImpl> reminders = createReminders(takingTimes);
        return new MedicineImpl(medicine,reminders);
    }

    @Override
    public Medicine createMedicineThatDoesNotEnd(
            String name,
            int dosage,
            String form,
            int frequency,
            int refillQuantity,
            boolean toBeRemindedToRefill,
            Date startingDate,
            double quantityToTake,
            String instructions,
            List<LocalTime> takingTimes) {
        MedicineRoomImpl medicine = new MedicineRoomImpl(name,
                form,
                dosage,
                frequency,
                refillQuantity,
                toBeRemindedToRefill,
                startingDate,true, null,instructions,quantityToTake);

        List<ReminderRoomImpl> reminders = createReminders(takingTimes);
        return new MedicineImpl(medicine,reminders);
    }

    private List<ReminderRoomImpl> createReminders(List<LocalTime> takingTimes){
        List<ReminderRoomImpl> reminders = new ArrayList<>();
        for(LocalTime takingTime : takingTimes){
            reminders.add(new ReminderRoomImpl(takingTime));
        }
        return reminders;
    }


}
