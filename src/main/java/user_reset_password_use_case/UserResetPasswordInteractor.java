package user_reset_password_use_case;

import database.OrgDsGateway;
import database.ParDsGateway;

import java.sql.SQLException;

public class UserResetPasswordInteractor implements UserResetPasswordInputBoundary {
    final UserResetPasswordPresenter userResetPasswordPresenter;
    final OrgDsGateway orgDsGateway;
    private final ParDsGateway parDsGateway;

    /** This is the construct method of UserRsetPasswordInteractor.
     *  It takes DsGateways and Presenter as input to store as instances.
     * @param userResetPasswordPresenter The presenter used to show success or not of reseting the password
     * @param orgDsGateway The database gateway of the orgnizers
     * @param parDsGateway The database gateway of the participants.
     */


    public UserResetPasswordInteractor(UserResetPasswordPresenter userResetPasswordPresenter, OrgDsGateway orgDsGateway, ParDsGateway parDsGateway) {
        this.userResetPasswordPresenter = userResetPasswordPresenter;
        this.orgDsGateway = orgDsGateway;
        this.parDsGateway = parDsGateway;
    }

    /**Use the information contained in the requestmodel to reset a new password and respond a responsemodel.
     *It first chooses which DsGateway to use by checking which user types selected by the user.
     * Then it checks whether password exists in the database.
     * if not, return "Old password is not correct."
     * if it is, it will check whether the newpassword and retypenewpassword are match.
     * if matcching, return "New Passwords do not match."
     * otherwise, success response is returnd.
     * @param requestModel The request model sent to the input boundary
     * @return A responsemodel representing whether the user resetPassword is successful.
     */

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
