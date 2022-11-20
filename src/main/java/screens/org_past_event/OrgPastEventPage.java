package screens.org_past_event;


import database.EventDsGateway;
import database.EventFileUser;
import database.OrgDsGateway;
import database.OrgFileUser;
import extract_information_use_case.ExtractInfoController;
import extract_information_use_case.ExtractInfoInputBoundary;
import extract_information_use_case.ExtractInfoInteractor;
import extract_information_use_case.ExtractInfoResponseModel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

import static tutorial.HelloWorld.getConstantX;
import static tutorial.HelloWorld.getConstantY;

public class OrgPastEventPage extends JFrame {
    private final String orgUsername;

    /**The method generate a page of organization's past event.
     * It contains all past events held by this organization and let the organization to delete specific past event.
     * After each of the event, there is a delete button for organization to delete the specific past event.
     * There is a button "back" which directed the Organization back to the home page.
     *
     * @param orgUsername the username of the organization.
     */
    public OrgPastEventPage(String orgUsername) throws SQLException, ClassNotFoundException {
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

        OrgDsGateway o = new OrgFileUser();
        EventDsGateway e = new EventFileUser();

        ExtractInfoInputBoundary interactor1= new ExtractInfoInteractor(o);
        ExtractInfoController controller1= new ExtractInfoController(interactor1);
        ExtractInfoResponseModel<String> response1= controller1.extractOrg("getPastEvents",this.orgUsername);

        ArrayList<String> pastEvents = response1.getAl();

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

                ExtractInfoInputBoundary interactor2= new ExtractInfoInteractor(e);
                ExtractInfoController controller2= new ExtractInfoController(interactor2);
                ExtractInfoResponseModel<Integer> response2= controller2.extractEventTime(unpublishedEventTitle);

                ArrayList<Integer> times = response2.getAl();
                String time = times.get(0) + " " + times.get(1) + "-" + times.get(2) + " " +
                        times.get(3) + ":" + times.get(4);

                JLabel eventTime = new JLabel(time);
                eventTime.setBounds(x + 20, y + 40, 250, 30);
                eventTime.setVisible(true);

                ExtractInfoInputBoundary interactor3= new ExtractInfoInteractor(e);
                ExtractInfoController controller3= new ExtractInfoController(interactor3);
                ExtractInfoResponseModel<String> response3= controller3.extractEvent("getLocation",
                        unpublishedEventTitle);

                String location = response3.getStr();
                JLabel eventLocation = new JLabel(location);
                eventLocation.setBounds(x + 20, y + 70, 250, 30);
                eventLocation.setVisible(true);

                JButton delete = new JButton("Delete");
                delete.setActionCommand(unpublishedEventTitle + "Delete");
                delete.addActionListener(new OrgPastEventActionListener(this));
                delete.setBounds(x + 250, y + 55, 100, 30);
                delete.setVisible(true);

                events.add(eventTitle);
                events.add(eventTime);
                events.add(eventLocation);
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
    /**The method returns organization's Username.
     * @return it will return a string which is organization's username.
     */
    public String getOrgUsername() {
        return orgUsername;
    }
}
