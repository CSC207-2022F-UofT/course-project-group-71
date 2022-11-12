package user_register_use_case;

public interface UserRegisterOutputBoundary{
    void prepareFailView(UserRegisterResponseModel failureresponse);
    void prepareSuccessView(UserRegisterResponseModel successresponse);
}
