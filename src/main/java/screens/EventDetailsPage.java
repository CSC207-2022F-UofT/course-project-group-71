package screens;


import javax.swing.*;

import static tutorial.HelloWorld.getConstantX;
import static tutorial.HelloWorld.getConstantY;

import database.EventDsGateway;
import database.EventFileUser;

import java.util.ArrayList;

public class EventDetailsPage extends JFrame {

    private String eventTitle;

    EventDsGateway eve = new EventFileUser();

    public EventDetailsPage(String eventTitle) {

        this.eventTitle = eventTitle;
        this.setSize(getConstantX() - 300, getConstantY() - 500);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        JLabel title = new JLabel("Event Details");
        title.setBounds(0, 0, getConstantX() - 300, 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel eventName = new JLabel("Event Title: " + this.eventTitle);
        JLabel description = new JLabel("Description: " + eve.getDescription(this.eventTitle));

        ArrayList<Integer> times = eve.getTime(this.eventTitle);
        JLabel time = new JLabel("Time: " + times.get(0) + " " + times.get(1) + "-" +
                times.get(2) +" "+times.get(3) + ":" + times.get(4));
        JLabel location = new JLabel("Location:"+eve.getLocation(this.eventTitle));
        panel.add(eventName);
        panel.add(description);
        panel.add(time);
        panel.add(location);
        panel.setBounds(50, 70, getConstantX() - 300, getConstantY() - 500);


        this.add(title);
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }


}
