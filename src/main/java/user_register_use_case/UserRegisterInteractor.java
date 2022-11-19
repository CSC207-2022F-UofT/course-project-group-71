package user_register_use_case;


import database.OrgDsGateway;
import database.ParDsGateway;

import java.sql.SQLException;
import java.util.Objects;

public class UserRegisterInteractor implements UserRegisterInputBoundary {
    final ParDsGateway parDsGateway;
    final OrgDsGateway orgDsGateway;

    final UserRegisterPresenter userRegisterPresenter;

    /**This is the construct method of UserRegisterInteractor.
     * It takes DsGateways and Presenter as input to store as instances.
     *
     * @param parDsGateway The database gateway of the participants
     * @param orgDsGateway The database gateway of the organizers
     * @param userRegisterPresenter The presenter used to show success or not of registration
     */
    public UserRegisterInteractor(ParDsGateway parDsGateway, OrgDsGateway orgDsGateway,
                                  UserRegisterPresenter userRegisterPresenter){
        this.parDsGateway = parDsGateway;
        this.orgDsGateway = orgDsGateway;
        this.userRegisterPresenter = userRegisterPresenter;

    }

    /**Use the information contained in the requestmodel to create a new user and respond a responsemodel.
     * It first chooses which DsGateWay to use by checking which user types selected by the user.
     * Then it checks whether username exists in the database.
     * Then it check if two password input are the same.
     * Then it create a user.
     * If failed in one of the above process, return a failure response.
     * Otherwise, success response is returned.
     *
     * @param requestModel The request model sent to the interactor
     * @return A responsemodel representing whether the user creation is successful
     */
    public UserRegisterResponseModel create(UserRegisterRequestModel requestModel) throws SQLException, ClassNotFoundException {
        if (requestModel.getUserType().equals("O")){
            //Then proceed as organizer
            if (orgDsGateway.checkIfUsernameExist(requestModel.getName())){
                return userRegisterPresenter.prepareFailView("Organization already exists.");
            }
            if (!Objects.equals(requestModel.getPassword(), requestModel.getRe_password())){
                return userRegisterPresenter.prepareFailView("Two Passwords are different.");
            }
            orgDsGateway.createOrg(requestModel.getName(),requestModel.getPassword());
            UserRegisterResponseModel responseModel = new UserRegisterResponseModel(requestModel.getName());
            return userRegisterPresenter.prepareSuccessView(responseModel);
        }
        else if (requestModel.getUserType().equals("P")){
            //Proceed as participant
            if (parDsGateway.checkIfUsernameExist(requestModel.getName())){
                return userRegisterPresenter.prepareFailView("Participant already exists.");
            }
            if (!Objects.equals(requestModel.getPassword(), requestModel.getRe_password())) {
                return userRegisterPresenter.prepareFailView("Two Passwords are different.");
            }
            parDsGateway.createPar(requestModel.getName(),requestModel.getPassword());
            UserRegisterResponseModel responseModel = new UserRegisterResponseModel(requestModel.getName());
            return userRegisterPresenter.prepareSuccessView(responseModel);
        }
        else {
            return userRegisterPresenter.prepareFailView("Please select your account type.");
        }

    }


}
