package use_cases.extract_information_use_case;


import database.*;

import java.sql.SQLException;

public class ExtractInfoInteractor implements ExtractInfoInputBoundary {

    EventDsGateway eventDsGateway;
    OrgDsGateway orgDsGateway;
    ParDsGateway parDsGateway;

    /**Constructs an ExtractInfoInteractor to get information about events
     *
     * @param eventDsGateway A database gateway for the event database
     */
    public ExtractInfoInteractor(EventDsGateway eventDsGateway) {this.eventDsGateway = eventDsGateway;}

    /**Constructs an ExtractInfoInteractor to get information about organizations
     *
     * @param orgDsGateway A database gateway for the organization database
     */
    public ExtractInfoInteractor(OrgDsGateway orgDsGateway){
        this.orgDsGateway = orgDsGateway;
    }

    /**Constructs an ExtractInfoInteractor to get information about participants
     *
     * @param parDsGateway A database gateway for the participant database
     */
    public ExtractInfoInteractor(ParDsGateway parDsGateway){
        this.parDsGateway = parDsGateway;
    }

    /**This method is used to obtain all kinds of event information expect for time.
     * Use the argument *para* from responseModel to get eventTitle.
     * Use the argument *keyword* from responseModel to decide which info to retrieve from eventDsGateway.
     *
     * @param requestModel The request model sent to the interactor
     * @return A responseModel representing whether the event creation is successful
     */
    @Override
    public ExtractInfoResponseModel<String> extractEventInfo(ExtractInfoRequestModel requestModel) {

        String eventTitle = requestModel.getPara();
        String keyword = requestModel.getKeyword();
        try{
            switch (keyword) {
                case "getStatus":
                    return new ExtractInfoResponseModel<>(eventDsGateway.getStatus(eventTitle));
                case "getDescription":
                    return new ExtractInfoResponseModel<>(eventDsGateway.getDescription(eventTitle));
                case "getLocation":
                    return new ExtractInfoResponseModel<>(eventDsGateway.getLocation(eventTitle));
                case "getParticipants":
                    return new ExtractInfoResponseModel<>(eventDsGateway.getParticipants(eventTitle));
                case "getOrganization":
                    return new ExtractInfoResponseModel<>(eventDsGateway.getOrganization(eventTitle));
                case "eventSearch":
                    return new ExtractInfoResponseModel<>(eventDsGateway.eventSearch(eventTitle));
            }
        } catch (SQLException | ClassNotFoundException ex){
            throw new RuntimeException(ex);
        }
        return null;
    }

    /**This method is used to obtain all kinds of organization information.
     * Use the argument *para* from responseModel to get orgName.
     * Use the argument *keyword* from responseModel to decide which info to retrieve from orgDsGateway.
     *
     * @param requestModel The request model sent to the interactor
     * @return A responseModel representing whether the event creation is successful
     */
    @Override
    public ExtractInfoResponseModel<String> extractOrgInfo(ExtractInfoRequestModel requestModel) {
        String orgName = requestModel.getPara();
        String keyword = requestModel.getKeyword();
        try {
            switch (keyword) {
                case "getPassword":
                    return new ExtractInfoResponseModel<>(orgDsGateway.getPassword(orgName));
                case "getUnpublishedEvents":
                    return new ExtractInfoResponseModel<>(orgDsGateway.getUnpublishedEvents(orgName));
                case "getPastEvents":
                    return new ExtractInfoResponseModel<>(orgDsGateway.getPastEvents(orgName));
                case "getUpcomingEvents":
                    return new ExtractInfoResponseModel<>(orgDsGateway.getUpcomingEvents(orgName));
                case "getFollowers":
                    return new ExtractInfoResponseModel<>(orgDsGateway.getFollowers(orgName));
                case "organizerSearch":
                    return new ExtractInfoResponseModel<>(orgDsGateway.organizationSearch(orgName));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    /**This method is used to obtain all kinds of participant information.
     * Use the argument *para* from responseModel to get parName.
     * Use the argument *keyword* from responseModel to decide which info to retrieve from parDsGateway.
     *
     * @param requestModel The request model sent to the interactor
     * @return A responseModel representing whether the event creation is successful
     */
    @Override
    public ExtractInfoResponseModel<String> extractParInfo(ExtractInfoRequestModel requestModel) {
        String parName = requestModel.getPara();
        String keyword = requestModel.getKeyword();
        try {
            switch (keyword) {
                case "getPassword":
                    return new ExtractInfoResponseModel<>(parDsGateway.getPassword(parName));
                case "getNotifications":
                    return new ExtractInfoResponseModel<>(parDsGateway.getNotifications(parName));
                case "getUpcomingEvents":
                    return new ExtractInfoResponseModel<>(parDsGateway.getUpcomingEvents(parName));
                case "getPastEvents":
                    return new ExtractInfoResponseModel<>(parDsGateway.getPastEvents(parName));
                case "getFollowedOrg":
                    return new ExtractInfoResponseModel<>(parDsGateway.getFollowedOrg(parName));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    /**This method is used to obtain an event's time information.
     * Use the argument *para* from responseModel to get eventTitle.
     * Use the argument *keyword* from responseModel to decide which info to retrieve from eventDsGateway.
     *
     * @param requestModel The request model sent to the interactor
     * @return A responseModel representing whether the event creation is successful
     */
    @Override
    public ExtractInfoResponseModel<Integer> extractTimeInfo(ExtractInfoRequestModel requestModel) {
        String eventName = requestModel.getPara();
        try {
            return new ExtractInfoResponseModel<>(eventDsGateway.getTime(eventName));
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}
