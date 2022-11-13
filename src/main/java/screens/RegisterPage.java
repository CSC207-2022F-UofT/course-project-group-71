package screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import database.OrgDsGateway;
import database.OrgFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import screens.org_home.OrgHomeResponseFormatter;
import screens.par_home.ParHomeResponseFormatter;
import user_login_use_case.*;
import user_register_use_case.*;

public class RegisterPage extends JFrame implements ActionListener {

    JTextField username = new JTextField(15);

    JPasswordField password = new JPasswordField(15);
    
    JPasswordField retypePassword = new JPasswordField(15);

    UserRegisterController userRegisterController;

    boolean P = false;
    boolean O = false;

    int x = 500;
    int y = 500;

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
        JButton login = new JButton("To Login Page");

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
        retypePasswordInfo.setBounds (0,200, x, 50);

        JPanel buttons = new JPanel();

        buttons.add(login);
        buttons.add(register);
        buttons.add(cancel);
        buttons.setBounds (0,250, x, 50);

        register.addActionListener(this);

        login.addActionListener(new RegisterPageActionListener(this));

        cancel.addActionListener(new RegisterPageActionListener(this));

        this.add(title);
        this.add(typeInfo);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(retypePasswordInfo);
        this.add(buttons);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }
    public void actionPerformed(ActionEvent selectType) {
        try {
            userRegisterController.create(
                    P?"P":"",
                    O?"O":"",
                    username.getText(),
                    String.valueOf(password.getPassword()),
                    String.valueOf(retypePassword.getPassword()));
            this.dispose();
            UserLoginPresenter userLoginPresenter =  new UserLoginResponseFormatter();

            ParDsGateway parDsGateway = new ParFileUser();

            ParHomePresenter parHomePresenter =  new ParHomeResponseFormatter();

            OrgDsGateway orgDsGateway= new OrgFileUser();

            OrgHomePresenter orgHomePresenter =  new OrgHomeResponseFormatter();

            UserLoginInputBoundary interactor = new UserLoginInteractor(
                    userLoginPresenter, parDsGateway, parHomePresenter, orgDsGateway, orgHomePresenter);

            UserLoginController userLoginController = new UserLoginController(interactor);

            new LoginPage(userLoginController);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

}
