package use_cases.upcoming_to_past_use_case;

import java.util.ArrayList;

public class UpcomingToPastResponseModel {
    final ArrayList<String> eventsToPast;
    String message;

    public UpcomingToPastResponseModel(ArrayList<String> eventsToPast) {
        this.eventsToPast = eventsToPast;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<String> getEventsToPast() {
        return eventsToPast;
    }

    public String getMessage() { return message; }
}
