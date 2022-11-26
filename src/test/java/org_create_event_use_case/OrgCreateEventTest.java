package org_create_event_use_case;

import database.*;
import org.junit.jupiter.api.Test;
import screens.org_unpublished_event.OrgCreateEventController;
import screens.org_unpublished_event.OrgCreateEventPresenter;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class OrgCreateEventTest {
    EventDsGateway eventDsGateway = new EventFileUser();
    OrgDsGateway orgDsGateway = new OrgFileUser();
    OrgCreateEventOutputBoundary orgCreateEventPresenter = new OrgCreateEventPresenter();
    OrgCreateEventInputBoundary orgCreateEventInteractor = new OrgCreateEventInteractor(eventDsGateway, orgDsGateway,
            orgCreateEventPresenter);
    OrgCreateEventController orgCreateEventController = new OrgCreateEventController(orgCreateEventInteractor);
    OrgCreateEventResponseModel orgCreateEventResponseModel;

    @Test
    void testPrepareSuccessViewOrgCreateEvent() {
        try {
            orgCreateEventResponseModel = orgCreateEventController.create("University of Toronto",
                    "CSC207H1", "Software Design", "Toronto", "2345", "9",
                    "13", "14", "0");
            assertEquals(orgCreateEventResponseModel.getTitle(), "CSC207H1");
        } catch (Exception e) {
            assert(false);
        }
    }

    @Test
    void testPrepareFailViewOrgCreateEvent() {
        try {
            orgCreateEventResponseModel = orgCreateEventController.create("University of Toronto",
                    "CSC207H1", "Software Design", "Toronto", "1098", "9",
                    "13", "14", "0");
            assert(false);
        } catch (RuntimeException ShowMessageView) {
            assert(true);
        }
    }
}
