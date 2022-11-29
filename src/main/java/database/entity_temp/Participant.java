package database.entity_temp;

import java.util.ArrayList;

public class Participant {
    private String username;
    private String password;
    private ArrayList<String> past_events;
    private ArrayList<String> upcoming_events;
    private ArrayList<String> following_list;
    public Participant(String username, String password, ArrayList<String> past_events, ArrayList<String> upcoming_events, ArrayList<String> following_list) {
        this.username = username;
        this.password = password;
        this.past_events = past_events;
        this.upcoming_events = upcoming_events;
        this.following_list = following_list;
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

    public ArrayList<String> getFollowing_list() {
        return following_list;
    }

    public void setFollowing_list(ArrayList<String> following_list) {
        this.following_list = following_list;
    }

    public void unfollowOrg(String orgUsername){
        this.following_list.remove(orgUsername);
    }
}
