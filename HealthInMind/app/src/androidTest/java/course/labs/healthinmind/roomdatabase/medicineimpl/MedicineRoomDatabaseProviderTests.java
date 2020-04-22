package course.labs.healthinmind.roomdatabase.medicineimpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.text.ParseException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import course.labs.healthinmind.common.Form;
import course.labs.healthinmind.common.Quantity;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineDao;
import course.labs.healthinmind.medecine.domain.showtodaymedicine.UpcomingMedicine;
import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderDao;
import course.labs.healthinmind.reminders.data.roomimplimentation.ReminderRoomImpl;
import course.labs.healthinmind.remindmedicine.RemindMedicineDao;
import course.labs.healthinmind.remindmedicine.RemindMedicineRoomDataSource;
import course.labs.healthinmind.remindmedicine.RemindMedicineRoomImpl;
import course.labs.healthinmind.roomdatabase.BaseRoomTest;
import course.labs.healthinmind.roomdatabase.TestUtil;
import course.labs.healthinmind.screens.addmedicine.reminders.ReminderDto;

public class MedicineRoomDatabaseProviderTests extends BaseRoomTest {

    private RemindMedicineRoomDataSource medicineProvider;
    private MedicineDao medicineDao;
    private ReminderDao reminderDao;
    private RemindMedicineDao remindMedicineDao;

    @Before
    public void setUp(){
        super.createDb();
        medicineProvider = new RemindMedicineRoomDataSource(db);

        medicineDao = db.medicineDao();
        reminderDao = db.reminderDao();
        remindMedicineDao = db.remindMedicineDao();

    }

    @Test
    public void retrieveUpcomingMedicines(){
        givenASetOfMedicinesAndRemindersInTheDatabase();

        List<UpcomingMedicine> medicines = medicineProvider.getUpcomingMedicines(LocalTime.now());

        shouldRetrieveOnlyUpcomingMedicines(medicines);
    }
    private void givenASetOfMedicinesAndRemindersInTheDatabase() {
        try {
            long paracetamolId = medicineDao.insert(TestUtil.createMedicine("Paracetamol", Form.PILL));
            long insulinId = medicineDao.insert(TestUtil.createMedicine("insulin",Form.INJECTIONS));

            List<Long> reminderIds = reminderDao.insertReminders(new ArrayList<ReminderRoomImpl>(){{
                add(new ReminderRoomImpl(LocalTime.of(22,0)));
                add(new ReminderRoomImpl(LocalTime.of(23,0)));
                add(new ReminderRoomImpl(LocalTime.of(21,0)));
                add(new ReminderRoomImpl(LocalTime.of(20,0)));
            }});

            remindMedicineDao.insertRemindMedicines(
              new ArrayList<RemindMedicineRoomImpl>(){{
                  new RemindMedicineRoomImpl(paracetamolId,reminderIds.get(0),Quantity.TWO);
                  new RemindMedicineRoomImpl(paracetamolId,reminderIds.get(2),Quantity.ONE);
                  new RemindMedicineRoomImpl(insulinId,reminderIds.get(1),Quantity.ONE);
                  new RemindMedicineRoomImpl(insulinId,reminderIds.get(3),Quantity.ONE);
              }}
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void shouldRetrieveOnlyUpcomingMedicines(List<UpcomingMedicine> medicines) {
        Assert.assertNotNull(medicines);
        Assert.assertFalse(medicines.isEmpty());
    }




}
