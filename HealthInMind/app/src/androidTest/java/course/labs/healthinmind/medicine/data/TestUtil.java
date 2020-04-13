package course.labs.healthinmind.medicine.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import course.labs.healthinmind.medecine.data.roomimplementation.MedicineRoomImpl;
import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderRoomImpl;

public class TestUtil {

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
