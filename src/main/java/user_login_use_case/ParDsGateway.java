package user_login_use_case;

public interface ParDsGateway {
    boolean existsByUsername(String username);

    boolean checkPassword(String password);

    void save(UserRegisterDsRequestModel requestModel);
}
