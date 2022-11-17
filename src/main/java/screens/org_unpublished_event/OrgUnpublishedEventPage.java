package screens.org_unpublished_event;


import database.EventDsGateway;
import database.EventFileUser;
import database.OrgDsGateway;
import database.OrgFileUser;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static tutorial.HelloWorld.getConstantX;
import static tutorial.HelloWorld.getConstantY;

public class OrgUnpublishedEventPage extends JFrame {
    private String orgUsername;
    public OrgUnpublishedEventPage(String orgUsername){
        this.orgUsername = orgUsername;

        this.setLayout(null);

        this.setSize(getConstantX(), getConstantY());

        this.setLocationRelativeTo(null);

        JLabel title = new JLabel(this.orgUsername + "'s Unpublished Event Page");
        title.setBounds(0, 0, getConstantX(), 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        JButton back = new JButton("Back");
        back.addActionListener(new OrgUnpublishedEventActionListener(this));
        back.setBounds(0, 100, 150, 30);

        JButton create = new JButton("Create An Event");
        create.addActionListener(new OrgUnpublishedEventActionListener(this));
        create.setBounds(0,150,150,30);

        JPanel events = new JPanel();
        events.setBounds(150,100,getConstantX()-170,getConstantY()-150);

        OrgDsGateway orgDsGateway = new OrgFileUser();
        EventDsGateway eventDsGateway = new EventFileUser();

        ArrayList<String> unpublishedEvents = orgDsGateway.getUnpublishedEvents(orgUsername);

        int numberOfEvent = unpublishedEvents.size();

        if (numberOfEvent != 0) {

            events.setLayout(new GridLayout(numberOfEvent, 0, 10, 10));

            int x = 0;
            int y = 0;

            for (String unpublishedEventTitle : unpublishedEvents) {

                JButton eventTitle = new JButton(unpublishedEventTitle);
                eventTitle.addActionListener(new OrgUnpublishedEventActionListener(this));
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

                JButton publish = new JButton("Publish");
                publish.setActionCommand(unpublishedEventTitle + "Publish");
                publish.addActionListener(new OrgUnpublishedEventActionListener(this));
                publish.setBounds(x + 250, y + 15, 100, 30);
                publish.setVisible(true);

                JButton notify = new JButton("Edit");
                notify.setActionCommand(unpublishedEventTitle + "Edit");
                notify.addActionListener(new OrgUnpublishedEventActionListener(this));
                notify.setBounds(x + 250, y + 15, 100, 30);
                notify.setVisible(true);

                JButton delete = new JButton("Delete");
                delete.setActionCommand(unpublishedEventTitle + "Delete");
                delete.addActionListener(new OrgUnpublishedEventActionListener(this));
                delete.setBounds(x + 250, y + 55, 100, 30);
                delete.setVisible(true);

                events.add(eventTitle);
                events.add(eventTime);
                events.add(eventLocation);
                events.add(publish);
                events.add(notify);
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
        this.add(create);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    public String getOrgUsername() {
        return orgUsername;
    }
}
