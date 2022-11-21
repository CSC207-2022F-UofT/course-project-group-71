package screens.org_unpublished_event;

import org_edit_event_use_case.OrgEditEventInputBoundary;
import org_edit_event_use_case.OrgEditEventRequestModel;
import org_edit_event_use_case.OrgEditEventResponseModel;

import java.sql.SQLException;

public class OrgEditEventController {

    final OrgEditEventInputBoundary userInput;

    public OrgEditEventController(OrgEditEventInputBoundary userInput) {
        this.userInput = userInput;
    }

    public OrgEditEventResponseModel edit(String title,
                                              String description,
                                              String location,
                                              String year,
                                              String month,
                                              String day,
                                              String hour,
                                              String minute) throws SQLException, ClassNotFoundException {
        //Prepare a request model with given information
        OrgEditEventRequestModel requestModel = new OrgEditEventRequestModel(
                title, description, location, year, month, day, hour, minute);
        System.out.println("3");
        //Get the response model from the interactor
        OrgEditEventResponseModel responseModel = userInput.edit(requestModel);
        System.out.println("5");
        return responseModel;
    }

}
