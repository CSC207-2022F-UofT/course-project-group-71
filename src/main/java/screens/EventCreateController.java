package screens;

import event_create_use_case.EventCreateInputBoundary;
import event_create_use_case.EventCreateRequestModel;

public class EventCreateController {

    final EventCreateInputBoundary userInput;

    public EventCreateController(EventCreateInputBoundary userInput) {
        this.userInput = userInput;
    }

    public void create(String orgUsername,
                       String title,
                       int status,
                       int eventType,
                       String description,
                       String location,
                       String imagePath,
                       int year,
                       int month,
                       int day,
                       int hour,
                       int minute){
        EventCreateRequestModel requestModel = new EventCreateRequestModel(
                orgUsername, title, status, eventType, description, location, imagePath, year, month, day, hour,
                minute);
        userInput.create(requestModel);
    }


}
