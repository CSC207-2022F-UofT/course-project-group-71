package org_create_event_use_case;

import database.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import screens.org_unpublished_event.OrgCreateEventController;
import screens.org_unpublished_event.OrgCreateEventPresenter;

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
    @Order(1)
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
    @Order(2)
    void testPrepareFailViewEmptyEntries() {
        try {
            orgCreateEventResponseModel = orgCreateEventController.create("University of Toronto",
                    "CSC207H1", "Software Design", "Toronto", "", "9",
                    "13", "14", "0");
            assert(false);
        } catch (Exception e) {
            assertEquals("Entries cannot be empty.", e.getMessage());
        }
    }

    @Test
    @Order(3)
    void testPrepareFailViewRepeatingTitle() {
        try {
            orgCreateEventResponseModel = orgCreateEventController.create("University of Toronto",
                    "CSC207H1", "Software Design", "Toronto", "2345", "9",
                    "13", "14", "0");
            assert(false);
        } catch (Exception e) {
            assertEquals("Title already exists.", e.getMessage());
        }
    }

    @Test
    @Order(4)
    void testPrepareFailViewOrgCreateEvent() {
        try {
            orgCreateEventResponseModel = orgCreateEventController.create("University of Toronto",
                    "CSC207H1", "Software Design", "Toronto", "2345", "9",
                    "13", "1.4", "0");
            assert(false);
        } catch (Exception e) {
            assertEquals("Time entry/ies is/are not integer.", e.getMessage());
        }
    }

    @Test
    @Order(5)
    void testPrepareFailViewYearWrong() {
        try {
            orgCreateEventResponseModel = orgCreateEventController.create("University of Toronto",
                    "CSC207H5", "Software Design", "Toronto", "234", "9",
                    "13", "14", "0");
            assert(false);
        } catch (Exception e) {
            assertEquals("Year is not 4 digits.", e.getMessage());
        }
    }

    @Test
    @Order(6)
    void testPrepareFailViewMonthWrong() {
        try {
            orgCreateEventResponseModel = orgCreateEventController.create("University of Toronto",
                    "CSC207H5", "Software Design", "Toronto", "2345", "22",
                    "13", "14", "0");
            assert(false);
        } catch (Exception e) {
            assertEquals("Month is not within 1 to 12.", e.getMessage());
        }
    }

    @Test
    @Order(7)
    void testPrepareFailViewDayWrong() {
        try {
            orgCreateEventResponseModel = orgCreateEventController.create("University of Toronto",
                    "CSC207H5", "Software Design", "Toronto", "2345", "9",
                    "-1", "14", "0");
            assert(false);
        } catch (Exception e) {
            assertEquals("Day is not within 1 to 31.", e.getMessage());
        }
    }

    @Test
    @Order(8)
    void testPrepareFailViewHourWrong() {
        try {
            orgCreateEventResponseModel = orgCreateEventController.create("University of Toronto",
                    "CSC207H5", "Software Design", "Toronto", "2345", "9",
                    "13", "24", "0");
            assert(false);
        } catch (Exception e) {
            assertEquals("Hour is not within 0 to 23.", e.getMessage());
        }
    }

    @Test
    @Order(9)
    void testPrepareFailViewMinuteWrong() {
        try {
            orgCreateEventResponseModel = orgCreateEventController.create("University of Toronto",
                    "CSC207H5", "Software Design", "Toronto", "2345", "9",
                    "13", "24", "60");
            assert(false);
        } catch (Exception e) {
            assertEquals("Minute is not within 0 to 59.", e.getMessage());
        }
    }

    @Test
    @Order(9)
    void testPrepareFailViewTimeIsPast() {
        try {
            orgCreateEventResponseModel = orgCreateEventController.create("University of Toronto",
                    "CSC207H5", "Software Design", "Toronto", "1345", "9",
                    "13", "14", "0");
            assert(false);
        } catch (Exception e) {
            assertEquals("Time must be in future.", e.getMessage());
        }
    }
}
