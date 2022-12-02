package use_cases.org_edit_event_use_case;

/** The request model of event editing.
 *  Contains orgUsername, title, description, location, year, month, day, hour, minute.
 */
public class OrgEditEventRequestModel {
    final String title;
    final String description;
    final String location;
    final String year;
    final String month;
    final String day;
    final String hour;
    final String minute;

    /**A request model sent the interactor to edit an event.
     *
     * @param title The title of event
     * @param description The description of event
     * @param location The location of event
     * @param year The time(year) of event taking place
     * @param month The time(month) of event taking place
     * @param day The time(day) of event taking place
     * @param hour The time(hour) of event taking place
     * @param minute The time(minute) of event taking place
     */
    public OrgEditEventRequestModel(String title,
                                    String description,
                                    String location,
                                    String year,
                                    String month,
                                    String day,
                                    String hour,
                                    String minute) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
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
