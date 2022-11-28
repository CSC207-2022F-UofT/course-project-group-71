package controller_presenter_view.common_controller_presenter.extract_information;

import use_cases.extract_information_use_case.ExtractInfoInputBoundary;
import use_cases.extract_information_use_case.ExtractInfoRequestModel;
import use_cases.extract_information_use_case.ExtractInfoResponseModel;

public class ExtractInfoController {

    ExtractInfoInputBoundary input;

    /**The constructor for this class.
     *
     * @param input The input boundary for extracting information
     */
    public ExtractInfoController(ExtractInfoInputBoundary input) {
        this.input=input;
        }

    /**A method for getting information from organizations,
     *
     * @param keyword A string indicating which information to find. It can be one of these:
     *                - "getPassword": gets an organization's password
     *                - "getUnpublishedEvents": gets an organization's unpublished events
     *                - "getPastEvents": gets an organization's past events
     *                - "getUpcomingEvents": gets an organization's upcoming events
     *                - "organizerSearch": searches for organizations whose username contains para1 (below).
     * @param para1 The usernaame of the organization
     * @return A response model containing the information found
     */
    public ExtractInfoResponseModel<String> extractOrg(String keyword, String para1) {
        ExtractInfoRequestModel requestModel = new ExtractInfoRequestModel(keyword, para1);
        return input.extractOrgInfo(requestModel);
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
    public ExtractInfoResponseModel<String> extractPar(String keyword, String para1){
        ExtractInfoRequestModel requestModel= new ExtractInfoRequestModel(keyword, para1);
        return input.extractParInfo(requestModel);
    }

    public ExtractInfoResponseModel<Integer> extractEventTime(String para1){
        ExtractInfoRequestModel requestModel= new ExtractInfoRequestModel(para1);
        return input.extractTimeInfo(requestModel);
    }

    public ExtractInfoResponseModel<String> extractEvent(String keyword, String para1){
        ExtractInfoRequestModel requestModel= new ExtractInfoRequestModel(keyword, para1);
        return input.extractEventInfo(requestModel);
    }
}
