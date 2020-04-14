package course.labs.healthinmind.medecine.data.abstractions;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface MedicineFactory {

    Medicine createMedicineThatEnds(
            String name,
            int dosage,
            String form,
            int frequency,
            int refillQuantity,
            boolean toBeRemindedToRefill,
            Date startingDate,
            Date endingDate,
            double quantityToTake,
            String instructions,
            List<LocalTime> takingTimes
    );

    Medicine createMedicineThatDoesNotEnd(
            String name,
            int dosage,
            String form,
            int frequency,
            int refillQuantity,
            boolean toBeRemindedToRefill,
            Date startingDate,
            double quantityToTake,
            String instructions,
            List<LocalTime> takingTimes
    );
}
