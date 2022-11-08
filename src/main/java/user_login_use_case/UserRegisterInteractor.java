package user_login_use_case;


public class UserRegisterInteractor implements UserRegisterInputBoundary{
    final ParDsGateway parDsGateway;
    final OrgDsGateway orgDsGateway;

    final UserRegisterPresenter userRegisterPresenter;

    public UserRegisterInteractor(ParDsGateway parDsGateway, OrgDsGateway orgDsGateway, UserRegisterPresenter userRegisterPresenter){
        this.parDsGateway = parDsGateway;
        this.orgDsGateway = orgDsGateway;
        this.userRegisterPresenter = userRegisterPresenter;

    }

    public UserRegisterResponseModel create(UserRegisterRequestModel requestModel){
        if (requestModel.isWhether_org()){
            //Then proceed as organizer
            if (orgDsGateway.checkIfUsernameExist(requestModel.getName()) == false){
                return userRegisterPresenter.prepareFailView("Organizer already exists.");
            }
            if (requestModel.getPassword() != requestModel.getRe_password()){
                return userRegisterPresenter.prepareFailView("Two Passwords are different.");
            }
            orgDsGateway.createOrg(requestModel.getName(),requestModel.getPassword());

        }else{
            //Proceed as participant
            if (parDsGateway.checkIfUsernameExist(requestModel.getName()) == false){
                return userRegisterPresenter.prepareFailView("Participant already exists.");
            }
            if (requestModel.getPassword() != requestModel.getRe_password()){
                return userRegisterPresenter.prepareFailView("Two Passwords are different.");
            }
            parDsGateway.createOrg(requestModel.getName(),requestModel.getPassword());

        }
    }


}
