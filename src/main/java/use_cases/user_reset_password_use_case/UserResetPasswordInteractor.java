package use_cases.user_reset_password_use_case;

import database.OrgDsGateway;
import database.ParDsGateway;

public class UserResetPasswordInteractor implements UserResetPasswordInputBoundary {

    final UserResetPasswordOutputBoundary userResetPasswordOutputBoundary;
    final OrgDsGateway orgDsGateway;
    final ParDsGateway parDsGateway;

    /**
     * Constructor
     *
     * @param userResetPasswordOutputBoundary The presenter used to show success or not of the reset
     * @param orgDsGateway                    The database gateway of the organizations
     * @param parDsGateway                    The database gateway of the participants.
     */
    public UserResetPasswordInteractor(UserResetPasswordOutputBoundary userResetPasswordOutputBoundary, OrgDsGateway orgDsGateway, ParDsGateway parDsGateway) {
        this.userResetPasswordOutputBoundary = userResetPasswordOutputBoundary;
        this.orgDsGateway = orgDsGateway;
        this.parDsGateway = parDsGateway;
    }

    /**
     * Do checks to user inputs, if fail give hints, if pass change the password.
     *
     * @param requestModel The request model sent to the input boundary
     * @return A responseModel representing whether the user resetPassword is successful.
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public UserResetPasswordResponseModel resetPassword(UserResetPasswordRequestModel requestModel) throws ClassNotFoundException {
        if (requestModel.isWhether_org()) {
            //Organization
            //Check if the old password of organization is entered correctly
            if (!requestModel.getPassword().equals(orgDsGateway.getPassword(requestModel.getUsername()))) {
                return userResetPasswordOutputBoundary.prepareFailureView("Old password is not correct.");
            }

            if (requestModel.getNewPassword().isEmpty()) {
                return userResetPasswordOutputBoundary.prepareFailureView("Password cannot be empty.");
            }

            if (requestModel.getPassword().length() > 20) {
                return userResetPasswordOutputBoundary.prepareFailureView("Password should be no longer than 20 characters.");
            }

            if (requestModel.getNewPassword().equals(requestModel.getPassword())) {
                return userResetPasswordOutputBoundary.prepareFailureView("New password cannot be the same as old one.");
            }

            //Check if the new password and the retyped new password of organizer are same
            if (!requestModel.getNewPassword().equals(requestModel.getReNewPassword())) {
                return userResetPasswordOutputBoundary.prepareFailureView("New Passwords do not match.");

            }

            //If the above two error don't occur, show the successful view
            orgDsGateway.setPassword(requestModel.getUsername(), requestModel.getNewPassword());
            UserResetPasswordResponseModel responseModel = new UserResetPasswordResponseModel("Password reset successfully!");
            return userResetPasswordOutputBoundary.prepareSuccessView(responseModel);
        } else {
            //Participant
            //Check if the old password of participant is correct

            if (!requestModel.getPassword().equals(parDsGateway.getPassword(requestModel.getUsername()))) {
                return userResetPasswordOutputBoundary.prepareFailureView("Old password is not correct.");
            }

            if (requestModel.getNewPassword().isEmpty()) {
                return userResetPasswordOutputBoundary.prepareFailureView("Password cannot be empty.");
            }
            if (requestModel.getPassword().length() > 20) {
                return userResetPasswordOutputBoundary.prepareFailureView("Password should be no longer than 20 characters.");
            }
            if (requestModel.getNewPassword().equals(requestModel.getPassword())) {
                return userResetPasswordOutputBoundary.prepareFailureView("New password cannot be the same as old one.");
            }
            //Check if the new password and the retyped new password of organizer are same
            if (!requestModel.getNewPassword().equals(requestModel.getReNewPassword())) {
                return userResetPasswordOutputBoundary.prepareFailureView("New Passwords do not match.");

            }

            //If the above two error don't occur, show the successful view
            parDsGateway.setPassword(requestModel.getUsername(), requestModel.getNewPassword());
            UserResetPasswordResponseModel responseModel = new UserResetPasswordResponseModel("Password reset successfully!");
            return userResetPasswordOutputBoundary.prepareSuccessView(responseModel);
        }
    }

}
