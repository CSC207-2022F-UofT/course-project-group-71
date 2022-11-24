package screens;

import database.*;
import notify_event_use_case.NotifyEventInputBoundary;
import notify_event_use_case.NotifyEventInteractor;
import notify_event_use_case.NotifyEventOutputBoundary;
import screens.org_home.OrgHomePage;
import screens.notify_event.NotifyEventController;
import screens.notify_event.NotifyEventPresenter;
import screens.par_home.ParHomePage;
import screens.upcoming_to_past.UpcomingToPastController;
import screens.upcoming_to_past.UpcomingToPastPresenter;
import upcoming_to_past_use_case.UpcomingToPastInputBoundary;
import upcoming_to_past_use_case.UpcomingToPastInteractor;
import upcoming_to_past_use_case.UpcomingToPastOutputBoundary;
import upcoming_to_past_use_case.UpcomingToPastResponseModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginPage extends JFrame implements ActionListener {

    JTextField username = new JTextField(15);

    JPasswordField password = new JPasswordField(15);

    UserLoginController userLoginController;

    boolean P = false;
    boolean O = false;

    int x = 500;
    int y = 500;

    /**The method generate a login page.
     * It contains button to choose the user type for login.
     * It allows user to input username, and password.
     * The controller process the information after use clicks 'Login' button, it calls actionPerformed method.
     *
     * @param controller UserLoginController that takes information got from the page
     */
    public LoginPage(UserLoginController controller) {

        this.setLayout(null);

        this.setSize(x,y);

        this.setLocationRelativeTo(null);

        this.userLoginController = controller;
        JLabel title = new JLabel("Login Screen");
        title.setBounds (0,0, x, 50);
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
        typeInfo.setBounds (0,50, x, 50);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username"), username);
        usernameInfo.setBounds (0,100, x, 50);

        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), password);
        passwordInfo.setBounds (0,150, x, 50);

        JPanel buttons = new JPanel();

        buttons.add(register);
        buttons.add(logIn);
        buttons.add(cancel);
        buttons.setBounds (0,200, x, 50);

        register.addActionListener(new LoginPageActionListener(this));

        logIn.addActionListener(this);

        cancel.addActionListener(new LoginPageActionListener(this));

        this.add(title);
        this.add(typeInfo);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(buttons);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }

    /**The method got information needed to input from the page.
     * The method generate Presenter , DsGateways, interactor and controller to process them.
     * Once the information are passed to the above components, jump to login page.
     *
     * @param e the Login event
     */
    public void actionPerformed(ActionEvent e) {
        try {
            userLoginController.login(
                    P?"P":"",
                    O?"O":"",
                    username.getText(),
                    String.valueOf(password.getPassword()));
            this.dispose();
            if (P) {
                ParDsGateway parDsGateway = new ParFileUser();
                OrgDsGateway orgDsGateway = new OrgFileUser();
                EventDsGateway eventDsGateway = new EventFileUser();
                UpcomingToPastOutputBoundary upcomingToPastOutputBoundary = new UpcomingToPastPresenter();
                UpcomingToPastInputBoundary interactor = new UpcomingToPastInteractor(parDsGateway, orgDsGateway,
                        eventDsGateway, upcomingToPastOutputBoundary);
                UpcomingToPastController controller = new UpcomingToPastController(interactor);
                UpcomingToPastResponseModel responseModel;
                try {
                    responseModel = controller.convertToPast("P",username.getText());
                } catch (SQLException | ClassNotFoundException exception) {
                    throw new RuntimeException(exception);
                }
                if (!responseModel.getEventsToPast().isEmpty()){
                    NotifyEventOutputBoundary notifyEventOutputBoundary = new NotifyEventPresenter();
                    NotifyEventInputBoundary interactor2 = new NotifyEventInteractor(eventDsGateway, parDsGateway,
                            notifyEventOutputBoundary);
                    NotifyEventController notifyEventController = new NotifyEventController(interactor2);
                    for (String event : responseModel.getEventsToPast()){
                        try {
                            notifyEventController.sendNotification("Past", event);
                        } catch (SQLException | ClassNotFoundException exception) {
                            throw new RuntimeException(exception);
                        }
                    }
                }
                new ParHomePage(username.getText());
            }
            else {new OrgHomePage(username.getText());}
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage());
        }
    }

}
