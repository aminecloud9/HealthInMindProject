package course.labs.healthinmind.medicine.data;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import course.labs.healthinmind.database.HealthData;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineDao;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineRoomImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(AndroidJUnit4.class)
public class MedicineRoomImplTest {
    private HealthData db;
    private MedicineDao medicineDao;
    @Before
    public void createDb(){
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context,HealthData.class).build();
        medicineDao = db.medicineDao();
    }

    @After
    public void closeDb(){
        db.close();
    }

    @Test
    public void createAMedicine(){
        try {
            MedicineRoomImpl paracetamol = TestUtil.createMedicine("Paracetamol");
            long insertedMedicineId = medicineDao.insert(paracetamol);
            MedicineRoomImpl createdMedicine = medicineDao.fetchById(insertedMedicineId);
            assertEquals(createdMedicine.getMedicineId(), 1);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
