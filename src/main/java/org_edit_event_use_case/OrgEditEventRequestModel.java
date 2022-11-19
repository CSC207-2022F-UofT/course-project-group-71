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
