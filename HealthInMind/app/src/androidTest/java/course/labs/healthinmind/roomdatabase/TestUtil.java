package course.labs.healthinmind.roomdatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import course.labs.healthinmind.medecine.data.roomimplementation.MedicineRoomImpl;
import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderRoomImpl;

public class TestUtil {

    public static List<ReminderRoomImpl> createReminders(){
        return new ArrayList<ReminderRoomImpl>(){
            {
                add(new ReminderRoomImpl(LocalTime.of(7,0)));
                add(new ReminderRoomImpl(LocalTime.of(12,0)));
            }
        };
    }

    public static MedicineRoomImpl createMedicine(String name) throws ParseException {
        return new MedicineRoomImpl(name,
                "form",
                250,
                2,
                40,
                true,
                new Date(),false, (new SimpleDateFormat("dd/MM/yyyy")).parse("20/12/2020"),"instructions",1);

    }
}
