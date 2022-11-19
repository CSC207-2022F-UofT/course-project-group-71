package org_create_event_use_case;

public class OrgCreateEventResponseModel {

    private String message;
    private String title;

    public OrgCreateEventResponseModel(String title) {
        this.title = title;
    }

    public void setMessage(String message) { this.message = message; }

    public String getMessage() { return this.message;}

    public String getTitle() {
        return this.title;
    }
}
