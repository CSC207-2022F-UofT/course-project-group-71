package UserRegisterScreen;

import UserRegister.UserRegisterController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LoginScreen extends JPanel {
    private UserRegisterController registercontroller;

    public LoginScreen(UserRegisterController controller){
        this.registercontroller = controller;

        JLabel title = new JLabel("Register A user");

        JLabel label_username = new JLabel("Username");
        JTextField text_username = new JTextField("Enter the username",20);
        JLabel label_password = new JLabel("Password");
        JTextField text_password = new JTextField("Enter the password",20);
        JLabel label_re_password = new JLabel("Re_password");
        JTextField text_re_password = new JTextField("Enter the password again",20);

        ButtonGroup button_group = new ButtonGroup();
        JButton Org_Button = new JButton("Organizer");
        JButton Par_Button = new JButton("Participant");
        button_group.add(Org_Button);
        button_group.add(Par_Button);

        JButton button = new JButton("Register");
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = text_username.getText();
                String password = text_password.getText();
                String re_password = text_re_password.getText();
                boolean whether_org = Org_Button.isSelected();
                registercontroller.create(username,password,re_password,whether_org);
            }
        });



    }
}
