package controller_presenter_view.screens.org_upcoming_event;

import controller_presenter_view.common_controller_presenter.extract_information.ExtractInfoController;
import controller_presenter_view.screens.CommonMethod;
import database.OrgDsGateway;
import database.OrgFileUser;
import use_cases.extract_information_use_case.ExtractInfoInputBoundary;
import use_cases.extract_information_use_case.ExtractInfoInteractor;
import use_cases.extract_information_use_case.ExtractInfoResponseModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static controller_presenter_view.screens.ScreenConstants.getConstantX;
import static controller_presenter_view.screens.ScreenConstants.getConstantY;


public class OrgUpcomingEventPage extends JFrame {

    final String orgUsername;

    /**The method generate a page of organization's upcoming event.
     * It contains all upcoming events held by this organization and let the organization
     *      notify the participants or delete the Upcoming events.
     * After each of the event, there are two buttons.
     * -First is a "Notify" button, which the organization can send notification to all participants.
     *  After the notification sent, there will be a pop-up window says "Notification sent for" the event name
     *  or "No participant register for this event" if no participant register for it.
     * -Second is a "Delete" button, which the organization can delete the event and
     *  this event will no longer be inside the upcoming page.
     * There is a button "back" which directed the Organization back to the home page.
     *
     * @param orgUsername the username of the organization.
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public OrgUpcomingEventPage(String orgUsername) throws ClassNotFoundException {

        this.orgUsername = orgUsername;

        this.setLayout(null);

        this.setSize(getConstantX(), getConstantY());

        this.setLocationRelativeTo(null);
        //Initialize the title of the upcoming event page
        JLabel title = new JLabel(this.orgUsername + "'s Upcoming Event Page");
        title.setBounds(0, 0, getConstantX(), 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        //This is the back button
        JButton back = new JButton("Back");
        back.addActionListener(new OrgUpcomingEventActionListener(this));
        back.setBounds(0, 100, 150, 30);

        //Generate a JScrollPane of events and add it to the page
        generateEvents();

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

    /**This method will generate events in a JScrollPane and add the JScrollPane into the page.
     */
    public void generateEvents() throws ClassNotFoundException {
        JPanel events = new JPanel();
        events.setBounds(150,100,getConstantX()-170,getConstantY()-150);
        //get events' title from database
        OrgDsGateway o = new OrgFileUser();
        ExtractInfoInputBoundary interactor1= new ExtractInfoInteractor(o);
        ExtractInfoController controller1= new ExtractInfoController(interactor1);
        ExtractInfoResponseModel<String> response1= controller1.extractOrg("getUpcomingEvents",orgUsername);
        ArrayList<String> upcomingEvents = response1.getAl();

        //If there are no upcoming event, there will only be the title and back button, but no events.
        int numberOfEvent = upcomingEvents.size();
        if (numberOfEvent != 0) {
            events.setLayout(new GridLayout(numberOfEvent, 0, 10, 10));
            int x = 0;
            int y = 0;
            //When these code is running, there will be at least 1 event so this for loop will add the upcoming events, one
            //event at each loop.
            for (String upcomingEventTitle : upcomingEvents) {
                CommonMethod.setEventInfo(this, events, upcomingEventTitle, x, y, "OrgUpcomingEvent");
                events.add(create_JButton(upcomingEventTitle,"Notify", x + 250, y + 15, 100, 30));
                events.add(create_JButton(upcomingEventTitle,"Delete", x + 250, y + 55, 100, 30));
                y += 100;
            }
            //Put the JPanel into a JScrollPane
            JScrollPane eventScroll = CommonMethod.generateJScrollPane(events);
            this.add(eventScroll);
        }
    }

    /**This function returns a JButton with the input as set bounds
     *
     * @param eventTitle the event's title
     * @param text string of the button showing
     * @param x the integer x for set bounds
     * @param y the integer y for set bounds
     * @param width the integer representing the width for set bounds
     * @param height the integer representing the height for set bounds
     * @return return the JButton
     */
    public JButton create_JButton(String eventTitle, String text, int x, int y, int width, int height){
        JButton output = new JButton(text);
        output.setActionCommand(eventTitle + text);
        output.addActionListener(new OrgUpcomingEventActionListener(this));
        output.setBounds (x, y, width, height);
        return output;
    }
}