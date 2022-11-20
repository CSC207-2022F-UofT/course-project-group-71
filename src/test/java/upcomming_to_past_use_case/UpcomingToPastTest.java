package upcomming_to_past_use_case;

import database.*;
import screens.upcoming_to_past.UpcomingToPastPresenter;
import upcoming_to_past_use_case.UpcomingToPastInputBoundary;
import upcoming_to_past_use_case.UpcomingToPastInteractor;
import upcoming_to_past_use_case.UpcomingToPastOutputBoundary;

public class UpcomingToPastTest {

    ParDsGateway parDsGateway = new ParFileUser();

    EventDsGateway eventDsGateway = new EventFileUser();

    OrgDsGateway orgDsGateway = new OrgFileUser();

    UpcomingToPastOutputBoundary presenter = new UpcomingToPastPresenter();

    UpcomingToPastInputBoundary interactor = new UpcomingToPastInteractor(parDsGateway, orgDsGateway, eventDsGateway, presenter);


}
