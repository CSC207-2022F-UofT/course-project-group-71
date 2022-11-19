package upcoming_to_past_use_case;

import database.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class UpcomingToPastInteractor implements UpcomingToPastInputBoundary {

    final ParDsGateway parDsGateway;
    final OrgDsGateway orgDsGateway;
    final EventDsGateway eventDsGateway;

    final UpcomingToPastPresenter upcomingToPastPresenter;

    /**
     * This is the construct method of UserRegisterInteractor.
     * It takes DsGateways and Presenter as input to store as instances.
     *
     * @param parDsGateway              The database gateway of the participants
     * @param orgDsGateway              The database gateway of the organizations
     * @param eventDsGateway            The database gateway of the events
     * @param upcomingToPastPresenter   The presenter used to change event's status from Upcoming to Past
     */
    public UpcomingToPastInteractor(ParDsGateway parDsGateway, OrgDsGateway orgDsGateway,
                                    EventDsGateway eventDsGateway, UpcomingToPastPresenter upcomingToPastPresenter){
        this.parDsGateway = parDsGateway;
        this.orgDsGateway = orgDsGateway;
        this.eventDsGateway = eventDsGateway;
        this.upcomingToPastPresenter = upcomingToPastPresenter;

    }

    @Override
    public UpcomingToPastResponseModel convertToPast(UpcomingToPastRequestModel requestModel) throws SQLException, ClassNotFoundException {

        String username = requestModel.getUsername();

        ArrayList<String> eventsToPast = new ArrayList<>();

        if (requestModel.getUserType().equals("P")) {

            ArrayList<String> upcomingEvents = parDsGateway.getUpcomingEvents(username);

            for (String event : upcomingEvents) {
                ArrayList<Integer> times = eventDsGateway.getTime(event);
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime time = LocalDateTime.of(times.get(0), times.get(1), times.get(2), times.get(3),
                        times.get(4));
                if (time.isBefore(now)){
                    eventDsGateway.upcomingToPast(event);
                    eventsToPast.add(event);
                }
            }
        }
        else {

            ArrayList<String> upcomingEvents = orgDsGateway.getUpcomingEvents(username);

            for (String event : upcomingEvents) {
                ArrayList<Integer> times = eventDsGateway.getTime(event);
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime time = LocalDateTime.of(times.get(0), times.get(1), times.get(2), times.get(3),
                        times.get(4));
                if (time.isBefore(now)){
                    eventDsGateway.upcomingToPast(event);
                    eventsToPast.add(event);
                }
            }
        }
        UpcomingToPastResponseModel upcomingToPastResponseModel = new UpcomingToPastResponseModel(eventsToPast);

        return upcomingToPastPresenter.prepareSuccessView(upcomingToPastResponseModel);
    }
}
