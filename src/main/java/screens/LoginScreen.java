package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame implements ActionListener {
    ButtonGroup userType = new ButtonGroup();
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

        JRadioButton parButton = new JRadioButton("Participant");
        parButton.setActionCommand("Participant");
        JRadioButton orgButton = new JRadioButton("Organization");
        orgButton.setActionCommand("Organization");

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), password);

        JButton logIn = new JButton("Log in");
        JButton cancel = new JButton("Cancel");

        ButtonGroup userType = new ButtonGroup();
        userType.add(parButton);
        userType.add(orgButton);

        JPanel typeInfo = new JPanel();
        typeInfo.add(parButton);
        typeInfo.add(orgButton);

        parButton.addActionListener(this);
        orgButton.addActionListener(this);

        JPanel buttons = new JPanel();
        buttons.add(logIn);
        buttons.add(cancel);

        logIn.addActionListener(this);
        cancel.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(typeInfo);
        main.add(usernameInfo);
        main.add(passwordInfo);
        main.add(buttons);
        this.setContentPane(main);

        this.pack();
    }
    public void actionPerformed(ActionEvent evt) {
        try {
            userLoginController.login(
                    userType.getActionCommand(),
                    username.getText(),
                    String.valueOf(password.getPassword()));
            JOptionPane.showMessageDialog(this, username.getText()+" created.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

}
