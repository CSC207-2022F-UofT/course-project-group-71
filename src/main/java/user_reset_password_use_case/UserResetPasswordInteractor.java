package user_reset_password_use_case;

import database.OrgDsGateway;
import database.ParDsGateway;

import java.sql.SQLException;

public class UserResetPasswordInteractor implements UserResetPasswordInputBoundary {
    final UserResetPasswordPresenter userResetPasswordPresenter;
    final OrgDsGateway orgDsGateway;
    private final ParDsGateway parDsGateway;


    public UserResetPasswordInteractor(UserResetPasswordPresenter userResetPasswordPresenter, OrgDsGateway orgDsGateway, ParDsGateway parDsGateway) {
        this.userResetPasswordPresenter = userResetPasswordPresenter;
        this.orgDsGateway = orgDsGateway;
        this.parDsGateway = parDsGateway;
    }

    public UserResetPasswordResponseModel resetPassword(UserResetPasswordRequestModel requestModel) throws SQLException, ClassNotFoundException {
        System.out.println(requestModel.isWhether_org());
        if (requestModel.isWhether_org()){
            System.out.println(requestModel.isWhether_org());
            //Organizer
            System.out.println("a");
            System.out.println(orgDsGateway.getPassword(requestModel.getUsername()));
            System.out.println(requestModel.getPassword());
            if (! requestModel.getPassword().equals(orgDsGateway.getPassword(requestModel.getUsername()))){
                System.out.println("Old password is not correct.");
                return userResetPasswordPresenter.prepareView("Old password is not correct.");
            }
            else {
                System.out.println("Half");
                if (requestModel.getNewPassword().equals(requestModel.getReNewPassword())) {
                    orgDsGateway.setPassword(requestModel.getUsername(), requestModel.getNewPassword());
                    System.out.println("Password reset successfully!");
                    return userResetPasswordPresenter.prepareView("Password reset successfully!");
                }
                else {
                    System.out.println("New Passwords do not match.");
                    return userResetPasswordPresenter.prepareView("New Passwords do not match.");
                }
            }
        }
        else {
            //Participant
            if (! requestModel.getPassword().equals(parDsGateway.getPassword(requestModel.getUsername()))){
                System.out.println("Old password is not correct.");
                return userResetPasswordPresenter.prepareView("Old password is not correct.");
            }
            else {
                if (requestModel.getNewPassword().equals(requestModel.getReNewPassword())) {
                    System.out.println("Password reset successfully!");
                    parDsGateway.setPassword(requestModel.getUsername(), requestModel.getNewPassword());
                    return userResetPasswordPresenter.prepareView("Password reset successfully!");
                }
                else {
                    System.out.println("New Passwords do not match.");
                    return userResetPasswordPresenter.prepareView("New Passwords do not match.");
                }
            }
        }


    }
}
