package course.labs.healthinmind.roomdatabase.medicine.data;

import org.junit.Test;

import course.labs.healthinmind.roomdatabase.BaseRoomTest;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineDao;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineRoomImpl;
import course.labs.healthinmind.roomdatabase.TestUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;


public class MedicineRoomImplTest extends BaseRoomTest {

    private MedicineDao medicineDao;

    public void createDb(){
        super.createDb();
        medicineDao = db.medicineDao();
    }

    @Test
    public void createAMedicine(){
        try {
            MedicineRoomImpl paracetamol = TestUtil.createMedicine("Paracetamol");
            long insertedMedicineId = medicineDao.insert(paracetamol);
            MedicineRoomImpl createdMedicine = medicineDao.fetchById(insertedMedicineId);
            assertEquals(createdMedicine.getMedicineId(), insertedMedicineId);
            assertNotNull(createdMedicine.getInstructions());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
