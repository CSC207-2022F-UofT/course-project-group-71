package par_search_event_use_case;

/** The request model of participant search for event.
 *  Contains query and parUserName.
 */
public class ParSearchEventRequestModel {

    private String query;
    private String parUserName;

    /**A request model sent the interactor to create a user.
     *
     * @param query String to be searched
     * @param parUserName Name of the participant
     */
    public ParSearchEventRequestModel(String query, String parUserName) {
        this.query = query;
        this.parUserName= parUserName;
    }

    /**A method to get the string to be searched from the request model。
     *
     * @return Name of the participant currently searching for events
     */
    public String getQuery() {
        return this.query;
    }

    /**A method to get the name of the participant from the request model。
     *
     * @return Name of the participant currently searching for events
     */
    public String getParUserName() {
        return parUserName;
    }

    /**A method to set the name of the participant。
     */
    public void setParUserName(String parUserName) {
        this.parUserName = parUserName;
    }

    /**A method to set the string to be searched.
     */
    public void setQuery(String query) {
        this.query = query;
    }
}
