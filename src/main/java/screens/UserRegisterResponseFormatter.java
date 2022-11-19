package screens;
import user_register_use_case.UserRegisterPresenter;
import user_register_use_case.UserRegisterResponseModel;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserRegisterResponseFormatter implements UserRegisterPresenter {

    /**This is a method used to prepare the failure view to the user
     *
     * @param failureResponse A String containing information about how to fail
     * @return Response model to show failure view
     */
    public UserRegisterResponseModel prepareFailView(String failureResponse){
        throw new ShowMessageView(failureResponse);
    }

    /**This is a method used to prepare the success view to the user
     *
     * @param responseModel A response model containing information to show the success view
     * @return Response model to show success view
     */
    public UserRegisterResponseModel prepareSuccessView(UserRegisterResponseModel responseModel){
        responseModel.setMessage(responseModel.getUsername() + ", you can login now!");
        return responseModel;
    }
}
