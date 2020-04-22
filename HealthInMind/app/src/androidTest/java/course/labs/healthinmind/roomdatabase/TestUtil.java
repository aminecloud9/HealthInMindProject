package course.labs.healthinmind.roomdatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import course.labs.healthinmind.common.Form;
import course.labs.healthinmind.common.Quantity;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineRoomImpl;
import course.labs.healthinmind.reminders.data.abstractions.Reminder;
import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderRoomImpl;

import static java.lang.Math.abs;

public class TestUtil {
    private static List<ReminderRoomImpl> reminders = new ArrayList<ReminderRoomImpl>(){
        {
            add(new ReminderRoomImpl(LocalTime.of(7,0)));
            add(new ReminderRoomImpl(LocalTime.of(8,0)));
            add(new ReminderRoomImpl(LocalTime.of(9,0)));
            add(new ReminderRoomImpl(LocalTime.of(10,0)));
            add(new ReminderRoomImpl(LocalTime.of(12,0)));
            add(new ReminderRoomImpl(LocalTime.of(15,0)));
            add(new ReminderRoomImpl(LocalTime.of(20,0)));
        }
    };
    public static int NUMBER_OF_AVAILABLE_REMINDERS = reminders.size();

    public static List<ReminderRoomImpl> getReminders(){
        return reminders;
    }

    public static List<ReminderRoomImpl> getReminders(int numberOfReminders){
        Set<ReminderRoomImpl> remindersToBeCreated = new HashSet<>();

        while (remindersToBeCreated.size() < numberOfReminders){
            remindersToBeCreated.add(reminders.get(getRandomIndex(reminders)));
        }

        return new ArrayList<>(remindersToBeCreated);
    }

    private static int getRandomIndex(List<ReminderRoomImpl> reminders) {
        return abs((new Random().nextInt())%reminders.size());
    }

    public static MedicineRoomImpl createMedicine(String name) throws ParseException {
        return new MedicineRoomImpl(
                name,
                250,
                Form.PILL,
                20,
                false,
                true,
                new Date(),
                new Date(),
                "instructions"
                );

    }

    public static MedicineRoomImpl createMedicine(String name, Form form) throws ParseException {
        return new MedicineRoomImpl(
                name,
                250,
                form,
                20,
                false,
                true,
                new Date(),
                new Date(),
                "instructions"
        );

    }

    public static List<LocalTime> getTakingTimes(List<ReminderRoomImpl> reminders) {
        List<LocalTime> takingTimes = new ArrayList<>();
        for (ReminderRoomImpl reminder : reminders){
            takingTimes.add(reminder.time);
        }

        return takingTimes;
    }
}
