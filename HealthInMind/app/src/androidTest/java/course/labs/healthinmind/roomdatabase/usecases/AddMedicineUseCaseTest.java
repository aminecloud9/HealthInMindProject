package course.labs.healthinmind.roomdatabase.usecases;

import android.app.Application;
import android.os.Looper;
import android.util.Log;

import androidx.fragment.app.FragmentActivity;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.ParseException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import course.labs.healthinmind.common.Quantity;
import course.labs.healthinmind.common.dependencyinjection.CompositionRoot;
import course.labs.healthinmind.common.dependencyinjection.ControllerCompositionRoot;
import course.labs.healthinmind.database.HealthData;
import course.labs.healthinmind.medecine.data.abstractions.Medicine;
import course.labs.healthinmind.medecine.data.abstractions.MedicineRepository;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineDao;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineRoomImpl;
import course.labs.healthinmind.medecine.domain.addmedicineusecase.AddMedicineUseCase;
import course.labs.healthinmind.medecine.domain.addmedicineusecase.CreateMedicineRequest;
import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderDao;
import course.labs.healthinmind.remindmedicine.RemindMedicineDao;
import course.labs.healthinmind.roomdatabase.TestUtil;
import course.labs.healthinmind.screens.addmedicine.reminders.ReminderDto;


@RunWith(AndroidJUnit4.class)
public class AddMedicineUseCaseTest {


    private AddMedicineUseCase useCase;
    private CreateMedicineRequest request;
    private MedicineRepository medicineRepository;

    private MedicineDao medicineDao;
    private ReminderDao reminderDao;
    private RemindMedicineDao remindMedicineDao;
    private HealthData db;
    @Before
    public void createDb() {
        Looper.prepare();
        Application application = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(application, HealthData.class)
                .allowMainThreadQueries()
                .build();
        FragmentActivity fragmentActivity = new FragmentActivity();
        CompositionRoot compositionRoot = new CompositionRoot(application);
        ControllerCompositionRoot controllerCompositionRoot =
                new ControllerCompositionRoot(
                        compositionRoot,
                         fragmentActivity
                );
        medicineDao = db.medicineDao();
        reminderDao = db.reminderDao();
        remindMedicineDao = db.remindMedicineDao();
        medicineRepository = compositionRoot.getMedicineRepository();
        useCase = controllerCompositionRoot.getAddMedicineUseCase();

    }

    @After
    public void closeDb(){
        db.close();
    }

    @Test
    public void addMedicineUseCase(){
        try {
            request = new CreateMedicineRequest(
                    TestUtil.createMedicine("Paracetamol"),
                    new ArrayList<ReminderDto>(){{
                        add(new ReminderDto(LocalTime.of(7,0), Quantity.ONE));
                        add(new ReminderDto(LocalTime.of(12,0), Quantity.ONE));
                    }}
            );

            Long createdMedicineId = useCase.addMedicine(request);
            Medicine medicine = medicineRepository.getMedicine(createdMedicineId);
            Assert.assertNotNull(medicine);
            List<MedicineRoomImpl> medicineRooms = medicineDao.getAllMedcines();
            Log.d("medicines", String.valueOf(medicineRooms.size()));
            Log.d("createdMedicineId",createdMedicineId.toString());
//            Assert.assertEquals(2,medicineImp.reminders.size());
//            Assert.assertTrue(
//                    medicineImp.reminders
//                            .stream()
//                            .map(reminderRoom -> reminderRoom.time)
//                            .collect(Collectors.toList())
//                            .contains(LocalTime.of(7,0))
//            );

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
