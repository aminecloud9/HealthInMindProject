package course.labs.healthinmind.medecine.domain.addmedicineusecase;

import java.util.ArrayList;
import java.util.List;

public class AddMedicineResponse {
    private boolean successful ;
    private List<String> messages = new ArrayList<>();

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public void addMessage(String message){
        messages.add(message);
    }

    public boolean isSuccessful() {
        return successful;
    }

    public List<String> getMessages() {
        return messages;
    }
}
