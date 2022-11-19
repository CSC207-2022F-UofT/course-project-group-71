package user_reset_password_use_case;

import database.OrgDsGateway;
import database.ParDsGateway;

import java.sql.SQLException;

public class UserResetPasswordInteractor implements UserResetPasswordInputBoundary {
    final UserResetPasswordOutputBoundary userResetPasswordOutputBoundary;
    final OrgDsGateway orgDsGateway;
    private final ParDsGateway parDsGateway;


    public UserResetPasswordInteractor(UserResetPasswordOutputBoundary userResetPasswordOutputBoundary, OrgDsGateway orgDsGateway, ParDsGateway parDsGateway) {
        this.userResetPasswordOutputBoundary = userResetPasswordOutputBoundary;
        this.orgDsGateway = orgDsGateway;
        this.parDsGateway = parDsGateway;
    }

    public UserResetPasswordResponseModel resetPassword(UserResetPasswordRequestModel requestModel) throws SQLException, ClassNotFoundException {
        System.out.println(requestModel.isWhether_org());
        if (requestModel.isWhether_org()){
            //Organizer
            if (! requestModel.getPassword().equals(orgDsGateway.getPassword(requestModel.getUsername()))){
                System.out.println("Old password is not correct.");
                return userResetPasswordOutputBoundary.prepareFailureView("Old password is not correct.");
            }
            if (! requestModel.getNewPassword().equals(requestModel.getReNewPassword())) {
                System.out.println("New Passwords do not match.");
                return userResetPasswordOutputBoundary.prepareFailureView("New Passwords do not match.");

            }
            orgDsGateway.setPassword(requestModel.getUsername(), requestModel.getNewPassword());
            System.out.println("Password reset successfully!");
            UserResetPasswordResponseModel responseModel = new UserResetPasswordResponseModel("Password reset successfully!");
            return userResetPasswordOutputBoundary.prepareSuccessView(responseModel);
        }
        else {
            //Participant
            if (! requestModel.getPassword().equals(parDsGateway.getPassword(requestModel.getUsername()))){
                System.out.println("Old password is not correct.");
                return userResetPasswordOutputBoundary.prepareFailureView("Old password is not correct.");
            }
            if (! requestModel.getNewPassword().equals(requestModel.getReNewPassword())) {
                System.out.println("New Passwords do not match.");
                return userResetPasswordOutputBoundary.prepareFailureView("New Passwords do not match.");
            }
            System.out.println("Password reset successfully!");
            parDsGateway.setPassword(requestModel.getUsername(), requestModel.getNewPassword());
            UserResetPasswordResponseModel responseModel = new UserResetPasswordResponseModel("Password reset successfully!");
            return userResetPasswordOutputBoundary.prepareSuccessView(responseModel);
        }


    }
}
