package controller_presenter_view.common_controller_presenter.upcoming_to_past;

import upcoming_to_past_use_case.*;

import java.sql.SQLException;

/**The controller will be called by:
 * 1. OrgHomeActionListener When the organization clicks to the OrgUpcomingEventPage or OrgPastEventPage from OrgHomePage
 * 2. LoginPage             When a participant user clicks the "Login" button
 * The usage of this controller is closely connected to NotifyEvent.
 */
public class UpcomingToPastController {
    UpcomingToPastInputBoundary interactor;

    public UpcomingToPastController(UpcomingToPastInputBoundary potential_interactor) {
        this.interactor = potential_interactor;
    }

    public UpcomingToPastResponseModel convertToPast(String userType, String username) throws SQLException, ClassNotFoundException {
        UpcomingToPastRequestModel requestModel = new UpcomingToPastRequestModel(userType, username);
        return interactor.convertToPast(requestModel);
    }
}
