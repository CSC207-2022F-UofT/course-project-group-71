package controller_presenter_view.screens.org_unpublished_event;


import controller_presenter_view.screens.Util_Method;
import database.EventDsGateway;
import database.EventFileUser;
import database.OrgDsGateway;
import database.OrgFileUser;
import controller_presenter_view.common_controller_presenter.extract_information.ExtractInfoController;
import use_cases.extract_information_use_case.ExtractInfoInputBoundary;
import use_cases.extract_information_use_case.ExtractInfoInteractor;
import use_cases.extract_information_use_case.ExtractInfoResponseModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static controller_presenter_view.screens.screen_constants.getConstantX;
import static controller_presenter_view.screens.screen_constants.getConstantY;


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

        //Prepare the JPanel for showing events
        JPanel events = new JPanel();
        events.setBounds(150, 100, getConstantX() - 170, getConstantY() - 150);
        generateEvents(events);

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

    /**This method will generate events to fit into the JPanel events
     *
     * @param events A JPanel that is designed to contain events
     */
    public void generateEvents(JPanel events){
        //Initialise the DsGateways
        OrgDsGateway o = new OrgFileUser();
        EventDsGateway e = new EventFileUser();

        ExtractInfoInputBoundary interactor1 = new ExtractInfoInteractor(o);
        ExtractInfoController controller1 = new ExtractInfoController(interactor1);
        ExtractInfoResponseModel<String> response1;
        try {
            response1 = controller1.extractOrg("getUnpublishedEvents",
                    this.orgUsername);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }


        ArrayList<String> unpublishedEvents = response1.getAl();

        int numberOfEvent = unpublishedEvents.size();

        //Branch with more than 1 event, it will show an information fragment with a scrolling bar
        if (numberOfEvent != 0) {

            events.setLayout(new GridLayout(numberOfEvent, 0, 10, 10));

            //Initialise the parameters
            int x = 0;
            int y = 0;

            //Generate information cards for each unpublished events
            for (String unpublishedEventTitle : unpublishedEvents) {
                //Prepare the event title
                JButton eventTitle = new JButton(unpublishedEventTitle);
                //Set the action listener to show the detailed event information when clicking the event title
                eventTitle.addActionListener(new OrgUnpublishedEventActionListener(this));
                eventTitle.setBounds(x, y, 250, 30);
                eventTitle.setVisible(true);

                ExtractInfoInputBoundary interactor2 = new ExtractInfoInteractor(e);
                ExtractInfoController controller2 = new ExtractInfoController(interactor2);
                ExtractInfoResponseModel<Integer> response2;
                try {
                    response2 = controller2.extractEventTime(unpublishedEventTitle);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                //Obtain the times
                ArrayList<Integer> times = response2.getAl();
                String time = times.get(0) + " " + times.get(1) + "-" + times.get(2) + " " +
                        times.get(3) + ":" + times.get(4);

                //Get the time to show on the screen
                JLabel eventTime = new JLabel(time);
                eventTime.setBounds(x + 20, y + 40, 250, 30);
                eventTime.setVisible(true);

                //Prepare the interactor, controller and response model
                ExtractInfoInputBoundary interactor3 = new ExtractInfoInteractor(e);
                ExtractInfoController controller3 = new ExtractInfoController(interactor3);
                ExtractInfoResponseModel<String> response3;
                try {
                    response3 = controller3.extractEvent("getLocation",
                            unpublishedEventTitle);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                //Get and show the information of location
                String location = response3.getStr();
                JLabel eventLocation = new JLabel(location);
                eventLocation.setBounds(x + 20, y + 70, 250, 30);
                eventLocation.setVisible(true);

                //Add a button for "Publish"
                JButton publish = new JButton("Publish");
                publish.setActionCommand(unpublishedEventTitle + "Publish");
                //Set the action listener to respond when user clicks "Publish" for this event
                publish.addActionListener(new OrgUnpublishedEventActionListener(this));
                publish.setBounds(x + 250, y + 15, 100, 30);
                publish.setVisible(true);

                //Add a button for "Edit"
                JButton notify = new JButton("Edit");
                notify.setActionCommand(unpublishedEventTitle + "Edit");
                //Set the action listener to respond when user clicks "Edit" for this event
                notify.addActionListener(new OrgUnpublishedEventActionListener(this));
                notify.setBounds(x + 250, y + 15, 100, 30);
                notify.setVisible(true);

                //Add a button for "Delete"
                JButton delete = new JButton("Delete");
                delete.setActionCommand(unpublishedEventTitle + "Delete");
                //Set the action listener to respond when user clicks "Delete" for this event
                delete.addActionListener(new OrgUnpublishedEventActionListener(this));
                delete.setBounds(x + 250, y + 55, 100, 30);
                delete.setVisible(true);

                //Add the above events on the page
                events.add(eventTitle);
                events.add(eventTime);
                events.add(eventLocation);
                events.add(publish);
                events.add(notify);
                events.add(delete);
                y += 100;
            }

            //Put the JPanel into a JScrollPane
            JScrollPane eventScroll = Util_Method.generateJScrollPane(events);
            eventScroll.setVisible(true);
            this.add(eventScroll);
        }

    }
}
