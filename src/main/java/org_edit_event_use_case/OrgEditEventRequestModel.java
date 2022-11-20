package org_edit_event_use_case;

/** The request model of event editing.
 *  Contains orgUsername, title, description, location, year, month, day, hour, minute.
 */
public class OrgEditEventRequestModel {

    private String orgUsername;
    private String title;
    private String description;
    private String location;
    private String year;
    private String month;
    private String day;
    private String hour;
    private String minute;

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

    /**A method to get the title of the event from the request model.
     *
     * @return Title of event currently being edited
     */
    public String getTitle() {
        return this.title;
    }

    /**A method to get the description of the event from the request model.
     *
     * @return Description of the event currently being edited
     */
    public String getDescription() {
        return this.description;
    }

    /**A method to get the location of the event from the request model.
     *
     * @return location of the event currently being edited
     */
    public String getLocation() {
        return this.location;
    }

    /**A method to get the year of the event from the request model.
     *
     * @return year of the event currently being edited
     */
    public String getYear() {
        return this.year;
    }

    /**A method to get the month of the event from the request model.
     *
     * @return month of the event currently being edited
     */
    public String getMonth() {
        return this.month;
    }

    /**A method to get the day of the event from the request model.
     *
     * @return day of the event currently being edited
     */
    public String getDay() {
        return this.day;
    }

    /**A method to get the hour of the event from the request model.
     *
     * @return hour of the event currently being edited
     */
    public String getHour() {
        return this.hour;
    }

    /**A method to get the minute of the event from the request model.
     *
     * @return minute of the event currently being edited
     */
    public String getMinute() {
        return this.minute;
    }

}
