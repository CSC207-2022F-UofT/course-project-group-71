package screens;

import javax.swing.*;

public class OrgHomePage extends JFrame {

    private String orgUsername;
    public OrgHomePage(String orgUsername){

        this.orgUsername = orgUsername;

        this.setLayout(null);

        this.setSize(500,500);

        this.setLocationRelativeTo(null);


        JLabel title = new JLabel(this.orgUsername + "'s Home Page");
        title.setBounds (0,0, 500, 50);
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
        account.addActionListener(new OrgHomeActionListener(this));
        account.setBounds (350,0, 150, 30);

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
