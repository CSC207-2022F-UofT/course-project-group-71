package tutorial;

import java.util.ArrayList;

public interface EventDsGateway {
    public int getStatus(String title);

    public int getType(String title);

    public String getDescription(String title);

    public String getLocation(String title);

    public String getImagePath(String title);

    public ArrayList<Integer> getTime(String title);

    public boolean checkIfEventnameExist(String eventname);

    //Should Delete All relationships with events and the event itself
    public void deleteEvent(String event_title);
}
