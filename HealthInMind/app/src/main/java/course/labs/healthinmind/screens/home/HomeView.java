package course.labs.healthinmind.screens.home;

import java.util.List;

import course.labs.healthinmind.screens.home.homemedicineslist.HomeMedicineDto;

interface  HomeView {
    void showEmptyMedicines();
    void showMedicinesList(List<HomeMedicineDto> medicines);
    void showEmptyUpcomingAppointments();
    void showUpcomingAppointments();
}
