package org_edit_event_use_case;

/** The response model sent back to the page.
 *  Containing message and title.
 */
public class OrgEditEventResponseModel {

    private String message;
    private String title;

    /**This is the construct method of OrgEditEventResponseModel, it took a title and store it as instance.
     *
     * @param title The title of event
     */
    public OrgEditEventResponseModel(String title) {
        this.title = title;
    }

    /**This is a method to set the message sent back
     *
     * @param message The message to set
     */
    public void setMessage(String message) { this.message = message; }

    /**This is a method to get the message sent back
     *
     * @return The message sent back
     */
    public String getMessage() { return this.message;}

    /**A method to get the title of the event。
     *
     * @return Title of event currently being edited
     */
    public String getTitle() {
        return this.title;
    }
}
