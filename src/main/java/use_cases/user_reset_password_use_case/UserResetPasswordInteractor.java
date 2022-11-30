package use_cases.user_reset_password_use_case;

import database.OrgDsGateway;
import database.ParDsGateway;

public class UserResetPasswordInteractor implements UserResetPasswordInputBoundary {

    final UserResetPasswordOutputBoundary userResetPasswordOutputBoundary;
    final OrgDsGateway orgDsGateway;
    final ParDsGateway parDsGateway;

    /** Constructor
     *
     * @param userResetPasswordOutputBoundary The presenter used to show success or not of the reset
     * @param orgDsGateway The database gateway of the organizations
     * @param parDsGateway The database gateway of the participants.
     */
    public UserResetPasswordInteractor(UserResetPasswordOutputBoundary userResetPasswordOutputBoundary, OrgDsGateway orgDsGateway, ParDsGateway parDsGateway) {
        this.userResetPasswordOutputBoundary = userResetPasswordOutputBoundary;
        this.orgDsGateway = orgDsGateway;
        this.parDsGateway = parDsGateway;
    }

    /**Do checks to user inputs, if fail give hints, if pass change the password.
     *
     * @param requestModel The request model sent to the input boundary
     * @return A responseModel representing whether the user resetPassword is successful.
     */
    public UserResetPasswordResponseModel resetPassword(UserResetPasswordRequestModel requestModel) throws ClassNotFoundException {
        System.out.println(requestModel.isWhether_org());
        if (requestModel.isWhether_org()){
            //Organization
            //Check if the old password of organization is entered correctly
            if (!requestModel.getPassword().equals(orgDsGateway.getPassword(requestModel.getUsername()))){
                System.out.println("Old password is not correct.");
                return userResetPasswordOutputBoundary.prepareFailureView("Old password is not correct.");
            }

            System.out.println(2);
            if (requestModel.getNewPassword().isEmpty()) {
                return userResetPasswordOutputBoundary.prepareFailureView("Password cannot be empty.");
            }
            System.out.println(3);
            if (requestModel.getPassword().length() > 20) {
                return userResetPasswordOutputBoundary.prepareFailureView("Password should be no longer than 20 characters.");
            }
            System.out.println(4);
            if (requestModel.getNewPassword().equals(requestModel.getPassword())) {
                return userResetPasswordOutputBoundary.prepareFailureView("New password cannot be the same as old one.");
            }
            System.out.println(5);
            //Check if the new password and the retyped new password of organizer are same
            if (! requestModel.getNewPassword().equals(requestModel.getReNewPassword())) {
                System.out.println("New Passwords do not match.");
                return userResetPasswordOutputBoundary.prepareFailureView("New Passwords do not match.");

            }

            //If the above two error don't occur, show the successful view
            orgDsGateway.setPassword(requestModel.getUsername(), requestModel.getNewPassword());
            System.out.println("Password reset successfully!");
            UserResetPasswordResponseModel responseModel = new UserResetPasswordResponseModel("Password reset successfully!");
            return userResetPasswordOutputBoundary.prepareSuccessView(responseModel);
        }
        else {
            //Participant
            //Check if the old password of participant is correct
            System.out.println("At least checking");

            if (!requestModel.getPassword().equals(parDsGateway.getPassword(requestModel.getUsername()))){
                System.out.println("Old password is not correct.");
                return userResetPasswordOutputBoundary.prepareFailureView("Old password is not correct.");
            }

            System.out.println(2);
            if (requestModel.getNewPassword().isEmpty()) {
                return userResetPasswordOutputBoundary.prepareFailureView("Password cannot be empty.");
            }
            System.out.println(3);
            if (requestModel.getPassword().length() > 20) {
                return userResetPasswordOutputBoundary.prepareFailureView("Password should be no longer than 20 characters.");
            }
            System.out.println(4);
            if (requestModel.getNewPassword().equals(requestModel.getPassword())) {
                return userResetPasswordOutputBoundary.prepareFailureView("New password cannot be the same as old one.");
            }
            System.out.println(5);
            //Check if the new password and the retyped new password of organizer are same
            if (! requestModel.getNewPassword().equals(requestModel.getReNewPassword())) {
                System.out.println("New Passwords do not match.");
                return userResetPasswordOutputBoundary.prepareFailureView("New Passwords do not match.");

            }

            //If the above two error don't occur, show the successful view
            System.out.println("Password reset successfully!");
            parDsGateway.setPassword(requestModel.getUsername(), requestModel.getNewPassword());
            UserResetPasswordResponseModel responseModel = new UserResetPasswordResponseModel("Password reset successfully!");
            return userResetPasswordOutputBoundary.prepareSuccessView(responseModel);
        }
    }

    public UserResetPasswordResponseModel utilUsernameAndPasswordChecker(UserResetPasswordRequestModel requestModel) throws ClassNotFoundException {
        System.out.println(1);
        System.out.println(requestModel.getPassword());
        System.out.println(2);
        System.out.println(1);
        System.out.println(orgDsGateway.getPassword(requestModel.getUsername()));
        System.out.println(2);
        if (!requestModel.getPassword().equals(orgDsGateway.getPassword(requestModel.getUsername()))){
            System.out.println("Old password is not correct.");
            return userResetPasswordOutputBoundary.prepareFailureView("Old password is not correct.");
        }

        System.out.println(2);
        if (requestModel.getNewPassword().isEmpty()) {
            return userResetPasswordOutputBoundary.prepareFailureView("Password cannot be empty.");
        }
        System.out.println(3);
        if (requestModel.getPassword().length() > 20) {
            return userResetPasswordOutputBoundary.prepareFailureView("Password should be no longer than 20 characters.");
        }
        System.out.println(4);
        if (requestModel.getNewPassword().equals(requestModel.getPassword())) {
            return userResetPasswordOutputBoundary.prepareFailureView("New password cannot be the same as old one.");
        }
        System.out.println(5);
        //Check if the new password and the retyped new password of organizer are same
        if (! requestModel.getNewPassword().equals(requestModel.getReNewPassword())) {
            System.out.println("New Passwords do not match.");
            return userResetPasswordOutputBoundary.prepareFailureView("New Passwords do not match.");

        }
        return null;
    }
}
