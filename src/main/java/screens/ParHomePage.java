package screens;

import par_show_notification_use_case.ParShowNotificationResponseModel;
import user_login_use_case.UserLoginResponseModel;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static tutorial.HelloWorld.getConstantX;
import static tutorial.HelloWorld.getConstantY;

public class ParHomePage extends JFrame implements ActionListener {

    private String parUsername;
    ParShowNotificationController parShowNotificationController;

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
        showNotifications.setHorizontalAlignment(getConstantX()/2);

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

        this.add(title);
        this.add(showNotifications);
        this.add(account);
        this.add(upcomingEvent);
        this.add(pastEvent);
        this.add(followedOrg);
        this.add(logOut);

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
