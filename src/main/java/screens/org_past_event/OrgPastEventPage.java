package screens.org_past_event;


import database.EventDsGateway;
import database.EventFileUser;
import database.OrgDsGateway;
import database.OrgFileUser;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static tutorial.HelloWorld.getConstantX;
import static tutorial.HelloWorld.getConstantY;

public class OrgPastEventPage extends JFrame {
    private String orgUsername;
    public OrgPastEventPage(String orgUsername){
        this.orgUsername = orgUsername;

        this.setLayout(null);

        this.setSize(getConstantX(), getConstantY());

        this.setLocationRelativeTo(null);

        JLabel title = new JLabel(this.orgUsername + "'s Past Event Page");
        title.setBounds(0, 0, getConstantX(), 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        JButton back = new JButton("Back");
        back.addActionListener(new OrgPastEventActionListener(this));
        back.setBounds(0, 100, 150, 30);

        JPanel events = new JPanel();
        events.setBounds(150,100,getConstantX()-170,getConstantY()-150);

        OrgDsGateway orgDsGateway = new OrgFileUser();
        EventDsGateway eventDsGateway = new EventFileUser();

        ArrayList<String> pastEvents = orgDsGateway.getPastEvents(orgUsername);

        int numberOfEvent = pastEvents.size();

        if (numberOfEvent != 0) {

            events.setLayout(new GridLayout(numberOfEvent, 0, 10, 10));

            int x = 0;
            int y = 0;

            for (String unpublishedEventTitle : pastEvents) {

                JButton eventTitle = new JButton(unpublishedEventTitle);
                eventTitle.addActionListener(new OrgPastEventActionListener(this));
                eventTitle.setBounds(x, y, 250, 30);
                eventTitle.setVisible(true);

                ArrayList<Integer> times = eventDsGateway.getTime(unpublishedEventTitle);
                String time = times.get(0) + " " + times.get(1) + "-" + times.get(2) + " " +
                        times.get(3) + ":" + times.get(4);

                JLabel eventTime = new JLabel(time);
                eventTime.setBounds(x + 20, y + 40, 250, 30);
                eventTime.setVisible(true);

                String location = eventDsGateway.getLocation(unpublishedEventTitle);
                JLabel eventLocation = new JLabel(location);
                eventLocation.setBounds(x + 20, y + 70, 250, 30);
                eventLocation.setVisible(true);

//                JButton notify = new JButton("Notify");
//                notify.setActionCommand(unpublishedEventTitle + "Notify");
//                notify.addActionListener(new OrgPastEventActionListener(this));
//                notify.setBounds(x + 250, y + 15, 100, 30);
//                notify.setVisible(true);

                JButton delete = new JButton("Delete");
                delete.setActionCommand(unpublishedEventTitle + "Delete");
                delete.addActionListener(new OrgPastEventActionListener(this));
                delete.setBounds(x + 250, y + 55, 100, 30);
                delete.setVisible(true);

                events.add(eventTitle);
                events.add(eventTime);
                events.add(eventLocation);
//                events.add(notify);
                events.add(delete);
                y += 100;
            }

            JScrollPane eventScroll = new JScrollPane(events);
            eventScroll.setBounds(150, 100, getConstantX() - 170, getConstantY() - 150);
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

    public String getOrgUsername() {
        return orgUsername;
    }
}