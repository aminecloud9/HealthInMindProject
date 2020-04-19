package course.labs.healthinmind.common.dependencyinjection;

import android.app.Application;

import course.labs.healthinmind.database.HealthData;
import course.labs.healthinmind.medecine.data.abstractions.MedicineRepository;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineRepositoryImpl;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineRoomDatabaseProvider;
import course.labs.healthinmind.medecine.data.abstractions.MedicinesLocalProvider;
import course.labs.healthinmind.reminders.data.RemindersDataSource;
import course.labs.healthinmind.reminders.data.RemindersRepositoryImp;
import course.labs.healthinmind.reminders.data.RemindersRoomDataSource;
import course.labs.healthinmind.reminders.data.abstractions.RemindersRepository;
import course.labs.healthinmind.remindmedicine.RemindMedicineDataSource;
import course.labs.healthinmind.remindmedicine.RemindMedicineRoomDataSource;
import course.labs.healthinmind.remindmedicine.RemindMedicinesRepository;
import course.labs.healthinmind.remindmedicine.RemindMedicinesRepositoryImpl;

public class CompositionRoot {
    private Application application;

    public CompositionRoot(Application application) {
        this.application = application;
    }

    public MedicineRepository getMedicineRepository(){
        return new MedicineRepositoryImpl(getMedicinesLocalProvider());
    }

    private MedicinesLocalProvider getMedicinesLocalProvider(){
        return new MedicineRoomDatabaseProvider(getDataBaseInstance());
    }

    RemindersRepository getRemindersRepository() {
        return new RemindersRepositoryImp(getRemindersRoomDataSource());
    }

    private RemindersDataSource getRemindersRoomDataSource() {
        return new RemindersRoomDataSource(getDataBaseInstance());
    }

    RemindMedicinesRepository getRemindMedicinesRepository() {
        return new RemindMedicinesRepositoryImpl(getRemindMedicinesRoomDataSource());
    }

    private RemindMedicineDataSource getRemindMedicinesRoomDataSource() {
        return new RemindMedicineRoomDataSource(getDataBaseInstance());
    }

    private HealthData getDataBaseInstance() {
        return HealthData.getInstance(application);
    }
}
