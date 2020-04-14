package course.labs.healthinmind.roomdatabase.medicineimpl;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import course.labs.healthinmind.database.HealthData;
import course.labs.healthinmind.medecine.data.abstractions.Medicine;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineDao;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineRoomDatabaseProvider;
import course.labs.healthinmind.roomdatabase.BaseRoomTest;

public class MedicineRoomDatabaseProviderTests extends BaseRoomTest {

    private MedicineRoomDatabaseProvider medicineProvider;
    private MedicineDao medicineDao;


    private Medicine medicineToBeCreated;

    @Before
    public void setUp(){
        super.createDb();
        medicineProvider = new MedicineRoomDatabaseProvider(db);
        medicineDao = db.medicineDao();
        medicineToBeCreated = mock(Medicine.class);
        when(medicineToBeCreated.getMedicineName()).thenReturn("Paracetamol");
    }


    @Test
    public void createMedicineWithNewReminders(){

        List<LocalTime> takingTimes = new ArrayList<LocalTime>(){
            {
                add(LocalTime.of(7,0));
                add(LocalTime.of(12,0));
            }
        };
        when(medicineToBeCreated.getTakingTimes()).thenReturn(takingTimes);

        Long createdId = medicineProvider.createMedicine(medicineToBeCreated);
        Assert.assertNotNull(createdId);
    }

    @Test
    public void createMedicineWithSomeRemindersAlreadyExist(){

    }

    @Test
    public void createMedicineWithAllRemindersAlreadyExist(){

    }
}
