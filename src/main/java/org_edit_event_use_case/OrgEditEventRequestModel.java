package org_edit_event_use_case;

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

    public OrgEditEventRequestModel(String orgUsername,
                                    String title,
                                    String description,
                                    String location,
                                    String year,
                                    String month,
                                    String day,
                                    String hour) {
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

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return this.month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return this.day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return this.hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return this.minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }
}
