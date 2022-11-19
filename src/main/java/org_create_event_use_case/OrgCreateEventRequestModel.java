package org_create_event_use_case;

/** The request model of user registration.
 *  Contains orgUsername, title, description, location, year, month, day, hour, minute.
 */
public class OrgCreateEventRequestModel {

    private String orgUsername;
    private String title;
    private String description;
    private String location;
    private String year;
    private String month;
    private String day;
    private String hour;
    private String minute;

    /**A request model sent the interactor to create an event.
     *
     * @param orgUsername The username of the user creating events
     * @param title The title of event
     * @param description The description of event
     * @param location The location of event
     * @param year The time(year) of event taking place
     * @param month The time(month) of event taking place
     * @param day The time(day) of event taking place
     * @param hour The time(hour) of event taking place
     * @param minute The time(minute) of event taking place
     */
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

    /**A method to get the name of the organizer from the request model。
     *
     * @return Name of the organizer currently creating an event
     */
    public String getOrgUsername() {
        return this.orgUsername;
    }

    /**A method to get the title of the event from the request model。
     *
     * @return Title of event currently being created
     */
    public String getTitle() {
        return this.title;
    }

    /**A method to get the description of the event from the request model。
     *
     * @return Description of the event currently being created
     */
    public String getDescription() {
        return this.description;
    }

    /**A method to get the location of the event from the request model。
     *
     * @return location of the event currently being created
     */
    public String getLocation() {
        return this.location;
    }

    /**A method to get the year of the event from the request model。
     *
     * @return year of the event currently being created
     */
    public String getYear() {
        return this.year;
    }

    /**A method to get the month of the event from the request model。
     *
     * @return month of the event currently being created
     */
    public String getMonth() {
        return this.month;
    }

    /**A method to get the day of the event from the request model。
     *
     * @return day of the event currently being created
     */
    public String getDay() {
        return this.day;
    }

    /**A method to get the hour of the event from the request model。
     *
     * @return hour of the event currently being created
     */
    public String getHour() {
        return this.hour;
    }

    /**A method to get the minute of the event from the request model。
     *
     * @return minute of the event currently being created
     */
    public String getMinute() {
        return this.minute;
    }
}
