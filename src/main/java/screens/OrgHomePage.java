package screens;

import javax.swing.*;

import static tutorial.HelloWorld.getConstantX;
import static tutorial.HelloWorld.getConstantY;

public class OrgHomePage extends JFrame {

    private String orgUsername;
    public OrgHomePage(String orgUsername){

        this.orgUsername = orgUsername;

        this.setLayout(null);

        this.setSize(getConstantX(),getConstantY());

        this.setLocationRelativeTo(null);


        JLabel title = new JLabel(this.orgUsername + "'s Home Page");
        title.setBounds (0,0, getConstantX(), 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        JButton account = new JButton("Account");
        account.addActionListener(new OrgHomeActionListener(this));
        account.setBounds (0,100, 150, 30);

        JButton unpublishedEvent = new JButton("Unpublished Event");
        unpublishedEvent.addActionListener(new OrgHomeActionListener(this));
        unpublishedEvent.setBounds (0,150, 150, 30);

        JButton upcomingEvent = new JButton("Upcoming Event");
        upcomingEvent.addActionListener(new OrgHomeActionListener(this));
        upcomingEvent.setBounds (0,180, 150, 30);

        JButton pastEvent = new JButton("Past Event");
        pastEvent.addActionListener(new OrgHomeActionListener(this));
        pastEvent.setBounds (0,210, 150, 30);

        JButton follower = new JButton("Follower");
        follower.addActionListener(new OrgHomeActionListener(this));
        follower.setBounds (0,240, 150, 30);

        JButton logOut = new JButton("Log Out");
        logOut.addActionListener(new OrgHomeActionListener(this));
        logOut.setBounds (0,320, 150, 30);

        this.add(title);
        this.add(account);
        this.add(unpublishedEvent);
        this.add(upcomingEvent);
        this.add(pastEvent);
        this.add(follower);
        this.add(logOut);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    public String getOrgUsername() { return this.orgUsername;}

}
