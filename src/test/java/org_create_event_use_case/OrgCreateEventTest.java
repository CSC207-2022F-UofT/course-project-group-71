package org_create_event_use_case;

import database.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import controller_presenter_view.screens.org_unpublished_event.org_create_event.OrgCreateEventController;
import controller_presenter_view.screens.org_unpublished_event.org_create_event.OrgCreateEventPresenter;
import org.junit.jupiter.api.TestMethodOrder;
import use_cases.org_create_event_use_case.OrgCreateEventInputBoundary;
import use_cases.org_create_event_use_case.OrgCreateEventInteractor;
import use_cases.org_create_event_use_case.OrgCreateEventOutputBoundary;
import use_cases.org_create_event_use_case.OrgCreateEventResponseModel;

import static org.junit.jupiter.api.Assertions.*;

/**Need to create an organization called "UofT" in orgfile
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrgCreateEventTest {
    final EventDsGateway eventDsGateway = new EventFileUser();
    final OrgDsGateway orgDsGateway = new OrgFileUser();
    final OrgCreateEventOutputBoundary orgCreateEventPresenter = new OrgCreateEventPresenter();
    final OrgCreateEventInputBoundary orgCreateEventInteractor = new OrgCreateEventInteractor(eventDsGateway, orgDsGateway,
            orgCreateEventPresenter);
    final OrgCreateEventController orgCreateEventController = new OrgCreateEventController(orgCreateEventInteractor);
    OrgCreateEventResponseModel orgCreateEventResponseModel;

    @Test
    @Order(1)
    void testPrepareSuccessViewOrgCreateEvent() {
        try {
            orgCreateEventResponseModel = orgCreateEventController.create("UofT",
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
            orgCreateEventResponseModel = orgCreateEventController.create("UofT",
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
            orgCreateEventResponseModel = orgCreateEventController.create("UofT",
                    "CSC207H1", "Software Design", "Toronto", "2345", "9",
                    "13", "14", "0");
            assert(false);
        } catch (Exception e) {
            assertEquals("Title already exists.", e.getMessage());
        }
    }

    @Test
    @Order(4)
    void testPrepareFailViewTitleTooLong() {
        try {
            orgCreateEventResponseModel = orgCreateEventController.create("UofT",
                    "CSC207H5111111111111111", "Software Design", "Toronto", "2345", "9",
                    "13", "1.4", "0");
            assert(false);
        } catch (Exception e) {
            assertEquals("Title should be no longer than 20 characters.", e.getMessage());
        }
    }

    @Test
    @Order(5)
    void testPrepareFailViewDescriptionTooLong() {
        try {
            orgCreateEventResponseModel = orgCreateEventController.create("UofT",
                    "CSC207H5", "An introduction to software design and development concepts, methods, and tools using a statically-typed object-oriented programming language such as Java. Topics from: version control, unit testing, refactoring, object-oriented design and development, design patterns, advanced IDE usage, regular expressions, and reflection. Representation of floating-point numbers and introduction to numerical computation.",
                    "Toronto", "2345", "9", "13", "1.4", "0");
            assert(false);
        } catch (Exception e) {
            assertEquals("Description should be no longer than 200 characters.", e.getMessage());
        }
    }

    @Test
    @Order(6)
    void testPrepareFailViewLocationTooLong() {
        try {
            orgCreateEventResponseModel = orgCreateEventController.create("UofT",
                    "CSC207H5", "Software Design", "Toronto 111111111111111111111111111111 111111111111111111111111111111111111111",
                    "2345", "9", "13", "1.4", "0");
            assert(false);
        } catch (Exception e) {
            assertEquals("Location should be no longer than 50 characters.", e.getMessage());
        }
    }

    @Test
    @Order(7)
    void testPrepareFailViewTimeNotInteger() {
        try {
            orgCreateEventResponseModel = orgCreateEventController.create("UofT",
                    "CSC207H5", "Software Design", "Toronto", "2345", "9",
                    "13", "1.4", "0");
            assert(false);
        } catch (Exception e) {
            assertEquals("Time entry/ies is/are not integer.", e.getMessage());
        }
    }

    @Test
    @Order(8)
    void testPrepareFailViewYearWrong() {
        try {
            orgCreateEventResponseModel = orgCreateEventController.create("UofT",
                    "CSC207H5", "Software Design", "Toronto", "234", "9",
                    "13", "14", "0");
            assert(false);
        } catch (Exception e) {
            assertEquals("Year is not 4 digits.", e.getMessage());
        }
    }

    @Test
    @Order(9)
    void testPrepareFailViewMonthWrong() {
        try {
            orgCreateEventResponseModel = orgCreateEventController.create("UofT",
                    "CSC207H5", "Software Design", "Toronto", "2345", "22",
                    "13", "14", "0");
            assert(false);
        } catch (Exception e) {
            assertEquals("Month is not within 1 to 12.", e.getMessage());
        }
    }

    @Test
    @Order(10)
    void testPrepareFailViewDayWrong() {
        try {
            orgCreateEventResponseModel = orgCreateEventController.create("UofT",
                    "CSC207H5", "Software Design", "Toronto", "2345", "9",
                    "-1", "14", "0");
            assert(false);
        } catch (Exception e) {
            assertEquals("Day is not within 1 to 31.", e.getMessage());
        }
    }

    @Test
    @Order(11)
    void testPrepareFailViewHourWrong() {
        try {
            orgCreateEventResponseModel = orgCreateEventController.create("UofT",
                    "CSC207H5", "Software Design", "Toronto", "2345", "9",
                    "13", "24", "0");
            assert(false);
        } catch (Exception e) {
            assertEquals("Hour is not within 0 to 23.", e.getMessage());
        }
    }

    @Test
    @Order(12)
    void testPrepareFailViewMinuteWrong() {
        try {
            orgCreateEventResponseModel = orgCreateEventController.create("UofT",
                    "CSC207H5", "Software Design", "Toronto", "2345", "9",
                    "13", "14", "60");
            assert(false);
        } catch (Exception e) {
            assertEquals("Minute is not within 0 to 59.", e.getMessage());
        }
    }

    @Test
    @Order(13)
    void testPrepareFailViewTimeIsPast() {
        try {
            orgCreateEventResponseModel = orgCreateEventController.create("UofT",
                    "CSC207H5", "Software Design", "Toronto", "1345", "9",
                    "13", "14", "0");
            assert(false);
        } catch (Exception e) {
            assertEquals("Time must be in future.", e.getMessage());
        }
    }
}
