package user_reset_password_use_case;

import screens.ShowMessageView;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserResetPasswordFormatter implements UserResetPasswordPresenter{
    public UserResetPasswordResponseModel prepareFailView(String message) {
        throw new ShowMessageView(message);
    }

    public UserResetPasswordResponseModel prepareSuccessView(UserResetPasswordResponseModel responseModel) {
        responseModel.setMessage(responseModel.getMessage());
        StackWalker walker = StackWalker.getInstance();
        Optional<String> prepareSuccessView = walker.walk(frames -> frames
                .findFirst()
                .map(StackWalker.StackFrame::getMethodName));
        assertTrue(prepareSuccessView.isPresent());
        assertEquals("prepareSuccessView", prepareSuccessView.get());
        return responseModel;
    }
}
