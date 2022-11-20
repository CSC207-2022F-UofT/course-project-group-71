package screens;



import database.EventDsGateway;
import database.EventFileUser;
import database.OrgDsGateway;
import database.OrgFileUser;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;


import static tutorial.HelloWorld.getConstantX;
import static tutorial.HelloWorld.getConstantY;


public class OrgDetailsPage extends JFrame {

    private String orgName;


    OrgDsGateway org = new OrgFileUser();
    EventDsGateway eve = new EventFileUser();


    public OrgDetailsPage(String orgName) throws SQLException, ClassNotFoundException {

        this.orgName = orgName;
        this.setSize(getConstantX() - 300, getConstantY() - 500);
        this.setLayout(null);
        this.setLocationRelativeTo(null);


        JLabel title = new JLabel("Event Details");
        title.setBounds(0, 0, getConstantX() - 300, 50);
        title.setHorizontalAlignment(JLabel.CENTER);


        JLabel orgTitle = new JLabel("Organizer Name: " + this.orgName);
        orgTitle.setBounds(0, 50, getConstantX() - 300, 50);
        orgTitle.setHorizontalAlignment(JLabel.CENTER);
        JLabel upcoming = new JLabel("Upcoming Events for " + this.orgName);
        upcoming.setBounds(0, 100, getConstantX() - 300, 50);
        upcoming.setHorizontalAlignment(JLabel.CENTER);

        ArrayList<String> orgUpcomingEvents = org.getUpcomingEvents(this.orgName);
        System.out.println(orgUpcomingEvents);

        JPanel panel=new JPanel();
        panel.setBounds(100,150,200,100);
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        for (String eventTitle : orgUpcomingEvents) {
            JLabel event = new JLabel(eventTitle);
            panel.add(event);
        }
        JScrollPane scroll = new JScrollPane(panel);

        scroll.setLayout(new ScrollPaneLayout());
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(100, 150, 300, 100);

        this.add(title);
        this.add(orgTitle);
        this.add(upcoming);
        this.add(scroll);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }


}
