package screens;
import screens.ShowMessageView;
import user_register_use_case.UserRegisterPresenter;
import user_register_use_case.UserRegisterResponseModel;

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
        //UserRegisterResponseModel responseModel = new
          //      setMessage();
        throw new ShowMessageView(responseModel.getUsername() + ", you can login now!");
    }
}
