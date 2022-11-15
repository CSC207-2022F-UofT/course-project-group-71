package screens.par_home;

import database.ParDsGateway;
import database.ParFileUser;
import screens.par_show_notification.ParShowNotificationController;
import screens.par_show_notification.ParShowNotificationResponseFormatter;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static tutorial.HelloWorld.getConstantX;
import static tutorial.HelloWorld.getConstantY;
import par_show_notification_use_case.*;

public class ParHomePage extends JFrame implements ActionListener {

    private String parUsername;
    JRadioButton org,eve;

    ParShowNotificationPresenter parShowNotificationPresenter =  new ParShowNotificationResponseFormatter();

    ParDsGateway parDsGateway = new ParFileUser();

    ParShowNotificationInputBoundary interactor = new ParShowNotificationInteractor( parShowNotificationPresenter, parDsGateway);
    ParShowNotificationController parShowNotificationController = new ParShowNotificationController(interactor);

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
        showNotifications.setBounds (0,0, 150, 30);

        JButton account = new JButton("Account");
        account.addActionListener(new ParHomeActionListener(this));
        account.setBounds (0,100, 150, 30);

        JButton upcomingEvent = new JButton("Upcoming Event");
        upcomingEvent.addActionListener(new ParHomeActionListener(this));
        upcomingEvent.setBounds (0,180, 150, 30);

        JButton pastEvent = new JButton("Past Event");
        pastEvent.addActionListener(new ParHomeActionListener(this));
        pastEvent.setBounds (0,210, 150, 30);

        JButton followedOrg = new JButton("Followed Org");
        followedOrg.addActionListener(new ParHomeActionListener(this));
        followedOrg.setBounds (0,240, 150, 30);

        JButton logOut = new JButton("Log Out");
        logOut.addActionListener(new ParHomeActionListener(this));
        logOut.setBounds (0,320, 150, 30);


        JTextField searchbox= new JTextField(20);
        searchbox.setBounds(200,100,500,50);
        org = new JRadioButton("Organizer");
        eve = new JRadioButton("Event");

        ButtonGroup group = new ButtonGroup();
        group.add(org);
        group.add(eve);

        JButton search= new JButton("Search");
        search.addActionListener(new ParHomeActionListener(this));

        JPanel buttons1 = new JPanel();
        buttons1.add(org);
        buttons1.add(eve);
        buttons1.setBounds(300,180,200,50);

        JPanel buttons2 = new JPanel();
        buttons2.add(search);
        buttons2.setBounds(310,230,200,50);

        JLabel searchLable= new JLabel("Type:");
        searchLable.setBounds(160,100,50,50);


        this.add(title);
        this.add(showNotifications);
        this.add(account);
        this.add(upcomingEvent);
        this.add(pastEvent);
        this.add(followedOrg);
        this.add(logOut);
        this.add(searchbox);
        this.add(buttons1);
        this.add(buttons2);
        this.add(searchLable);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    public String getParUsername() { return this.parUsername;}

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            parShowNotificationController.showNotification(this.getParUsername());
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage());
        }
    }
}
