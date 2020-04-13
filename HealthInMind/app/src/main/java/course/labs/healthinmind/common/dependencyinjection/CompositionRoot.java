package course.labs.healthinmind.common.dependencyinjection;

import android.app.Application;

import course.labs.healthinmind.medecine.data.abstractions.MedicineRepository;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineRepositoryImpl;
import course.labs.healthinmind.medecine.data.roomimplementation.MedicineRoomDatabaseProvider;
import course.labs.healthinmind.medecine.data.abstractions.MedicinesLocalProvider;

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
