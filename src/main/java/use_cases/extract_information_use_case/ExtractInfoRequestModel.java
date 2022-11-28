package use_cases.extract_information_use_case;




public class ExtractInfoRequestModel {

    String keyword, para;

    /**Constructs a request model for extracting information about
     * participants, organizers, and events (except for event times)
     *
     * @param keyword A command indicating which information to get
     * @param para The username of a particpant, the username of an organization,
     *             or the title of an event
     */
    public ExtractInfoRequestModel(String keyword,String para){
        this.keyword = keyword;
        this.para = para;
    }

    /**Constructs a request model for extracting information about event times
     *
     * @param para The title of an event
     */
    public ExtractInfoRequestModel(String para){
        this.para = para;
    }

    /**A getter for the attribute para
     *
     * @return A string containing the username of a participant,
     *         the username of an organization,  or the title of an event
     */
    public String getPara() {
        return para;
    }

    /**A getter for the attribute keyword
     *
     * @return A string containing a command indicating which information
     *         to get
     */
    public String getKeyword() {
        return keyword;
    }
}
