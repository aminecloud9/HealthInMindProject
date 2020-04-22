package course.labs.healthinmind.screens.home;

import java.util.List;

import course.labs.healthinmind.medecine.domain.showtodaymedicine.UpcomingMedicine;

interface  HomeView {
    void showEmptyMedicines();
    void showMedicinesList(List<UpcomingMedicine> medicines);
    void showEmptyUpcomingAppointments();
    void showUpcomingAppointments();
}
