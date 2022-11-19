package org_create_event_use_case;

/** The response model sent back to the page.
 *  Containing message, orgUsername, title, status, description, location, year, month, day, hour, minute.
 */
public class OrgCreateEventResponseModel {

    private String message;
    private String orgUsername;
    private String title;
    private int status;
    private String description;
    private String location;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    /**This is the construct method of UserRegisterResponseModel, it took a username and store it as instance.
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
    public OrgCreateEventResponseModel(String orgUsername,
                                       String title,
                                       int status,
                                       String description,
                                       String location,
                                       int year,
                                       int month,
                                       int day,
                                       int hour,
                                       int minute) {
        this.orgUsername = orgUsername;
        this.title = title;
        this.status = status;
        this.description = description;
        this.location = location;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    /**This is a method to set the message sent back
     *
     * @param message The message to set
     */
    public void setMessage(String message) { this.message = message; }

    /**This is a method to get the message sent back
     *
     * @return The message sent back
     */
    public String getMessage() { return this.message;}

    /**This is a method to get the username.
     *
     * @return The username currently creating events
     */
    public String getOrgUsername() {
        return this.orgUsername;
    }

    /**A method to set the name of the organizer。
     *
     * @param orgUsername of the organizer currently creating an event
     */
    public void setOrgUsername(String orgUsername) {
        this.orgUsername = orgUsername;
    }

    /**A method to get the title of the event。
     *
     * @return Title of event currently being created
     */
    public String getTitle() {
        return this.title;
    }

    /**A method to set the title of the event。
     *
     * @param title of event currently being created
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**A method to get the current status of org creating an event。
     *
     * @return status of event currently being created
     */
    public int getStatus() {
        return this.status;
    }

    /**A method to set the status of the event。
     *
     * @param status of event currently being created
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**A method to get the description of the event。
     *
     * @return description of event currently being created
     */
    public String getDescription() {
        return this.description;
    }

    /**A method to set the description of the event。
     *
     * @param description of event currently being created
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**A method to get the location of the event。
     *
     * @return location of event currently being created
     */
    public String getLocation() {
        return this.location;
    }

    /**A method to set the location of the event。
     *
     * @param location of event currently being created
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**A method to get the year of the event。
     *
     * @return year of event currently being created
     */
    public int getYear() {
        return this.year;
    }

    /**A method to set the year of the event。
     *
     * @param year of event currently being created
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**A method to get the month of the event。
     *
     * @return month of event currently being created
     */
    public int getMonth() {
        return this.month;
    }

    /**A method to set the month of the event。
     *
     * @param month of event currently being created
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**A method to get the day of the event。
     *
     * @return day of event currently being created
     */
    public int getDay() {
        return this.day;
    }

    /**A method to set the day of the event。
     *
     * @param day of event currently being created
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**A method to get the hour of the event。
     *
     * @return hour of event currently being created
     */
    public int getHour() {
        return this.hour;
    }

    /**A method to set the hour of the event。
     *
     * @param hour of event currently being created
     */
    public void setHour(int hour) {
        this.hour = hour;
    }

    /**A method to get the minute of the event。
     *
     * @return minute of event currently being created
     */
    public int getMinute() {
        return this.minute;
    }

    /**A method to set the minute of the event。
     *
     * @param minute of event currently being created
     */
    public void setMinute(int minute) {
        this.minute = minute;
    }
}
