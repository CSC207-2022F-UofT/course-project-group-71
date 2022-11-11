package screens.org_upcoming_event;

import database.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OrgUpcomingEventPage extends JFrame {

    private String orgUsername;

    public OrgUpcomingEventPage(String orgUsername) {

        this.orgUsername = orgUsername;

        this.setLayout(null);

        this.setSize(800, 800);

        this.setLocationRelativeTo(null);

        JLabel title = new JLabel(this.orgUsername + "'s Upcoming Event Page");
        title.setBounds(0, 0, 500, 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        JButton back = new JButton("Back");
        back.addActionListener(new OrgUpcomingEventActionListener(this));
        back.setBounds(0, 100, 150, 30);

        JPanel events = new JPanel();
        events.setBounds(150,100,500,300);

        OrgDsGateway orgDsGateway = new OrgFileUser();
        EventDsGateway eventDsGateway = new EventFileUser();

        ArrayList<String> upcomingEvents = orgDsGateway.getUpcomingEvents(orgUsername);

        int numberOfEvent = upcomingEvents.size();

        events.setLayout(new GridLayout(numberOfEvent,0,0,10));

        int eventx = 0;
        int eventy = 0;
        int x = 0;
        int y = 0;

        for (String upcomingEventTitle : upcomingEvents) {
            JPanel event = new JPanel();
            event.setLayout(null);
            event.setBounds (eventx, eventy, 350, 100);


            JButton eventTitle = new JButton(upcomingEventTitle);
            eventTitle.addActionListener(new OrgUpcomingEventActionListener(this));
            eventTitle.setBounds (x, y, 250, 30);
            eventTitle.setVisible(true);

            ArrayList<Integer> times = eventDsGateway.getTime(upcomingEventTitle);
            String time = times.get(0) + " " + times.get(1) + "-" + times.get(2) + " " +
                    times.get(3) + ":" + times.get(4);

            JLabel eventTime = new JLabel(time);
            eventTime.setBounds (x+20, y+40, 250, 30);
            eventTime.setVisible(true);

            String location = eventDsGateway.getLocation(upcomingEventTitle);
            JLabel eventLocation = new JLabel(location);
            eventLocation.setBounds (x+20, y+70, 250, 30);
            eventLocation.setVisible(true);

            JButton notify = new JButton("Notify");
            notify.setActionCommand(upcomingEventTitle + "Notify");
            notify.addActionListener(new OrgUpcomingEventActionListener(this));
            notify.setBounds (x+250, y+15, 100, 30);
            notify.setVisible(true);

            JButton delete = new JButton("Delete");
            delete.setActionCommand(upcomingEventTitle + "Delete");
            delete.addActionListener(new OrgUpcomingEventActionListener(this));
            delete.setBounds (x+250, y+55, 100, 30);
            delete.setVisible(true);

            event.add(eventTitle);
            event.add(eventTime);
            event.add(eventLocation);
            event.add(notify);
            event.add(delete);

            event.setBorder(BorderFactory.createLineBorder(Color.white));
            event.setVisible(true);

            events.add(event);
            eventy += 100;
        }

        JScrollPane eventScroll = new JScrollPane(events);
        eventScroll.setBounds(150, 100, 500, 300);
        eventScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        eventScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        eventScroll.setVisible(true);



        this.add(title);
        this.add(back);
        this.add(eventScroll);
        //this.add(events);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    public String getOrgUsername() {
        return orgUsername;
    }
}