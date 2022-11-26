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
        //Initialize the page
        this.setLayout(null);
        this.setSize(getConstantX(), getConstantY());
        this.setLocationRelativeTo(null);

        //Insert the page title
        JLabel title = new JLabel(this.orgUsername + "'s Past Event Page");
        title.setBounds(0, 0, getConstantX(), 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        //Create the back button
        JButton back = new JButton("Back");
        back.addActionListener(new OrgPastEventActionListener(this));
        back.setBounds(0, 100, 150, 30);

        //Generate a JPanel to put events
        JPanel events = new JPanel();
        events.setBounds(150,100,getConstantX()-170,getConstantY()-150);

        //Initialize the DsGateways
        OrgDsGateway o = new OrgFileUser();
        EventDsGateway e = new EventFileUser();


        ExtractInfoInputBoundary interactor1= new ExtractInfoInteractor(o);
        ExtractInfoController controller1= new ExtractInfoController(interactor1);
        ExtractInfoResponseModel<String> response1= controller1.extractOrg("getPastEvents",this.orgUsername);

        ArrayList<String> pastEvents = response1.getAl();

        int numberOfEvent = pastEvents.size();

        if (numberOfEvent != 0) {
            //Initialise a part of page to show the information of one past event
            events.setLayout(new GridLayout(numberOfEvent, 0, 10, 10));
            int x = 0;
            int y = 0;

            //Add all cards of past events to the page
            for (String unpublishedEventTitle : pastEvents) {
                //Prepare the event title
                JButton eventTitle = new JButton(unpublishedEventTitle);
                eventTitle.addActionListener(new OrgPastEventActionListener(this));
                eventTitle.setBounds(x, y, 250, 30);
                eventTitle.setVisible(true);
                //Prepare the interactor, controller and response model for each past events
                ExtractInfoInputBoundary interactor2= new ExtractInfoInteractor(e);
                ExtractInfoController controller2= new ExtractInfoController(interactor2);
                ExtractInfoResponseModel<Integer> response2= controller2.extractEventTime(unpublishedEventTitle);

                //Obtain the time
                ArrayList<Integer> times = response2.getAl();
                String time = times.get(0) + " " + times.get(1) + "-" + times.get(2) + " " +
                        times.get(3) + ":" + times.get(4);

                //Prepare the time label
                JLabel eventTime = new JLabel(time);
                eventTime.setBounds(x + 20, y + 40, 250, 30);
                eventTime.setVisible(true);

                //Prepare teh interactor, controller and controller for extracting information of each past events
                ExtractInfoInputBoundary interactor3= new ExtractInfoInteractor(e);
                ExtractInfoController controller3= new ExtractInfoController(interactor3);
                ExtractInfoResponseModel<String> response3= controller3.extractEvent("getLocation",
                        unpublishedEventTitle);

                String location = response3.getStr();
                JLabel eventLocation = new JLabel(location);
                eventLocation.setBounds(x + 20, y + 70, 250, 30);
                eventLocation.setVisible(true);

                //Add all the prepared events back to the page
                events.add(eventTitle);
                events.add(eventTime);
                events.add(eventLocation);
                y += 100;
            }

            //Set parameters for JScrollPane
            JScrollPane eventScroll = new JScrollPane(events);
            eventScroll.setBounds(150, 100, getConstantX() - 170, getConstantY() - 150);
            eventScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            eventScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            eventScroll.setVisible(true);
            this.add(eventScroll);
        }
        //Add title and back button to the page
        this.add(title);
        this.add(back);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    /**The method returns organization's Username.
     * @return it will return a string which is organization's username.
     */
    public String getOrgUsername() {
        //Return the username of the organizer
        return orgUsername;
    }
}
