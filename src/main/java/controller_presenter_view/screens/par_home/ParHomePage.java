package controller_presenter_view.screens.par_home;

import controller_presenter_view.screens.par_home.par_show_notification.ParShowNotificationController;
import controller_presenter_view.screens.par_home.par_show_notification.ParShowNotificationPresenter;
import database.ParDsGateway;
import database.ParFileUser;
import use_cases.par_show_notification_use_case.ParShowNotificationInputBoundary;
import use_cases.par_show_notification_use_case.ParShowNotificationInteractor;
import use_cases.par_show_notification_use_case.ParShowNotificationOutputBoundary;
import use_cases.par_show_notification_use_case.ParShowNotificationResponseModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Main.getConstantX;
import static Main.getConstantY;

public class ParHomePage extends JFrame implements ActionListener {

    private final String parUsername;
    JRadioButton org,eve;
    JTextField searchBox;

    ParShowNotificationOutputBoundary parShowNotificationPresenter =  new ParShowNotificationPresenter();

    ParDsGateway parDsGateway = new ParFileUser();

    ParShowNotificationInputBoundary interactor = new ParShowNotificationInteractor(parShowNotificationPresenter,
            parDsGateway);
    ParShowNotificationController parShowNotificationController = new ParShowNotificationController(interactor);

    /**Take the username of the participant, and generate a homepage for this partricipant.
     * The Page contains notifications, account page, upcoming event, past event and followed Org.
     * It also contains a button to log out.
     * In the middle of the page, there's a search bar where participant can search organizer or event.
     *
     * @param parUsername The username o the participant
     */
    public ParHomePage(String parUsername){

        this.parUsername = parUsername;

        this.setLayout(null);

        this.setSize(getConstantX(),getConstantY());

        this.setLocationRelativeTo(null);

        JLabel title = new JLabel(this.parUsername + "'s Home Page");
        title.setBounds (0,0, getConstantX(), 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        JButton showNotifications = new JButton("Show Notifications");
        showNotifications.addActionListener(this);

        JPanel notification = new JPanel();
        notification.add(showNotifications);
        notification.setBounds (0,50, getConstantX(), 40);

        JButton account = new JButton("Account");
        account.addActionListener(new ParHomeActionListener(this));
        account.setBounds (0,150, 150, 30);

        JButton upcomingEvent = new JButton("Upcoming Event");
        upcomingEvent.addActionListener(new ParHomeActionListener(this));
        upcomingEvent.setBounds (0,210, 150, 30);

        JButton pastEvent = new JButton("Past Event");
        pastEvent.addActionListener(new ParHomeActionListener(this));
        pastEvent.setBounds (0,270, 150, 30);

        JButton followedOrg = new JButton("Followed Org");
        followedOrg.addActionListener(new ParHomeActionListener(this));
        followedOrg.setBounds (0,330, 150, 30);

        JButton logOut = new JButton("Log Out");
        logOut.addActionListener(new ParHomeActionListener(this));
        logOut.setBounds (0,550, 150, 30);


        JLabel searchLable= new JLabel("Search for:");
        searchLable.setBounds(160,150,80,40);

        searchBox = new JTextField(15);
        searchBox.setBounds(240,150,500,40);
        org = new JRadioButton("Organization");
        eve = new JRadioButton("Event");

        ButtonGroup group = new ButtonGroup();
        group.add(org);
        group.add(eve);

        JButton search= new JButton("Search");
        search.addActionListener(new ParHomeActionListener(this));

        JPanel buttons1 = new JPanel();
        buttons1.add(org);
        buttons1.add(eve);
        buttons1.setBounds(300,210,200,30);

        JPanel buttons2 = new JPanel();
        buttons2.add(search);
        buttons2.setBounds(310,270,200,30);


        this.add(title);
        this.add(notification);
        this.add(account);
        this.add(upcomingEvent);
        this.add(pastEvent);
        this.add(followedOrg);
        this.add(logOut);
        this.add(searchBox);
        this.add(buttons1);
        this.add(buttons2);
        this.add(searchLable);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    /**This method will be called in ParHomeActionListener.
     * @return it will return a string which is participant's username.
     */
    public String getParUsername() {
        return this.parUsername;
    }

    @Override
    public void actionPerformed(ActionEvent e) {//show notification
        try {
            ParShowNotificationResponseModel responseModel = parShowNotificationController.showNotification(this.getParUsername());
            JOptionPane.showMessageDialog(this, responseModel.getNotifications());
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage());
        }
    }
}
