package org_publish_event_use_case;

import controller_presenter_view.screens.org_unpublished_event.org_publish_event.*;
import database.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import use_cases.org_publish_event_use_case.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**Need to create an event called "A" in eventfile, set the time in the past
 * Need to create events "B" and "C" in eventfile, set the time in the future
 * Need to create an organization called "UofT", "UBC" in orgfile
 * Need to create a participant in parfile
 * Need to link "UofT" and the participant in follow_org_par
 * Need to link "UofT" with "A" and "B" in unpublished_events_for_org
 * Need to link "UBC" with "C" in unpublished_events_for_org
 */
public class OrgPublishEventTest {
    final EventDsGateway eventDsGateway = new EventFileUser();
    final OrgDsGateway orgDsGateway = new OrgFileUser();
    final ParDsGateway parDsGateway = new ParFileUser();
    final OrgPublishEventOutputBoundary presenter = new OrgPublishEventPresenter();
    final OrgPublishEventInputBoundary interactor = new OrgPublishEventInteractor(eventDsGateway, orgDsGateway, parDsGateway, presenter);
    final OrgPublishEventController controller = new OrgPublishEventController(interactor);
    OrgPublishEventResponseModel responseModel;

    @Test
    @Order(1)
    public void TestPrepareFailureViewPastTime() {
        try {
            responseModel = controller.publish("A", "UofT");
            assert (false);
        } catch (Exception e) {
            assertEquals("Time must be in future, please edit the time.", e.getMessage());
        }
    }

    @Test
    @Order(2)
    public void TestPrepareSuccessViewHasFollower() {
        try {
            responseModel = controller.publish("B", "UofT");
            assertEquals("Event B is published! Your followers are notified.", responseModel.getMessage());
        } catch (Exception e) {
            assert (false);
        }
    }

    @Test
    @Order(3)
    public void TestPrepareSuccessViewNoFollower() {
        try {
            responseModel = controller.publish("C", "UBC");
            System.out.println(responseModel.getMessage());
            assertEquals("Event C is published!", responseModel.getMessage());
        } catch (Exception e) {
            assert (false);
        }
    }
}
