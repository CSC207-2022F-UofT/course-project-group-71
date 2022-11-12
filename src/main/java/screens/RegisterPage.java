package screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import user_register_use_case.*;

public class RegisterPage extends JFrame implements ActionListener {

    JTextField username = new JTextField(15);

    JPasswordField password = new JPasswordField(15);
    
    JPasswordField retypePassword = new JPasswordField(15);

    UserRegisterController userRegisterController;

    boolean P = false;
    boolean O = false;

    int x = 300;
    int y = 300;

    public RegisterPage(UserRegisterController controller) {

        this.setLayout(null);

        this.setSize(x,y);

        this.setLocationRelativeTo(null);

        this.userRegisterController = controller;
        JLabel title = new JLabel("Register Screen");
        title.setBounds (0,0, x, 50);
        title.setHorizontalAlignment(JLabel.CENTER);

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

        JButton register = new JButton("Register");
        JButton cancel = new JButton("Cancel");
        JButton login = new JButton("Login");

        ButtonGroup userType = new ButtonGroup();
        userType.add(parButton);
        userType.add(orgButton);

        JPanel typeInfo = new JPanel();
        typeInfo.add(parButton);
        typeInfo.add(orgButton);
        typeInfo.setBounds (0,50, x, 50);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username"), username);
        usernameInfo.setBounds (0,100, x, 50);

        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), password);
        passwordInfo.setBounds (0,150, x, 50);

        LabelTextPanel retypePasswordInfo = new LabelTextPanel(
                new JLabel("Retype Password"), retypePassword);
        passwordInfo.setBounds (0,150, x, 50);

        JPanel buttons = new JPanel();

        buttons.add(login);
        buttons.add(register);
        buttons.add(cancel);
        buttons.setBounds (0,200, x, 50);

        register.addActionListener(new RegisterActionListener(this));

        login.addActionListener(this);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               JOptionPane.showMessageDialog(cancel.getParent(), "Clicked cancel");
            }
        });

        this.add(title);
        this.add(typeInfo);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(buttons);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }
    public void actionPerformed(ActionEvent selectType) {
        ///System.out.println(username.getText());
        try {
            userRegisterController.create(
                    P?"P":"",
                    O?"O":"",
                    username.getText(),
                    String.valueOf(password.getPassword()),
                    String.valueOf(retypePassword.getPassword()));
            this.dispose();
            if (P) {new ParHomePage(username.getText());}
            else { new OrgHomePage(username.getText());}
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

}
