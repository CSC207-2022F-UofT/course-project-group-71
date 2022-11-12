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

    public void create(UserRegisterRequestModel requestModel){
        if (requestModel.isWhether_org()){
            //Then proceed as organizer
            if (orgDsGateway.checkIfUsernameExist(requestModel.getName()) == true){
                UserRegisterResponseModel failureresponse = new UserRegisterResponseModel(requestModel.getName(), requestModel.getPassword(), "Organizer already exists.");
                userRegisterPresenter.prepareFailView(failureresponse);
                System.out.println(1);
                return;

            }
            if (!Objects.equals(requestModel.getPassword(), requestModel.getRe_password())){
                System.out.println(requestModel.getPassword());
                System.out.println(requestModel.getRe_password());
                UserRegisterResponseModel failureresponse = new UserRegisterResponseModel(requestModel.getName(), requestModel.getPassword(), "Two Passwords are different.");
                userRegisterPresenter.prepareFailView(failureresponse);
                System.out.println(2);
                return;

            }
            orgDsGateway.createOrg(requestModel.getName(),requestModel.getPassword());
            UserRegisterResponseModel successresponse = new UserRegisterResponseModel(requestModel.getName(), requestModel.getPassword(), "User Register Successful.");
            userRegisterPresenter.prepareSuccessView(successresponse);
            System.out.println(3);
            return;


        }else{
            //Proceed as participant
            if (parDsGateway.checkIfUsernameExist(requestModel.getName()) == true){
                UserRegisterResponseModel failureresponse = new UserRegisterResponseModel(requestModel.getName(), requestModel.getPassword(), "Participant already exists.");
                userRegisterPresenter.prepareFailView(failureresponse);
                System.out.println(4);
                return;
            }
            if (!Objects.equals(requestModel.getPassword(), requestModel.getRe_password())){
                UserRegisterResponseModel failureresponse = new UserRegisterResponseModel(requestModel.getName(), requestModel.getPassword(), "Two Passwords are different.");

                userRegisterPresenter.prepareFailView(failureresponse);
                System.out.println(5);
                return;

            }
            parDsGateway.createPar(requestModel.getName(),requestModel.getPassword());
            UserRegisterResponseModel successresponse = new UserRegisterResponseModel(requestModel.getName(), requestModel.getPassword(), "User Register Successful.");
            userRegisterPresenter.prepareSuccessView(successresponse);
            System.out.println(6);
            return;


        }

    }


}
