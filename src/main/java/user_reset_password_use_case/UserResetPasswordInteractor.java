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
            //Organizer
            if (! requestModel.getPassword().equals(orgDsGateway.getPassword(requestModel.getUsername()))){
                return userResetPasswordPresenter.prepareFailView("Old password is not correct.");
            }
            if (!requestModel.getNewPassword().equals(requestModel.getReNewPassword())) {
                return userResetPasswordPresenter.prepareFailView("New Passwords do not match.");
            }


            orgDsGateway.setPassword(requestModel.getUsername(), requestModel.getNewPassword());
            UserResetPasswordResponseModel responseModel = new UserResetPasswordResponseModel("Password reset successfully!");
            return userResetPasswordPresenter.prepareSuccessView(responseModel);


        }
        else {
            //Participant
            if (! requestModel.getPassword().equals(parDsGateway.getPassword(requestModel.getUsername()))){
                return userResetPasswordPresenter.prepareFailView("Old password is not correct.");
            }
            if (! requestModel.getNewPassword().equals(requestModel.getReNewPassword())) {
                return userResetPasswordPresenter.prepareFailView("New Passwords do not match.");
            }


            parDsGateway.setPassword(requestModel.getUsername(), requestModel.getNewPassword());
            UserResetPasswordResponseModel responseModel = new UserResetPasswordResponseModel("Password reset successfully!");
            return userResetPasswordPresenter.prepareSuccessView(responseModel);
        }


    }
}
