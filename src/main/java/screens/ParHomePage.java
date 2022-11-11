package screens;

import javax.swing.*;

public class ParHomePage extends JFrame {

    private String parUsername;
    public ParHomePage(String parUsername){

        this.parUsername = parUsername;

        this.setLayout(null);

        this.setSize(500,500);

        this.setLocationRelativeTo(null);


        JLabel title = new JLabel(this.parUsername + "'s Home Page");
        title.setBounds (0,0, 500, 50);
        title.setHorizontalAlignment(JLabel.CENTER);

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
        account.addActionListener(new ParHomeActionListener(this));
        account.setBounds (350,0, 150, 30);

        this.add(title);
        this.add(account);
        this.add(upcomingEvent);
        this.add(pastEvent);
        this.add(followedOrg);
        this.add(logOut);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    public String getParUsername() { return this.parUsername;}

}
