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
                UserRegisterResponseModel failureresponse = new UserRegisterResponseModel(requestModel.getName(), requestModel.getPassword(), "Organizer already exists.");
                return userRegisterPresenter.prepareFailView(failureresponse);

            }
            if (!Objects.equals(requestModel.getPassword(), requestModel.getRe_password())){
                System.out.println(requestModel.getPassword());
                System.out.println(requestModel.getRe_password());
                UserRegisterResponseModel failureresponse = new UserRegisterResponseModel(requestModel.getName(), requestModel.getPassword(), "Two Passwords are different.");
                return userRegisterPresenter.prepareFailView(failureresponse);

            }
            orgDsGateway.createOrg(requestModel.getName(),requestModel.getPassword());
            UserRegisterResponseModel successresponse = new UserRegisterResponseModel(requestModel.getName(), requestModel.getPassword(), "User Register Successful.");
            return userRegisterPresenter.prepareSuccessView(successresponse);


        }else if (requestModel.getUserType().equals("P")){
            //Proceed as participant
            if (parDsGateway.checkIfUsernameExist(requestModel.getName()) == true){
                UserRegisterResponseModel failureresponse = new UserRegisterResponseModel(requestModel.getName(), requestModel.getPassword(), "Participant already exists.");
                return userRegisterPresenter.prepareFailView(failureresponse);
            }
            if (!Objects.equals(requestModel.getPassword(), requestModel.getRe_password())){
                UserRegisterResponseModel failureresponse = new UserRegisterResponseModel(requestModel.getName(), requestModel.getPassword(), "Two Passwords are different.");
                return userRegisterPresenter.prepareFailView(failureresponse);

            }
            parDsGateway.createPar(requestModel.getName(),requestModel.getPassword());
            UserRegisterResponseModel successresponse = new UserRegisterResponseModel(requestModel.getName(), requestModel.getPassword(), "User Register Successful.");
            return userRegisterPresenter.prepareSuccessView(successresponse);


        }
        else {
            return userRegisterPresenter.prepareFailView("Please select your account type.");
        }

    }


}
