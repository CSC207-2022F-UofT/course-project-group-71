package screens.upcoming_to_past;

import upcoming_to_past_use_case.*;

import java.sql.SQLException;

public class UpcomingToPastController {
    final UpcomingToPastInputBoundary interactor;

    /**This is constructor method of The UpcomingToPastController that takes an input interactor and stored in.
     *
     * @param potential_interactor The interactor sent to the controller
     */
    public UpcomingToPastController(UpcomingToPastInputBoundary potential_interactor) {
        this.interactor = potential_interactor;

    }

    /**The method is used to create a user account, it will call requestmodel and interactor and sent
     * them information for user creation.
     *
     * @param userType The user type of the user
     * @param username The username of the user
     * @return The response model showing whether creation is successful
     */
    public UpcomingToPastResponseModel convertToPast(String userType, String username) throws SQLException, ClassNotFoundException {
        UpcomingToPastRequestModel requestModel = new UpcomingToPastRequestModel(userType, username);

        return interactor.convertToPast(requestModel);
    }
}
