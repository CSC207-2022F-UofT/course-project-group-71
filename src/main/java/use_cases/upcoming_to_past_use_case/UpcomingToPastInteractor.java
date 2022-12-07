package use_cases.upcoming_to_past_use_case;

import database.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UpcomingToPastInteractor implements UpcomingToPastInputBoundary {

    final ParDsGateway parDsGateway;
    final OrgDsGateway orgDsGateway;
    final EventDsGateway eventDsGateway;
    final UpcomingToPastOutputBoundary upcomingToPastOutputBoundary;

    /**Constructor
     *
     * @param parDsGateway              The database gateway of the participants
     * @param orgDsGateway              The database gateway of the organizations
     * @param eventDsGateway            The database gateway of the events
     * @param upcomingToPastOutputBoundary   The presenter used to change event's status from Upcoming to Past
     */
    public UpcomingToPastInteractor(ParDsGateway parDsGateway, OrgDsGateway orgDsGateway,
                                    EventDsGateway eventDsGateway, UpcomingToPastOutputBoundary upcomingToPastOutputBoundary){
        this.parDsGateway = parDsGateway;
        this.orgDsGateway = orgDsGateway;
        this.eventDsGateway = eventDsGateway;
        this.upcomingToPastOutputBoundary = upcomingToPastOutputBoundary;
    }

    /**Converts an upcoming event into a past event if its time is in the past.
     * Introduced package LocalDateTime to do the comparison.
     * This method is used in three cases: 1. When a participant logs in
     *                                     2. When an organization clicks upcoming event page
     *                                     3. When an organization clicks past event page
     *
     * @param requestModel The request model sent to the interactor
     * @return A responseModel representing whether the user creation is successful
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    @Override
    public UpcomingToPastResponseModel convertToPast(UpcomingToPastRequestModel requestModel) throws ClassNotFoundException {

        String username = requestModel.getUsername();

        ArrayList<String> eventsToPast = new ArrayList<>();
        ArrayList<String> upcomingEvents;

        //get all upcoming events of the user
        if (requestModel.getUserType().equals("P")) { upcomingEvents = parDsGateway.getUpcomingEvents(username); }
        else { upcomingEvents = orgDsGateway.getUpcomingEvents(username); }

        for (String event : upcomingEvents) {
            ArrayList<Integer> times = eventDsGateway.getTime(event);

            //get current time and event's time
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime time = LocalDateTime.of(times.get(0), times.get(1), times.get(2), times.get(3), times.get(4));

            //if the event's time is in the past
            if (time.isBefore(now)){
                eventDsGateway.upcomingToPast(event);
                eventsToPast.add(event);
            }
        }

        UpcomingToPastResponseModel upcomingToPastResponseModel = new UpcomingToPastResponseModel(eventsToPast);
        return upcomingToPastOutputBoundary.prepareSuccessView(upcomingToPastResponseModel);
    }
}
