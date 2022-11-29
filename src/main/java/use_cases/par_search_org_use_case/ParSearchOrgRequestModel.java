package use_cases.par_search_org_use_case;

/** The request model of participant search for organizers.
 *  Contains query and parUserName.
 */
public class ParSearchOrgRequestModel {

    private final String query;
    private final String parUserName;

    /**A request model sent the interactor to search an organizer.
     *
     * @param query String to be searched
     * @param parUserName Name of the participant
     */
    public ParSearchOrgRequestModel(String query, String parUserName) {
        this.query = query;
        this.parUserName= parUserName;
    }

    /**A method to get the string to be searched from the request model.
     *
     * @return Name of the participant currently searching for organizers
     */
    public String getQuery() {
        return this.query;
    }

    /**A method to set the string to be searched.
     */

    /**A method to get the name of the participant from the request model.
     *
     * @return Name of the participant currently searching for organizers
     */
    public String getParUserName() {
        return parUserName;
    }

}
