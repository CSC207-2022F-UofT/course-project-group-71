package screens.org_past_event;


import controllers.ExtractInfoController;
import database.OrgDsGateway;
import database.OrgFileUser;
import screens.UICreatorAssistant;
import use_cases.extract_information_use_case.ExtractInfoInputBoundary;
import use_cases.extract_information_use_case.ExtractInfoInteractor;
import use_cases.extract_information_use_case.ExtractInfoResponseModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static screens.ScreenConstants.getConstantX;
import static screens.ScreenConstants.getConstantY;


public class OrgPastEventPage extends JFrame {
    private final String orgUsername;

    /**The method generate a page of organization's past event.
     * It contains all past events held by this organization and let the organization delete specific past event.
     * After each of the event, there is a delete button for organization to delete the specific past event.
     * There is a button "back" which directed the Organization back to the home page.
     *
     * @param orgUsername the username of the organization.
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public OrgPastEventPage(String orgUsername) throws ClassNotFoundException {
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

        //Generate a JScrollPane of events and add it to the page
        generateEvents();

        //Add title and back button to the page
        this.add(title);
        this.add(back);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**This method will be called in OrgPastEventActionListener.
     * @return it will return a string which is organization's username.
     */
    public String getOrgUsername() {
        //Return the username of the organizer
        return orgUsername;
    }

    /**This method will generate events in a JScrollPane and add the JScrollPane into the page.
     */
    public void generateEvents() throws ClassNotFoundException {
        //Get events' title from database
        JPanel events = new JPanel();
        events.setBounds(150,100,getConstantX()-170,getConstantY()-150);
        OrgDsGateway o = new OrgFileUser();
        ExtractInfoInputBoundary interactor1 = new ExtractInfoInteractor(o);
        ExtractInfoController controller1 = new ExtractInfoController(interactor1);
        ExtractInfoResponseModel<String> response1 = controller1.extractOrg("getPastEvents", this.orgUsername);
        ArrayList<String> pastEvents = response1.getAl();

        int numberOfEvent = pastEvents.size();
        if (numberOfEvent != 0) {
            //Initialise a part of page to show the information of one past event
            events.setLayout(new GridLayout(numberOfEvent, 0, 10, 10));
            int x = 0;
            int y = 0;
            //Add all cards of past events to the page
            for (String pastEventTitle : pastEvents) {
                UICreatorAssistant.setEventInfo(this, events, pastEventTitle, x, y, "OrgPastEvent");
                y += 100;
            }
            //Set parameters for JScrollPane
            JScrollPane eventScroll = UICreatorAssistant.generateJScrollPane(events);
            this.add(eventScroll);
        }
        else {
            this.add(UICreatorAssistant.create_JLabel("None", 0,100, getConstantX(),30));
        }
    }
}
