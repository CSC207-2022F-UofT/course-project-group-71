package event_create_screens;

import event_create_use_case.EventCreateInputBoundary;
import event_create_use_case.EventCreateRequestModel;
import event_create_use_case.EventCreateResponseModel;

public class EventCreateController {

    final EventCreateInputBoundary userInput;

    public EventCreateController(EventCreateInputBoundary userInput) {
        this.userInput = userInput;
    }

    EventCreateResponseModel create(String title,
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
                title, status, eventType, description, location, imagePath, year, month, day, hour, minute);
        return userInput.create(requestModel);
    }


}
