package use_cases.org_edit_event_use_case;

/** The response model sent back to the page.
 *  Containing message and title.
 */
public class OrgEditEventResponseModel {

    String message;
    String title;

    public OrgEditEventResponseModel(String title) {
        this.title = title;
    }

    public void setMessage(String message) { this.message = message; }

    public String getMessage() { return this.message;}

    public String getTitle() {
        return this.title;
    }
}
