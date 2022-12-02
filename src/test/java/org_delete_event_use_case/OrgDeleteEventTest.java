package org_delete_event_use_case;


import database.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Order;
import controller_presenter_view.common_controller_presenter.org_delete_event.OrgDeleteEventController;
import controller_presenter_view.common_controller_presenter.org_delete_event.OrgDeleteEventPresenter;
import org.junit.jupiter.api.TestMethodOrder;
import use_cases.org_delete_event_use_case.OrgDeleteEventInputBoundary;
import use_cases.org_delete_event_use_case.OrgDeleteEventInteractor;
import use_cases.org_delete_event_use_case.OrgDeleteEventOutputBoundary;
import use_cases.org_delete_event_use_case.OrgDeleteEventResponseModel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


/**Need to create 2 events "CSC207", "MAT137" in eventfile
 * Need to create a participant "allyson" in parfile, create an organization "UofT" in orgfile
 * Need to assign "CSC207" to "allyson" in upcoming_events_for_par
 * Need to assign "CSC207" to "UofT" in upcoming_events_for_org
 * Need to assign "MAT137" to "UofT" in unpublished_events_for_org
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrgDeleteEventTest {
    final EventDsGateway eventDsGateway = new EventFileUser();

    final OrgDsGateway orgDsGateway = new OrgFileUser();

    final ParDsGateway parDsGateway = new ParFileUser();

    final OrgDeleteEventOutputBoundary orgDeleteEventOutputBoundary = new OrgDeleteEventPresenter();

    final OrgDeleteEventInputBoundary interactor = new OrgDeleteEventInteractor(eventDsGateway,
            parDsGateway, orgDeleteEventOutputBoundary);

    final OrgDeleteEventController orgDeleteEventController = new OrgDeleteEventController(interactor);

    OrgDeleteEventResponseModel responseModel;

    @Test
    @Order(1)
    void testEventHasParticipant() {
        try {
            responseModel = orgDeleteEventController.delete("CSC207");
            System.out.println(responseModel.getMessage());
            assertEquals("Event CSC207 is deleted.", responseModel.getMessage());
            assertFalse(orgDsGateway.getUpcomingEvents("UofT").contains("CSC207"));
            assertEquals("Event CSC207 is cancelled.", parDsGateway.getNotifications("allyson").get(0));
            assertFalse(parDsGateway.getUpcomingEvents("allyson").contains("CSC207"));
        } catch (Exception e) {
            assert(false);
        }
    }

    @Test
    @Order(2)
    void testEventNoParticipant() {
        try {
            responseModel = orgDeleteEventController.delete("MAT137");
            assertEquals("Event MAT137 is deleted.", responseModel.getMessage());
            assertFalse(orgDsGateway.getUpcomingEvents("UofT").contains("MAT137"));
        } catch (Exception e) {
            assert(false);
        }
    }
}


