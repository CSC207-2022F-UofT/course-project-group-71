package user_reset_password_use_case;

import database.OrgDsGateway;
import database.ParDsGateway;

public class UserResetPasswordInteractor implements UserResetPasswordInputBoundary {
    final UserResetPasswordPresenter userResetPasswordPresenter;
    final OrgDsGateway orgDsGateway;
    private final ParDsGateway parDsGateway;


    public UserResetPasswordInteractor(UserResetPasswordPresenter userResetPasswordPresenter, OrgDsGateway orgDsGateway, ParDsGateway parDsGateway) {
        this.userResetPasswordPresenter = userResetPasswordPresenter;
        this.orgDsGateway = orgDsGateway;
        this.parDsGateway = parDsGateway;
    }

    public UserResetPasswordResponseModel resetPassword(UserResetPasswordRequestModel requestModel) {
        if (requestModel.isWhether_org()){
            //Organizer
            System.out.println("a");
            if (requestModel.getPassword().equals(orgDsGateway.getPassword(requestModel.getPassword()))){
                System.out.println("b");
                return userResetPasswordPresenter.prepareView("Old password is not correct.");
            }
            else {
                if (requestModel.getNewPassword().equals(requestModel.getReNewPassword())) {
                    orgDsGateway.setPassword(requestModel.getUsername(), requestModel.getNewPassword());
                    return userResetPasswordPresenter.prepareView("Password reset successfully!");
                }
                else {
                    return userResetPasswordPresenter.prepareView("New Passwords do not match.");
                }
            }
        }
        else {
            //Participant
            if (requestModel.getPassword().equals(parDsGateway.getPassword(requestModel.getPassword()))){
                return userResetPasswordPresenter.prepareView("Old password is not correct.");
            }
            else {
                if (requestModel.getNewPassword().equals(requestModel.getReNewPassword())) {
                    parDsGateway.setPassword(requestModel.getUsername(), requestModel.getNewPassword());
                    return userResetPasswordPresenter.prepareView("Password reset successfully!");
                }
                else {
                    return userResetPasswordPresenter.prepareView("New Passwords do not match.");
                }
            }
        }


    }
}
