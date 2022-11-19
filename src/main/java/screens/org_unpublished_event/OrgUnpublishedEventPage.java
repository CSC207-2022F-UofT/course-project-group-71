package screens.org_unpublished_event;


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

public class OrgUnpublishedEventPage extends JFrame {
    private final String orgUsername;
    /**The method generate a page of organization's unpublished event.
     * It let the organization create new a unpublished event and contains all unpublished events held by this
     *       organization and let the organization publish, edit or delete specific events.
     * There is a button "create new events" on the top which jump to the create event page.
     * After each of the event, there are three buttons.
     * -First is a "Publish" button, which the organization can publish the event and let participants join it.
     *  The event will disappear in this unpublished page and appear in the published page.
     * -Second is an "Edit" button, which the organization can keep editing this event and it will switch to the edit event page.
     * -Third is a "Delete" button, which the organiation can delete the event and event will no longer be inside the unpublished page.
     * There is a button "back" which directed the Organization back to the home page.
     *
     * @param orgUsername the username of the organization.
     */
    public OrgUnpublishedEventPage(String orgUsername) throws SQLException, ClassNotFoundException {
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

        JPanel button = new JPanel();
        button.add(create);
        button.setBounds(0,50, getConstantX(),40);

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
        this.add(button);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }
    /**The method returns organization's Username.
     * @return it will return a string which is organization's username.
     */
    public String getOrgUsername() {
        return orgUsername;
    }
}
