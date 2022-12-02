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

import static controller_presenter_view.screens.screen_constants.getConstantX;
import static controller_presenter_view.screens.screen_constants.getConstantY;

public class ParHomePage extends JFrame implements ActionListener {

    private final String parUsername;
    final JRadioButton org;
    final JRadioButton eve;
    final JTextField searchBox;

    final ParShowNotificationOutputBoundary parShowNotificationPresenter =  new ParShowNotificationPresenter();

    final ParDsGateway parDsGateway = new ParFileUser();

    final ParShowNotificationInputBoundary interactor = new ParShowNotificationInteractor(parShowNotificationPresenter,
            parDsGateway);
    final ParShowNotificationController parShowNotificationController = new ParShowNotificationController(interactor);


    /**
     * This function returns a JButton with the input as set bounds
     * @param text string of the button showing
     * @param x the integer x for set bounds
     * @param y the integer y for set bounds
     * @param width the integer representing the width for set bounds
     * @param height the integer representing the height for set bounds
     * @return return the JButton
     */
    public JButton create_jbutton(String text, int x, int y, int width, int height){
        JButton output = new JButton(text);
        output.addActionListener(new ParHomeActionListener(this));
        output.setBounds (x, y, width, height);
        return output;
    }

    /**Take the username of the participant, and generate a homepage for this participant.
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

//        JButton account = new JButton("Account");
//        account.addActionListener(new ParHomeActionListener(this));
//        account.setBounds (0,150, 150, 30);

//        JButton upcomingEvent = new JButton("Upcoming Event");
//        upcomingEvent.addActionListener(new ParHomeActionListener(this));
//        upcomingEvent.setBounds (0,210, 150, 30);

//        JButton pastEvent = new JButton("Past Event");
//        pastEvent.addActionListener(new ParHomeActionListener(this));
//        pastEvent.setBounds (0,270, 150, 30);

//        JButton followedOrg = new JButton("Followed Org");
//        followedOrg.addActionListener(new ParHomeActionListener(this));
//        followedOrg.setBounds (0,330, 150, 30);

//        JButton logOut = new JButton("Log Out");
//        logOut.addActionListener(new ParHomeActionListener(this));
//        logOut.setBounds (0,550, 150, 30);

        JLabel searchJLable= new JLabel("Search for:");
        searchJLable.setBounds(160,150,80,40);

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
        this.add(create_jbutton("Account", 0,150, 150, 30));
        this.add(create_jbutton("Upcoming Event", 0,210, 150, 30));
        this.add(create_jbutton("Past Event", 0,270, 150, 30));
        this.add(create_jbutton("Followed Org", 0,330, 150, 30));
        this.add(create_jbutton("Log Out", 0,550, 150, 30));
        this.add(searchBox);
        this.add(buttons1);
        this.add(buttons2);
        this.add(searchJLable);

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
