package controller_presenter_view.screens.org_unpublished_event;


import controller_presenter_view.screens.CommonMethod;
import database.OrgDsGateway;
import database.OrgFileUser;
import controller_presenter_view.common_controller_presenter.extract_information.ExtractInfoController;
import use_cases.extract_information_use_case.ExtractInfoInputBoundary;
import use_cases.extract_information_use_case.ExtractInfoInteractor;
import use_cases.extract_information_use_case.ExtractInfoResponseModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static controller_presenter_view.screens.ScreenConstants.getConstantX;
import static controller_presenter_view.screens.ScreenConstants.getConstantY;


public class OrgUnpublishedEventPage extends JFrame {
    private final String orgUsername;

    /**
     * The method generate a page of organization's unpublished event.
     * It let the organization create new an unpublished event and contains all unpublished events held by this
     * organization and let the organization publish, edit or delete specific events.
     * There is a button "create new events" on the top which will pop up a window of create event.
     * After each of the event, there are three buttons.
     * -First is a "Publish" button, which the organization can publish the event and let participants join it.
     * The event will disappear in this unpublished page and appear in the published page.
     * -Second is an "Edit" button, which the organization can keep editing this event, and it will switch to the edit event page.
     * -Third is a "Delete" button, which the organization can delete the event and event will no longer be inside the unpublished page.
     * There is a button "back" which directed the Organization back to the home page.
     *
     * @param orgUsername the username of the organization.
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public OrgUnpublishedEventPage(String orgUsername) throws ClassNotFoundException {
        this.orgUsername = orgUsername;

        //Initialize the page
        this.setLayout(null);
        this.setSize(getConstantX(), getConstantY());
        this.setLocationRelativeTo(null);

        //Prepare and set the title of the page
        JLabel title = new JLabel(this.orgUsername + "'s Unpublished Event Page");
        title.setBounds(0, 0, getConstantX(), 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        //Prepare the "Back" button
        JButton back = new JButton("Back");
        back.addActionListener(new OrgUnpublishedEventActionListener(this));
        back.setBounds(0, 100, 150, 30);

        //Prepare the "Create an event" button
        JButton create = new JButton("Create An Event");
        create.addActionListener(new OrgUnpublishedEventActionListener(this));

        JPanel button = new JPanel();
        button.add(create);
        button.setBounds(0, 50, getConstantX(), 40);

        //Generate a JScrollPane of events and add it to the page
        generateEvents();

        //Add title and buttons on the page
        this.add(title);
        this.add(back);
        this.add(button);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * This method will be called in OrgUnpublishedEventActionListener.
     *
     * @return it will return a string which is organization's username.
     */
    public String getOrgUsername() {
        //Return the username of the organizer
        return orgUsername;
    }

    /**This method will generate events in a JScrollPane and add the JScrollPane into the page.
     */
    public void generateEvents() throws ClassNotFoundException {
        //Prepare the JPanel for showing events
        JPanel events = new JPanel();
        events.setBounds(150, 100, getConstantX() - 170, getConstantY() - 150);
        //Get events' title from database
        OrgDsGateway o = new OrgFileUser();
        ExtractInfoInputBoundary interactor1 = new ExtractInfoInteractor(o);
        ExtractInfoController controller1 = new ExtractInfoController(interactor1);
        ExtractInfoResponseModel<String> response1= controller1.extractOrg("getUnpublishedEvents",
                    this.orgUsername);
        ArrayList<String> unpublishedEvents = response1.getAl();

        int numberOfEvent = unpublishedEvents.size();
        if (numberOfEvent != 0) {
            events.setLayout(new GridLayout(numberOfEvent, 0, 10, 10));
            //Initialise the parameters
            int x = 0;
            int y = 0;
            //Generate information cards for each unpublished events
            for (String unpublishedEventTitle : unpublishedEvents) {
                CommonMethod.setEventInfo(this, events, unpublishedEventTitle, x, y, "OrgUnpublishedEvent");
                events.add(create_JButton(unpublishedEventTitle,"Publish", x + 250, y + 15, 100, 30));
                events.add(create_JButton(unpublishedEventTitle,"Notify", x + 250, y + 15, 100, 30));
                events.add(create_JButton(unpublishedEventTitle,"Delete", x + 250, y + 55, 100, 30));
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
        output.addActionListener(new OrgUnpublishedEventActionListener(this));
        output.setBounds (x, y, width, height);
        return output;
    }
}
