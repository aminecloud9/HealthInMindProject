package course.labs.healthinmind.medecine;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface Medicine {
    String getMedicineName();
    int getDosage();
    String getForm();
    int getFrequency();
    int getRefillQuantity();
    boolean isRefillReminder();
    boolean isMedicineHasNoEndDate();
    Date getStartDate();
    Date getEndDate();
    List<LocalTime> getTakingTimes();
    double getQuantityToTake();
    String getInstructions();

}
