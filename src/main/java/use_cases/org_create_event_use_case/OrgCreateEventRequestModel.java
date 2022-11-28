package use_cases.org_create_event_use_case;

/** The request model for the organization create event use case.
 *  Contains the attributes orgUsername, title, description, location, year, month, day, hour, minute.
 *  There is a getter method for each class attribute.
 */
public class OrgCreateEventRequestModel {

    String orgUsername;
    String title;
    String description;
    String location;
    String year;
    String month;
    String day;
    String hour;
    String minute;

    public OrgCreateEventRequestModel(String orgUsername,
                                      String title,
                                      String description,
                                      String location,
                                      String year,
                                      String month,
                                      String day,
                                      String hour,
                                      String minute) {
        this.orgUsername = orgUsername;
        this.title = title;
        this.description = description;
        this.location = location;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    public String getOrgUsername() {
        return this.orgUsername;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getLocation() {
        return this.location;
    }

    public String getYear() {
        return this.year;
    }

    public String getMonth() {
        return this.month;
    }

    public String getDay() {
        return this.day;
    }

    public String getHour() {
        return this.hour;
    }

    public String getMinute() {
        return this.minute;
    }
}
