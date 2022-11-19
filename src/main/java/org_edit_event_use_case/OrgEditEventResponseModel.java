package org_edit_event_use_case;

public class OrgEditEventResponseModel {

    private String message;
    private String title;

    public OrgEditEventResponseModel(String title) {
        this.title = title;
    }

    public void setMessage(String message) { this.message = message; }

    public String getMessage() { return this.message;}

    public String getTitle() {
        return this.title;
    }
}
