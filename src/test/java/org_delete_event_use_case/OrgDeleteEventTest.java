package org_delete_event_use_case;


import database.*;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Order;
import screens.org_upcoming_event.OrgDeleteEventController;
import screens.org_upcoming_event.OrgDeleteEventPresenter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrgDeleteEventTest {
    EventDsGateway eventDsGateway = new EventFileUser();

    OrgDsGateway orgDsGateway = new OrgFileUser();

    ParDsGateway parDsGateway = new ParFileUser();

    OrgDeleteEventOutputBoundary orgDeleteEventOutputBoundary = new OrgDeleteEventPresenter();

    OrgDeleteEventInputBoundary interactor = new OrgDeleteEventInteractor(eventDsGateway, orgDsGateway,
            parDsGateway, orgDeleteEventOutputBoundary);

    OrgDeleteEventController orgDeleteEventController = new OrgDeleteEventController(interactor);

    OrgDeleteEventResponseModel responseModel;
    @Test
    @Order(1)
    void testEventHasParticipant() {
        try {
            responseModel = orgDeleteEventController.delete("CSC207");
            assertEquals("Event CSC207 is deleted.", responseModel.getMessage());
            assertEquals("Event CSC207 is cancelled.", parDsGateway.getNotifications("allyson").get(0));
        } catch (Exception e) {
            assert(false);
        }
    }
    /*
    @Test
    @Order(1)
    void testEventNoParticipant() {
        try {
            responseModel = orgNotifyEventController.delete("ACT240");
            assert(false);
        } catch (Exception e) {
            assertEquals("No participant joined ACT240.", e.getMessage());
        }
    }

     */
}


