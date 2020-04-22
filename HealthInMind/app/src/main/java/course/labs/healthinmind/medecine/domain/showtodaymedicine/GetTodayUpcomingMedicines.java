package course.labs.healthinmind.medecine.domain.showtodaymedicine;

import java.time.LocalTime;
import java.util.List;

import course.labs.healthinmind.common.AppExecutors;
import course.labs.healthinmind.remindmedicine.RemindMedicinesRepository;

public class GetTodayUpcomingMedicines {

    private GetTodayUpcomingMedicinesOutputPort outputPort;
    private RemindMedicinesRepository remindMedicinesRepository;

    public GetTodayUpcomingMedicines(GetTodayUpcomingMedicinesOutputPort outputPort, RemindMedicinesRepository remindMedicinesRepository) {
        this.outputPort = outputPort;
        this.remindMedicinesRepository = remindMedicinesRepository;
    }

    public void getUpcomingMedicines(){
        AppExecutors.getInstance().diskIO().execute(() -> {
            List<UpcomingMedicine> medicines = remindMedicinesRepository.getUpcomingMedicines(LocalTime.now());
            if (medicines.isEmpty()) {
                outputPort.onNoUpcomingMedicines();
            }else {
                outputPort.onUpcomingMedicines(medicines);
            }
        });
    }
}
