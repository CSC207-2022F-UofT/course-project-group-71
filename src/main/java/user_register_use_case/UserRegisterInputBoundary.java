package user_register_use_case;

public interface UserRegisterInputBoundary {
    /**Use the information contained in the requestmodel to create a new user and respond a responsemodel.
     *
     * @param requestModel The request model sent to the input boundary
     * @return A responsemodel representing whether the user creation is successful
     */
    UserRegisterResponseModel create(UserRegisterRequestModel requestModel);
}
