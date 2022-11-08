package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame implements ActionListener {
    JRadioButton isParticipant = new JRadioButton();
    JRadioButton isOrganization = new JRadioButton();
    JTextField username = new JTextField(15);
    /**
     * The password
     */
    JPasswordField password = new JPasswordField(15);

    UserLoginController userLoginController;

    public LoginScreen(UserLoginController controller) {
        this.userLoginController = controller;
        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel userTypeInfo = new LabelTextPanel(
                new JLabel("Choose user type"), type);
        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), password);

        JButton logIn = new JButton("Log in");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(logIn);
        buttons.add(cancel);

        logIn.addActionListener(this);
        cancel.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(usernameInfo);
        main.add(passwordInfo);
        main.add(buttons);
        this.setContentPane(main);

        this.pack();
    }
    public void actionPerformed(ActionEvent evt) {
        try {
            userLoginController.create(
                    isParticipant.getBoolean(),
                    isOrganization.getBoolean(),
                    username.getText(),
                    String.valueOf(password.getPassword()));
            JOptionPane.showMessageDialog(this, "%s created.".formatted(username.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

}
