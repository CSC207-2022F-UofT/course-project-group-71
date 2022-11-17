package database;

import java.util.ArrayList;

public interface EventDsGateway {
    // Return the status of the eventDsDateway
    // There are 3 possible return value: "Unpublished", "Past", "Upcoming"
    public String getStatus(String title);

    // Return the event_type which is stored as integer
    public int getType(String title);

    // Return the description of the event
    public String getDescription(String title);

    // Return the location of the event
    public String getLocation(String title);

    // Return the image path of the event
    public String getImagePath(String title);

    //Return the time of the event
    public ArrayList<Integer> getTime(String title);

    // It will return the organization that runs the event
    public String getOrganization(String title);



    // It will check if the event name of exists
    // This function is used for event creation
    public boolean checkIfEventNameExist(String eventname);

    // It will delete the event and all the relevant relationships from the database
    public void deleteEvent(String event_title);

    // It will return the participants list of the event
    public ArrayList<String> getParticipants(String title);



    // Change the status of the event from unpublished to upcoming
    public void UnpublishedToUpcoming(String title);

    // Change the status of the event from upcomign to past
    public void UpcomingToPast(String title);
}
