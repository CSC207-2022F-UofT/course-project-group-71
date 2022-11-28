package org_publish_event_use_case;

import database.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import controller_presenter_view.screens.org_unpublished_event.org_publish_event.OrgPublishEventController;
import controller_presenter_view.screens.org_unpublished_event.org_publish_event.OrgPublishEventPresenter;
import use_cases.org_publish_event_use_case.OrgPublishEventInputBoundary;
import use_cases.org_publish_event_use_case.OrgPublishEventInteractor;
import use_cases.org_publish_event_use_case.OrgPublishEventOutputBoundary;
import use_cases.org_publish_event_use_case.OrgPublishEventResponseModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**Need to create an organization named "UofT", "UBC" in orgfile, create a participant named "allyson" in parfile
 * Need to create an event "A", "B" in eventfile, whose time is in the future
 * Need to connect "A" with "UBC", "B" with "UofT" in unpublished_events_for_org
 * Assign "allyson" as a follower of "UofT" in follow_org_par
 * Need to create an event "C" in eventfile, whose time is in the past
 * Need to connect "C" with "UofT" in the unpublished_events_for_org
 */
public class OrgPublishEventTest {
    EventDsGateway eventDsGateway = new EventFileUser();
    OrgDsGateway orgDsGateway = new OrgFileUser();
    ParDsGateway parDsGateway = new ParFileUser();
    OrgPublishEventOutputBoundary orgPublishEventOutputBoundary = new OrgPublishEventPresenter();
    OrgPublishEventInputBoundary interactor = new OrgPublishEventInteractor(eventDsGateway, orgDsGateway, parDsGateway, orgPublishEventOutputBoundary);
    OrgPublishEventController orgPublishEventController = new OrgPublishEventController(interactor);
    OrgPublishEventResponseModel responseModel;

    @Test
    @Order(1)
    void testOrgPublishEventFailByTime() {
        try {
            responseModel = orgPublishEventController.publish("A", "UofT");
            assert(false);
        } catch (Exception e) {
            assertEquals("Time must be in future, please edit the time.", e.getMessage());
        }
    }

    @Test
    @Order(2)
    void testOrgPublishEventSuccessHasFollower() {
        try {
            responseModel = orgPublishEventController.publish("B", "UofT");
            assertEquals("Event B is published! Your followers are notified.", responseModel.getMessage());
        } catch (Exception e) {
            assert(false);
        }
    }

    @Test
    @Order(3)
    void testOrgPublishEventSuccessNoFollower() {
        try {
            responseModel = orgPublishEventController.publish("C", "UBC");
            assertEquals("Event C is published!", responseModel.getMessage());
        } catch (Exception e) {
            assert(false);
        }
    }





}
