package use_cases.par_search_event_use_case;

import java.util.ArrayList;

/** The response model sent back to the page.
 *  Containing the searchResults and parUserName.
 */
public class ParSearchEventResponseModel {

    private final ArrayList<String> searchResults;
    private final String parUserName;

    /**This is the construct method of ParSearchEventResponseModel, it takes searchResults and parUserName, then store them as instance.
     *
     * @param searchResults The results of event search
     * @param parUserName The username of the participant
     */
    public ParSearchEventResponseModel(ArrayList<String> searchResults, String parUserName) {
        this.searchResults = searchResults;
        this.parUserName=parUserName;
    }

    /**This is a method to get the returned searchResults.
     *
     * @return The searchResults
     */
    public ArrayList<String> getSearchResults() {
        return searchResults;
    }


    /**This is a method to get the returned participant username.
     *
     * @return The participant username
     */
    public String getParUserName() {
        return parUserName;
    }

}
