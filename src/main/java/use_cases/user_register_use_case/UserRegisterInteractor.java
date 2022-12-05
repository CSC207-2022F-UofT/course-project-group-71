package use_cases.user_register_use_case;


import database.OrgDsGateway;
import database.ParDsGateway;

import java.util.Objects;

public class UserRegisterInteractor implements UserRegisterInputBoundary {
    final ParDsGateway parDsGateway;
    final OrgDsGateway orgDsGateway;
    final UserRegisterOutputBoundary userRegisterOutputBoundary;

    /**Constructor
     *
     * @param parDsGateway The database gateway of the participants
     * @param orgDsGateway The database gateway of the organizers
     * @param userRegisterOutputBoundary The presenter used to show success or not of registration
     */
    public UserRegisterInteractor(ParDsGateway parDsGateway, OrgDsGateway orgDsGateway,
                                  UserRegisterOutputBoundary userRegisterOutputBoundary){
        this.parDsGateway = parDsGateway;
        this.orgDsGateway = orgDsGateway;
        this.userRegisterOutputBoundary = userRegisterOutputBoundary;
    }

    /**Do checks to user inputs, if fail give hints, if pass create the account.
     *
     * @param requestModel The request model sent to the Interactor
     * @return A responseModel representing whether the user creation is successful
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public UserRegisterResponseModel create(UserRegisterRequestModel requestModel) throws ClassNotFoundException {
        //If getUserType() == "O", it means the user is an organizer
        if (requestModel.getUserType().equals("O")) {
            //Check if organization username exists
            if (orgDsGateway.checkIfUsernameExist(requestModel.getUsername())) {
                return userRegisterOutputBoundary.prepareFailView("Organization already exists.");
            }

            //Check if the username is too long
            if (utilUsernameAndPasswordChecker(requestModel)!= null){
                return utilUsernameAndPasswordChecker(requestModel);
            }

            //No problems met, so it shows a success view
            orgDsGateway.createOrg(requestModel.getUsername(), requestModel.getPassword());
            UserRegisterResponseModel responseModel = new UserRegisterResponseModel(requestModel.getUsername());
            return userRegisterOutputBoundary.prepareSuccessView(responseModel);
        }
        //If getUserType() == "P", it means the user is a participant
        else if (requestModel.getUserType().equals("P")) {
            //Check if participant username exists
            if (parDsGateway.checkIfUsernameExist(requestModel.getUsername())) {
                return userRegisterOutputBoundary.prepareFailView("Participant already exists.");
            }
            //Check if the username is too long
            if (utilUsernameAndPasswordChecker(requestModel)!= null){
                return utilUsernameAndPasswordChecker(requestModel);
            }
            //No problems met, so it shows a success view
            parDsGateway.createPar(requestModel.getUsername(), requestModel.getPassword());
            UserRegisterResponseModel responseModel = new UserRegisterResponseModel(requestModel.getUsername());
            return userRegisterOutputBoundary.prepareSuccessView(responseModel);
        } else {
            //The account page is not selected, so shows failure view
            return userRegisterOutputBoundary.prepareFailView("Please select your account type.");
        }

    }
    public UserRegisterResponseModel utilUsernameAndPasswordChecker(UserRegisterRequestModel requestModel) {
        if (requestModel.getUsername().length() > 20) {
            return userRegisterOutputBoundary.prepareFailView("Username should be no longer than 20 characters.");
        }

        //Check if the password is empty
        if (requestModel.getPassword().isEmpty()) {
            return userRegisterOutputBoundary.prepareFailView("Password cannot be empty.");
        }

        //Check if the password is too long
        if (requestModel.getPassword().length() > 20) {
            return userRegisterOutputBoundary.prepareFailView("Password should be no longer than 20 characters.");
        }

        //Check if two passwords are different
        if (!Objects.equals(requestModel.getPassword(), requestModel.getRe_password())) {
            return userRegisterOutputBoundary.prepareFailView("Two Passwords are different.");
        }


        return null;
    }
}