package UserRegister;


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
            if (orgDsGateway.checkIfUsernameExist(requestModel.getName()) == false){
                UserRegisterResponseModel failureresponse = new UserRegisterResponseModel(requestModel.getName(), requestModel.getPassword(), "Organizer already exists.");
                userRegisterPresenter.prepareFailView(failureresponse);
            }
            if (requestModel.getPassword() != requestModel.getRe_password()){
                UserRegisterResponseModel failureresponse = new UserRegisterResponseModel(requestModel.getName(), requestModel.getPassword(), "Two Passwords are different.");
                userRegisterPresenter.prepareFailView(failureresponse);
            }
            orgDsGateway.createOrg(requestModel.getName(),requestModel.getPassword());
            UserRegisterResponseModel successresponse = new UserRegisterResponseModel();
            userRegisterPresenter.prepareSuccessView(successresponse);

        }else{
            //Proceed as participant
            if (parDsGateway.checkIfUsernameExist(requestModel.getName()) == false){
                UserRegisterResponseModel failureresponse = new UserRegisterResponseModel(requestModel.getName(), requestModel.getPassword(), "Participant already exists.");
                userRegisterPresenter.prepareFailView(failureresponse);
            }
            if (requestModel.getPassword() != requestModel.getRe_password()){
                UserRegisterResponseModel failureresponse = new UserRegisterResponseModel(requestModel.getName(), requestModel.getPassword(), "Two Passwords are different.");

                userRegisterPresenter.prepareFailView(failureresponse);
            }
            parDsGateway.createOrg(requestModel.getName(),requestModel.getPassword());
            UserRegisterResponseModel successresponse = new UserRegisterResponseModel(requestModel.getName(), requestModel.getPassword(), "Two Passwords are different.");
            userRegisterPresenter.prepareSuccessView(successresponse);

        }

    }


}
