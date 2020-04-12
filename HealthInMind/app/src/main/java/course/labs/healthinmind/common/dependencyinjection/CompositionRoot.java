package course.labs.healthinmind.common.dependencyinjection;

import android.app.Application;

import course.labs.healthinmind.medecine.MedicineFactory;
import course.labs.healthinmind.medecine.MedicineFactoryRoomImpl;
import course.labs.healthinmind.medecine.MedicineRepository;
import course.labs.healthinmind.medecine.MedicineRepositoryImpl;
import course.labs.healthinmind.medecine.MedicineRoomDatabaseProvider;
import course.labs.healthinmind.medecine.MedicinesLocalProvider;

public class CompositionRoot {
    private Application application;

    public CompositionRoot(Application application) {
        this.application = application;
    }

    public MedicineRepository getMedicineRepository(){
        return new MedicineRepositoryImpl(getMedicinesLocalProvider());
    }

    private MedicinesLocalProvider getMedicinesLocalProvider(){
        return new MedicineRoomDatabaseProvider(application);
    }


}
