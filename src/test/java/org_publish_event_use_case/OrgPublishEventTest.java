package org_publish_event_use_case;

import database.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org_publish_event_use_case.OrgPublishEventOutputBoundary;
import org_publish_event_use_case.OrgPublishEventInputBoundary;
import org_publish_event_use_case.OrgPublishEventInteractor;
import org_publish_event_use_case.OrgPublishEventResponseModel;
import screens.org_unpublished_event.OrgPublishEventController;
import screens.org_unpublished_event.OrgPublishEventPresenter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrgPublishEventTest {
    EventDsGateway eventDsGateway = new EventFileUser();

    OrgPublishEventOutputBoundary orgPublishEventOutputBoundary = new OrgPublishEventPresenter();

    OrgPublishEventInputBoundary interactor = new OrgPublishEventInteractor(eventDsGateway, orgPublishEventOutputBoundary);

    OrgPublishEventController orgPublishEventController = new OrgPublishEventController(interactor);

    OrgPublishEventResponseModel responseModel;

    @Test
    @Order(1)
    void testOrganizationPublishEvent() {
        try {
            responseModel = orgPublishEventController.publish("CSC207");
            assertEquals("Event CSC207 is published!", responseModel.getMessage());
        }
        catch (Exception e) {
            assert(false);
        }}
}
