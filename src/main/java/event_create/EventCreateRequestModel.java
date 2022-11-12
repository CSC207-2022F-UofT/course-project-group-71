package event_create;

public class EventCreateRequestModel {

    private String title;
    private int status;
    private int eventType;
    private String description;
    private String location;
    private String imagePath;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    public EventCreateRequestModel(String title,
                                   int status,
                                   int eventType,
                                   String description,
                                   String location,
                                   String imagePath,
                                   int year,
                                   int month,
                                   int day,
                                   int hour,
                                   int minute) {
        this.title = title;
        this.status = status;
        this.eventType = eventType;
        this.description = description;
        this.location = location;
        this.imagePath = imagePath;
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

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getEventType() {
        return this.eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
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

    public String getImagePath() {
        return this.imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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
