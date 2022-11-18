package screens.par_upcoming_event;

import database.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static tutorial.HelloWorld.getConstantX;
import static tutorial.HelloWorld.getConstantY;

public class ParUpcomingEventPage extends JFrame {
    private final String parUsername;
    public ParUpcomingEventPage(String parUsername){
        this.parUsername = parUsername;

        this.setLayout(null);

        this.setSize(getConstantX(), getConstantY());

        this.setLocationRelativeTo(null);

        JLabel title = new JLabel(this.parUsername + "'s Upcoming Events Page");
        title.setBounds(0, 0, getConstantX(), 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        JButton back = new JButton("Back");
        back.addActionListener(new ParUpcomingEventActionListener(this));
        back.setBounds(0, 100, 150, 30);

        JPanel events = new JPanel();
        events.setBounds(150,100,getConstantX()-170,getConstantY()-150);

        EventDsGateway eventDsGateway = new EventFileUser();
        ParDsGateway parDsGateway = new ParFileUser();

        ArrayList<String> upcomingEvents = parDsGateway.getUpcomingEvents(parUsername);

        int numberOfEvent = upcomingEvents.size();

        if (numberOfEvent != 0) {

            events.setLayout(new GridLayout(numberOfEvent, 0, 10, 10));

            int x = 0;
            int y = 0;

            for (String upcomingEventTitle : upcomingEvents) {

                JButton eventTitle = new JButton(upcomingEventTitle);
                eventTitle.addActionListener(new ParUpcomingEventActionListener(this));
                eventTitle.setBounds(x, y, 250, 30);
                eventTitle.setVisible(true);

                ArrayList<Integer> times = eventDsGateway.getTime(upcomingEventTitle);
                String time = times.get(0) + " " + times.get(1) + "-" + times.get(2) + " " +
                        times.get(3) + ":" + times.get(4);

                JLabel eventTime = new JLabel(time);
                eventTime.setBounds(x + 20, y + 40, 250, 30);
                eventTime.setVisible(true);

                String location = eventDsGateway.getLocation(upcomingEventTitle);
                JLabel eventLocation = new JLabel(location);
                eventLocation.setBounds(x + 20, y + 70, 250, 30);
                eventLocation.setVisible(true);

                JButton leave = new JButton("Leave");
                leave.setActionCommand(upcomingEventTitle + "Leave");
                leave.addActionListener(new ParUpcomingEventActionListener(this));
                leave.setBounds(x + 250, y + 55, 100, 30);
                leave.setVisible(true);

                events.add(eventTitle);
                events.add(eventTime);
                events.add(eventLocation);
                events.add(leave);
                y += 100;
            }

            JScrollPane eventScroll = new JScrollPane(events);
            eventScroll.setBounds(150, 100, getConstantX()-170, getConstantY()-150);
            eventScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            eventScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            eventScroll.setVisible(true);
            this.add(eventScroll);
        }


        this.add(title);
        this.add(back);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    public String getParUsername() {
        return parUsername;
    }
}
