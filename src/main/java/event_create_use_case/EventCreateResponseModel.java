package event_create_use_case;

public class EventCreateResponseModel {

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

    public EventCreateResponseModel(String orgUsername,
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

    public String getOrgUsername() {
        return this.orgUsername;
    }

    public void setOrgUsername() {
        this.orgUsername = orgUsername;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return this.hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
