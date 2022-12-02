package use_cases.org_publish_event;

import database.EventDsGateway;
import database.OrgDsGateway;
import database.ParDsGateway;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class OrgPublishEventInteractor implements OrgPublishEventInputBoundary {
    final EventDsGateway eventDsGateway;
    final OrgDsGateway orgDsGateway;
    final ParDsGateway parDsGateway;
    final OrgPublishEventOutputBoundary orgPublishEventOutputBoundary;

    /**Constructor
     *
     * @param eventDsGateway The database gateway of the events
     * @param orgPublishEventOutputBoundary The OutputBoundary used to show success of publishing
     */
    public OrgPublishEventInteractor(EventDsGateway eventDsGateway, OrgDsGateway orgDsGateway, ParDsGateway parDsGateway, OrgPublishEventOutputBoundary orgPublishEventOutputBoundary) {
        this.eventDsGateway = eventDsGateway;
        this.orgDsGateway = orgDsGateway;
        this.parDsGateway = parDsGateway;
        this.orgPublishEventOutputBoundary = orgPublishEventOutputBoundary;
    }

    /**Use the provided method in eventDsGateway to publish an event.
     *
     * @param requestModel The request model sent to the interactor
     * @return A responseModel representing whether the event publishing is successful
     */
    @Override
    public OrgPublishEventResponseModel publish(OrgPublishEventRequestModel requestModel) throws ClassNotFoundException {
        String eventTitle = requestModel.getEventTitle();
        ArrayList<Integer> times = eventDsGateway.getTime(eventTitle);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime time = LocalDateTime.of(times.get(0), times.get(1), times.get(2), times.get(3), times.get(4));

        //checks if the time is set in the future.
        if (time.isBefore(now)){
            return orgPublishEventOutputBoundary.prepareFailView("Time must be in future, please edit the time.");
        }

        //move the event to a different folder in database
        eventDsGateway.unPublishedToUpcoming(eventTitle);

        String orgUsername = requestModel.getOrgUsername();
        ArrayList<String> followers = orgDsGateway.getFollowers(orgUsername);
        //Send notification to followers
        if (!followers.isEmpty()){
            for (String follower : followers){
                parDsGateway.addNotification(follower, orgUsername + " published a new event!");
            }
            OrgPublishEventResponseModel orgPublishEventResponseModel = new OrgPublishEventResponseModel(eventTitle, true);
            return orgPublishEventOutputBoundary.prepareSuccessView(orgPublishEventResponseModel);
        }
        else {
            OrgPublishEventResponseModel orgPublishEventResponseModel = new OrgPublishEventResponseModel(eventTitle, false);
            return orgPublishEventOutputBoundary.prepareSuccessView(orgPublishEventResponseModel);
        }
    }
}
