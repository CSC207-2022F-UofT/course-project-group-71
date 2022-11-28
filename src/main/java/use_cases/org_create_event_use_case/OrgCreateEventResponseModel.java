package use_cases.org_create_event_use_case;

/** The response model containing information sent back to the page.
 *  Containing message and title.
 *  There is a setter method for the message and getter methods
 *  for both the message and title.
 */
public class OrgCreateEventResponseModel {

    String message;
    String title;

    public OrgCreateEventResponseModel(String title) {
        this.title = title;
    }

    public void setMessage(String message) { this.message = message; }

    public String getMessage() { return this.message;}

    public String getTitle() {
        return this.title;
    }
}
