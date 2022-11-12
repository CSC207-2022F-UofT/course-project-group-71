package screens;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LoginScreen {
    public void actionPerformed(ActionEvent evt) {
        try {
            userLoginController.create(
                    isParticipant.getBoolean();
                    isOrganization.getBoolean();
                    username.getText(),
                    String.valueOf(password.getPassword()),;
            JOptionPane.showMessageDialog(this, "%s created.".formatted(username.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
