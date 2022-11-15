package user_register_use_case;


import database.OrgDsGateway;
import database.ParDsGateway;

import java.util.Objects;

public class UserRegisterInteractor implements UserRegisterInputBoundary {
    final ParDsGateway parDsGateway;
    final OrgDsGateway orgDsGateway;

    final UserRegisterPresenter userRegisterPresenter;

    public UserRegisterInteractor(ParDsGateway parDsGateway, OrgDsGateway orgDsGateway, UserRegisterPresenter userRegisterPresenter){
        this.parDsGateway = parDsGateway;
        this.orgDsGateway = orgDsGateway;
        this.userRegisterPresenter = userRegisterPresenter;

    }

    public UserRegisterResponseModel create(UserRegisterRequestModel requestModel){
        if (requestModel.getUserType().equals("O")){
            //Then proceed as organizer
            if (orgDsGateway.checkIfUsernameExist(requestModel.getName()) == true){
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
            if (parDsGateway.checkIfUsernameExist(requestModel.getName()) == true){
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
