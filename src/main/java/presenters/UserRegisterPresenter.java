package presenters;
import screens.common_view.ShowMessageView;
import use_cases.user_register_use_case.UserRegisterOutputBoundary;
import use_cases.user_register_use_case.UserRegisterResponseModel;

public class UserRegisterPresenter implements UserRegisterOutputBoundary {

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
