package database.entity_temp;

import java.util.ArrayList;

public class Organization {
    private String username;
    private String password;
    private ArrayList<String> unpublished_events;
    private ArrayList<String> past_events;
    private ArrayList<String> upcoming_events;
    private ArrayList<String> followers;
    public Organization(String username, String password, ArrayList<String> unpublished_events, ArrayList<String> past_events, ArrayList<String> upcoming_events, ArrayList<String> followers) {
        this.username = username;
        this.password = password;
        this.unpublished_events = unpublished_events;
        this.past_events = past_events;
        this.upcoming_events = upcoming_events;
        this.followers = followers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getUnpublished_events() {
        return unpublished_events;
    }

    public void setUnpublished_events(ArrayList<String> unpublished_events) {
        this.unpublished_events = unpublished_events;
    }

    public ArrayList<String> getPast_events() {
        return past_events;
    }

    public void setPast_events(ArrayList<String> past_events) {
        this.past_events = past_events;
    }

    public ArrayList<String> getUpcoming_events() {
        return upcoming_events;
    }

    public void setUpcoming_events(ArrayList<String> upcoming_events) {
        this.upcoming_events = upcoming_events;
    }

    public ArrayList<String> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<String> followers) {
        this.followers = followers;
    }

}
