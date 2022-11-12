package UserRegister;

public interface UserRegisterOutputBoundary{
    void prepareFailView(UserRegisterResponseModel failureresponse);
    void prepareSuccessView(UserRegisterResponseModel successresponse);
}
