package screens.user_login;

import screens.CommonMethod;
import screens.LabelTextPanel;
import screens.org_home.OrgHomePage;
import screens.par_home.ParHomePage;
import controllers.UserLoginController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame implements ActionListener {

    final JTextField USERNAME = new JTextField(15);
    final JPasswordField PASSWORD = new JPasswordField(15);
    final UserLoginController USER_LOGIN_CONTROLLER;
    boolean P = false;
    boolean O = false;
    final int X = 500;
    final int Y = 500;

    /**The method generate a login page.
     * It contains button to choose the user type for login.
     * It allows user to input USERNAME, and PASSWORD.
     * The controller process the information after use clicks 'Login' button, it calls actionPerformed method.
     *
     * @param controller UserLoginController that takes information got from the page
     */
    public LoginPage(UserLoginController controller) {

        this.setLayout(null);

        this.setSize(X, Y);

        this.setLocationRelativeTo(null);

        this.USER_LOGIN_CONTROLLER = controller;
        JLabel title = new JLabel("Login Screen");
        title.setBounds (0,0, X, 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        JRadioButton parButton = new JRadioButton("Participant");
        parButton.setActionCommand("P");
        JRadioButton orgButton = new JRadioButton("Organization");
        orgButton.setActionCommand("O");

        parButton.addActionListener(actionEvent -> {
            if (O) { P = !P; O = false; }
            else {P = true;}
        });
        orgButton.addActionListener(actionEvent -> {
            if (P) { O = !O; P = false; }
            else {O = true;}
        });

        JButton logIn = new JButton("Log in");
        JButton cancel = new JButton("Cancel");
        JButton register = new JButton("To Register Page");

        ButtonGroup userType = new ButtonGroup();
        userType.add(parButton);
        userType.add(orgButton);

        JPanel typeInfo = new JPanel();
        typeInfo.add(parButton);
        typeInfo.add(orgButton);
        typeInfo.setBounds (0,50, X, 50);

        LabelTextPanel USERNAMEInfo = new LabelTextPanel(
                new JLabel("Username"), USERNAME);
        USERNAMEInfo.setBounds (0,100, X, 50);

        LabelTextPanel PASSWORDInfo = new LabelTextPanel(
                new JLabel("Password"), PASSWORD);
        PASSWORDInfo.setBounds (0,150, X, 50);

        JPanel buttons = new JPanel();

        buttons.add(register);
        buttons.add(logIn);
        buttons.add(cancel);
        buttons.setBounds (0,200, X, 50);

        register.addActionListener(new LoginPageActionListener(this));

        logIn.addActionListener(this);

        cancel.addActionListener(new LoginPageActionListener(this));

        this.add(title);
        this.add(typeInfo);
        this.add(USERNAMEInfo);
        this.add(PASSWORDInfo);
        this.add(buttons);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }

    /**The method got information needed to input from the page.
     * The method generate Presenter , DsGateways, interact and controller to process them.
     * Once the information are passed to the above components, jump to login page.
     *
     * @param e the Login event
     */
    public void actionPerformed(ActionEvent e) {
        try {
            USER_LOGIN_CONTROLLER.login(
                    P?"P":"",
                    O?"O":"",
                    USERNAME.getText(),
                    String.valueOf(PASSWORD.getPassword()));
            this.dispose();
            //if the user is a participant, call upcoming_to_past to filter all the upcoming events of this participant,
            //and convert some events from upcoming to past if necessary.
            if (P) {
                CommonMethod.convertAndNotify("P", USERNAME.getText());
                new ParHomePage(USERNAME.getText());
            }
            else {//if the user is an organization, upcoming_to_past not be called at this stage.
                new OrgHomePage(USERNAME.getText());
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage());
        }
    }

}
