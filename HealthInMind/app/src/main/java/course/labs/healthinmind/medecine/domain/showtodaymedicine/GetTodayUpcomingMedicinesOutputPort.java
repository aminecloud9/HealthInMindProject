package course.labs.healthinmind.medecine.domain.showtodaymedicine;

import java.util.List;

public interface GetTodayUpcomingMedicinesOutputPort {
    void onNoUpcomingMedicines();
    void onUpcomingMedicines(List<UpcomingMedicine> upcomingMedicine);
}
