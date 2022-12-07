package screens.user_register;

import screens.user_login.LoginPageGenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPageActionListener implements ActionListener {
    private final RegisterPage registerPage;

    /**The constructor of the RegisterPageActionListener.
     * It takes an input RegisterPage and store as instance.
     *
     * @param registerPage The page of registration
     */
    public RegisterPageActionListener(RegisterPage registerPage){
        this.registerPage = registerPage;
    }

    /**It only takes one event, it disposes the original registration page and respond a login page
     * when the button "To Login Page" is clicked.
     *
     * @param actionEvent the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String page = actionEvent.getActionCommand();

        if (page.equals("To Login Page")) {
            this.registerPage.dispose();
            LoginPageGenerator.generateLoginPage();
        }
        else {
            this.registerPage.dispose();
        }
    }
}
