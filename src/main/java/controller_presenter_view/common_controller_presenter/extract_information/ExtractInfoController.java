package controller_presenter_view.common_controller_presenter.extract_information;

import use_cases.extract_information_use_case.ExtractInfoInputBoundary;
import use_cases.extract_information_use_case.ExtractInfoRequestModel;
import use_cases.extract_information_use_case.ExtractInfoResponseModel;

public class ExtractInfoController {

    final ExtractInfoInputBoundary INPUT;

    /**The constructor for this class.
     *
     * @param INPUT The INPUT boundary for extracting information
     */
    public ExtractInfoController(ExtractInfoInputBoundary INPUT) {
        this.INPUT=INPUT;
    }

    /**A method for getting information from organizations,
     *
     * @param keyword A string indicating which information to find. It can be one of these:
     *                - "getPassword": gets an organization's password
     *                - "getUnpublishedEvents": gets an organization's unpublished events
     *                - "getPastEvents": gets an organization's past events
     *                - "getUpcomingEvents": gets an organization's upcoming events
     *                - "organizerSearch": gets all organizations whose username contains para1 (below).
     * @param para1 The usernaame of the organization
     * @return A response model containing the information found
     */
    public ExtractInfoResponseModel<String> extractOrg(String keyword, String para1) {
        ExtractInfoRequestModel requestModel = new ExtractInfoRequestModel(keyword, para1);
        return INPUT.extractOrgInfo(requestModel);
    }

    /**A method for getting information from participants.
     *
     * @param keyword A string indicating which information to find. It can be one of these:
     *                - "getPassword": gets a participant's password
     *                - "getNotifications": gets a participant's notifications
     *                - "getUpcomingEvents": gets a participant's upcoming events
     *                - "getPastEvents": gets a participant's events they already attended
     *                - "getFollowedOrg": gets the organizations that the participant follows
     * @param para1 The username of the participant
     * @return A response model containing the information found
     */
    public ExtractInfoResponseModel<String> extractPar(String keyword, String para1) {
        ExtractInfoRequestModel requestModel = new ExtractInfoRequestModel(keyword, para1);
        return INPUT.extractParInfo(requestModel);
    }

    /**A method for getting event time information.
     *
     * @param para1 The title of the event
     * @return A response model containing the time of the event
     */
    public ExtractInfoResponseModel<Integer> extractEventTime(String para1) {
        ExtractInfoRequestModel requestModel = new ExtractInfoRequestModel(para1);
        return INPUT.extractTimeInfo(requestModel);
    }

    /**A method for getting event information that is not time.
     *
     * @param keyword A string indicating which information to find. It can be one of these:
     *                - "getStatus": gets the status of the event
     *                - "getDescription": gets the description of the event
     *                - "getLocation": gets the location of the event
     *                - "getParticipants": gets the participants registered for the event
     *                - "getOrganization": gets the organization that created the event
     *                - "eventSearch": gets all events whose titles contain para1 (below).
     * @param para1 The title of the event
     * @return A response model containing the information found
     */
    public ExtractInfoResponseModel<String> extractEvent(String keyword, String para1){
        ExtractInfoRequestModel requestModel = new ExtractInfoRequestModel(keyword, para1);
        return INPUT.extractEventInfo(requestModel);
    }
}
