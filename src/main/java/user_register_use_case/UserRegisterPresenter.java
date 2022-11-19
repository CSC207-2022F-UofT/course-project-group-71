package user_register_use_case;

/** Class used to prepare failure or success view.
 *
 */
public interface UserRegisterPresenter {
    /**A method used to show failure view to the user
     *
     * @param failureResponse A String containing information about how to fail
     * @return A response model showing failure view
     */
    UserRegisterResponseModel prepareFailView(String failureResponse);

    /**A method used to show success view to the user
     *
     * @param responseModel A response model containing information to show success view
     * @return A response model showing failure view
     */
    UserRegisterResponseModel prepareSuccessView(UserRegisterResponseModel responseModel);
}
