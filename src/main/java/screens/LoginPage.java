package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JPanel implements ActionListener {

    JRadioButton parButton = new JRadioButton();

    JRadioButton orgButton = new JRadioButton();

    JTextField username = new JTextField(15);

    JPasswordField password = new JPasswordField(15);

    UserLoginController userLoginController;

    boolean P = false;
    boolean O = false;

    public LoginPage(UserLoginController controller) {
        this.userLoginController = controller;
        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JRadioButton parButton = new JRadioButton("Participant");
        parButton.setActionCommand("P");
        JRadioButton orgButton = new JRadioButton("Organization");
        orgButton.setActionCommand("O");

        parButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                P = !P;
                if (O) { O = false; }
            }
        });
        orgButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                O = !O;
                if (P) { P = false; }
            }
        });

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

        JPanel buttons = new JPanel();
        buttons.add(logIn);
        buttons.add(cancel);

        logIn.addActionListener(this);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(cancel.getParent(), "Clicked cancel");
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(typeInfo);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(buttons);
    }
    public void actionPerformed(ActionEvent selectType) {
        ///System.out.println(username.getText());
        try {
            userLoginController.login(
                    P?"P":"",
                    O?"O":"",
                    username.getText(),
                    String.valueOf(password.getPassword()));
            JOptionPane.showMessageDialog(this, username.getText()+" logged in.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

}
