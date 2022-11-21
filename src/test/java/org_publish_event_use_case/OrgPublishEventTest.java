package org_publish_event_use_case;

import database.EventDsGateway;
import database.EventFileUser;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import screens.org_unpublished_event.OrgPublishEventController;
import screens.org_unpublished_event.OrgPublishEventPresenter;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrgPublishEventTest {
    EventDsGateway eventDsGateway = new EventFileUser();

    OrgPublishEventOutputBoundary orgPublishEventOutputBoundary = new OrgPublishEventPresenter();

    OrgPublishEventInputBoundary interactor = new OrgPublishEventInteractor(eventDsGateway, orgPublishEventOutputBoundary);

    OrgPublishEventController orgPublishEventController = new OrgPublishEventController(interactor);

    OrgPublishEventResponseModel responseModel;

    /**Need to create an event "A"in event file which is still unpublished
     */
    @Test
    @Order(1)
    void testOrganizationPublishEvent() {
        try {
            responseModel = orgPublishEventController.publish("A");
            System.out.println(responseModel.getMessage());
            assertEquals("Event A is published!", responseModel.getMessage());
        } catch (SQLException | ClassNotFoundException e) {
            assert(false);
        }

    }}
