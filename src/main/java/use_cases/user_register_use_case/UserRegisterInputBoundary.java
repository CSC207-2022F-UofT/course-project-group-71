package use_cases.user_register_use_case;

/** Interface implements by interactor.
 * The interactor who implement the interface must have create() method.
 */
public interface UserRegisterInputBoundary {
    /**Use the information contained in the requestModel to create a new user and respond a responseModel.
     *
     * @param requestModel The request model sent to the input boundary
     * @return A responseModel representing whether the user creation is successful
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    UserRegisterResponseModel create(UserRegisterRequestModel requestModel) throws ClassNotFoundException;
}
