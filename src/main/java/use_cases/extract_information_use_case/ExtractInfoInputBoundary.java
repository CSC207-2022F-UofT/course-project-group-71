package use_cases.extract_information_use_case;

public interface ExtractInfoInputBoundary {

    /**A method for getting event information that is not the event time
     *
     * @param requestModel A request model containing the event title
     *                     and which information to extract
     * @return A response model containing the desired information
     */
    ExtractInfoResponseModel<String> extractEventInfo(ExtractInfoRequestModel requestModel);

    /**A method for getting organization information
     *
     * @param requestModel A request model containing the organization username
     *                     and which information to extract
     * @return A response model containing the desired information
     */
    ExtractInfoResponseModel<String> extractOrgInfo(ExtractInfoRequestModel requestModel);

    /**A method for getting participant information
     *
     * @param requestModel A request model containing the participant username
     *                     and which information to extract
     * @return A response model containing the desired information
     */
    ExtractInfoResponseModel<String> extractParInfo(ExtractInfoRequestModel requestModel);

    /**A method for getting event time information
     *
     * @param requestModel A request model containing the event title
     * @return A response model containing the event time
     */
    ExtractInfoResponseModel<Integer> extractTimeInfo(ExtractInfoRequestModel requestModel);
}
