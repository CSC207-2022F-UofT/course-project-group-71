package use_cases.extract_information_use_case;

public class ExtractInfoRequestModel {

    final String KEYWORD;
    final String PARA;

    /**Constructs a request model for extracting information about
     * participants, organizers, and events (except for event times)
     *
     * @param KEYWORD A command indicating which information to get
     * @param PARA The username of a participant, the username of an organization,
     *             or the title of an event
     */
    public ExtractInfoRequestModel(String KEYWORD, String PARA){
        this.KEYWORD = KEYWORD;
        this.PARA = PARA;
    }

    /**Constructs a request model for extracting information about event times
     *
     * @param PARA The title of an event
     */
    public ExtractInfoRequestModel(String PARA){
        this.PARA = PARA;
        KEYWORD = null;
    }

    /**A getter for the attribute PARA
     *
     * @return A string containing the username of a participant,
     *         the username of an organization,  or the title of an event
     */
    public String getPara() {
        return PARA;
    }

    /**A getter for the attribute KEYWORD
     *
     * @return A string containing a command indicating which information
     *         to get
     */
    public String getKeyword() {
        return KEYWORD;
    }
}
