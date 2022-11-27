package org_edit_event_use_case;

import database.EventDsGateway;
import database.EventFileUser;
import database.OrgDsGateway;
import database.OrgFileUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import controller_presenter_view.screens.org_unpublished_event.org_edit_event.OrgEditEventController;
import controller_presenter_view.screens.org_unpublished_event.org_edit_event.OrgEditEventPresenter;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**Need to create an event called "Edit" in eventfile, can choose to leave other attributes null.
 */
public class OrgEditEventTest {
    EventDsGateway eventDsGateway = new EventFileUser();
    OrgDsGateway orgDsGateway = new OrgFileUser();
    OrgEditEventOutputBoundary presenter = new OrgEditEventPresenter();
    OrgEditEventInputBoundary interactor = new OrgEditEventInteractor(eventDsGateway, orgDsGateway, presenter);
    OrgEditEventController controller = new OrgEditEventController(interactor);
    OrgEditEventResponseModel responseModel;


    @Test
    @Order(1)
    public void test_PrepareFailureView_entries_empty() {
        try {
            responseModel = controller.edit("Edit", "", "", "4", "21", "", "11", "");
            assert (false);
        } catch (Exception e) {
            assertEquals("Entries cannot be empty.", e.getMessage());
        }
    }

    @Test
    @Order(2)
    void testPrepareFailViewDescriptionTooLong() {
        try {
            responseModel = controller.edit("Edit","An introduction to software design and development concepts, methods, and tools using a statically-typed object-oriented programming language such as Java. Topics from: version control, unit testing, refactoring, object-oriented design and development, design patterns, advanced IDE usage, regular expressions, and reflection. Representation of floating-point numbers and introduction to numerical computation.",
                    "Zoom", "2024", "5", "2", "9", "9");
            assert(false);
        } catch (Exception e) {
            assertEquals("Description should be no longer than 200 characters.", e.getMessage());
        }
    }

    @Test
    @Order(3)
    void testPrepareFailViewLocationTooLong() {
        try {
            responseModel = controller.edit("Edit", "SS", "Toronto ssssssssssssssssssssssssssssssssssssssssssssss ssssssssssssssssssssssssssssssssssssssssssssss",
                    "2024", "5", "2", "9", "9");
            assert(false);
        } catch (Exception e) {
            assertEquals("Location should be no longer than 50 characters.", e.getMessage());
        }
    }

    @Test
    @Order(4)
    public void test_PrepareFailureView_not_integer() {
        try {
            responseModel = controller.edit("Edit", "HH", "Zoom", "aja", "4", "2", "9", "9");
            assert (false);
        } catch (Exception e) {
            assertEquals("Time entry/ies is/are not integer.", e.getMessage());

        }
    }

    @Test
    @Order(5)
    public void test_PrepareFailureView_wrong_year() {
        try {
            responseModel = controller.edit("Edit", "HH", "Zoom", "200", "4", "2", "9", "9");
            assert (false);
        } catch (Exception e) {
            assertEquals("Year is not 4 digits.", e.getMessage());
        }
    }

    @Test
    @Order(6)
    public void test_PrepareFailureView_wrong_month() {
        try {
            responseModel = controller.edit("Edit", "HH", "Zoom", "2024", "13", "2", "9", "9");
            assert (false);
        } catch (Exception e) {
            assertEquals("Month is not within 1 to 12.", e.getMessage());
        }
    }

    @Test
    @Order(7)
    public void test_PrepareFailureView_wrong_day() {
        try {
            responseModel = controller.edit("Edit", "HH", "Zoom", "2024", "4", "40", "9", "9");
            assert (false);
        } catch (Exception e) {
            assertEquals("Day is not within 1 to 31.", e.getMessage());
        }
    }

    @Test
    @Order(8)
    public void test_PrepareFailureView_wrong_hour() {
        try {
            responseModel = controller.edit("Edit", "HH", "Zoom", "2024", "4", "2", "30", "9");
            assert (false);
        } catch (Exception e) {
            assertEquals("Hour is not within 0 to 24.", e.getMessage());
        }
    }

    @Test
    @Order(9)
    public void test_PrepareFailureView_wrong_minite() {
        try {
            responseModel = controller.edit("Edit", "HH", "Zoom", "2024", "4", "2", "9", "70");
            assert (false);
        } catch (Exception e) {
            assertEquals("Minute is not within 0 to 60.", e.getMessage());


        }
    }

    @Test
    @Order(10)
    public void test_PrepareFailureView_future_time() {
        try {
            responseModel = controller.edit("Edit", "HH", "Zoom", "2004", "4", "2", "9", "9");
            assert (false);
        } catch (Exception e) {
            assertEquals("Time must be in future.", e.getMessage());

        }
    }



    @Test
    @Order(11)
    public void test_PrepareSuccessView()  {
        try{
            responseModel = controller.edit("Edit", "SS", "Zoom", "2024", "5", "2", "9", "9");
            assertEquals("Event Edit is successfully edited!", responseModel.getMessage());
            controller.edit("Edit", "GG", "Zoom", "2024", "5", "2", "9", "9");
        } catch (Exception e) {
            assert(false);
        }
    }
}
