package course.labs.healthinmind.roomdatabase.medicineimpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import course.labs.healthinmind.medecine.data.abstractions.Medicine;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineDao;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineRoomDatabaseProvider;
import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderDao;
import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderRoomImpl;
import course.labs.healthinmind.roomdatabase.BaseRoomTest;

public class MedicineRoomDatabaseProviderTests extends BaseRoomTest {

    private MedicineRoomDatabaseProvider medicineProvider;
    private MedicineDao medicineDao;
    private ReminderDao reminderDao;

    private Medicine medicineToBeCreated;

    @Before
    public void setUp(){
        super.createDb();
        medicineProvider = new MedicineRoomDatabaseProvider(db);
        medicineDao = db.medicineDao();
        reminderDao = db.reminderDao();
        medicineToBeCreated = mock(Medicine.class);
    }


}
