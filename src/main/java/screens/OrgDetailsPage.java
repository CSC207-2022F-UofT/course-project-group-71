package screens;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;

import database.EventDsGateway;
import database.EventFileUser;
import database.OrgDsGateway;
import database.OrgFileUser;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import static tutorial.HelloWorld.getConstantX;
import static tutorial.HelloWorld.getConstantY;


public class OrgDetailsPage extends JFrame {

    private String orgName;


    OrgDsGateway org = new OrgFileUser();
    EventDsGateway eve= new EventFileUser();



    public OrgDetailsPage(String orgName) throws SQLException, ClassNotFoundException {

        this.orgName = orgName;
        this.setSize(getConstantX() - 300, getConstantY() - 500);
        this.setLayout(null);
        this.setLocationRelativeTo(null);


        JLabel title = new JLabel("Event Details");
        title.setBounds(0, 0, getConstantX() - 300, 50);
        title.setHorizontalAlignment(JLabel.CENTER);


        JLabel orgTitle = new JLabel("Organizer Name: " + this.orgName);
        orgTitle.setBounds(0,50,getConstantX() - 300, 50);
        orgTitle.setHorizontalAlignment(JLabel.CENTER);
        JLabel upcoming= new JLabel("Recent 3 Upcoming Events for "+ this.orgName);
        upcoming.setBounds(0, 100, getConstantX() - 300, 50);
        upcoming.setHorizontalAlignment(JLabel.CENTER);

        ArrayList<String> orgUpcomingEvents= org.getUpcomingEvents(this.orgName);
        System.out.println(orgUpcomingEvents);
        ArrayList<LocalDateTime> compareTime= new ArrayList<>();
        HashMap<LocalDateTime,String> map= new HashMap<>();
       for(String event: orgUpcomingEvents) {

           ArrayList<Integer> times = eve.getTime(event);
           LocalDateTime time = LocalDateTime.of(times.get(0), times.get(1), times.get(2),
                   times.get(3), times.get(4));
           map.put(time, event);
           compareTime.add(time);
       }

        Collections.sort(compareTime);


        JLabel time1= new JLabel("1."+map.get(compareTime.get(0))+" Time: "+compareTime.get(0));
        JLabel time2= new JLabel("2."+ map.get(compareTime.get(1))+" Time: "+compareTime.get(1));
        JLabel time3= new JLabel("3."+ map.get(compareTime.get(2))+" Time: "+compareTime.get(2));
        JPanel panel= new JPanel();
        panel.add(time1);
        panel.add(time2);
        panel.add(time3);
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBounds(150, 150, getConstantX() - 300, getConstantY() - 500);



        this.add(title);
        this.add(orgTitle);
        this.add(upcoming);
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new OrgDetailsPage("sexy");


    }



}
