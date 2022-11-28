package controller_presenter_view.screens.org_upcoming_event;

import database.*;
import controller_presenter_view.common_controller_presenter.extract_information.ExtractInfoController;
import use_cases.extract_information_use_case.ExtractInfoInputBoundary;
import use_cases.extract_information_use_case.ExtractInfoInteractor;
import use_cases.extract_information_use_case.ExtractInfoResponseModel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

import static controller_presenter_view.screens.screen_constants.getConstantX;
import static controller_presenter_view.screens.screen_constants.getConstantY;


public class OrgUpcomingEventPage extends JFrame {

    String orgUsername;

    /**The method generate a page of organization's upcoming event.
     * It contains all upcoming events held by this organization and let the organization
     *      notify the participants or delete the Upcoming events.
     * After each of the event, there are two buttons.
     * -First is a "Notify" button, which the organization can send notification to all participants.
     *  After the notification sent, there will be a pop-up window says "Notification sent for" the event name
     *  or "No participant register for this event" if no participant register for it.
     * -Second is a "Delete" button, which the organiation can delete the event and
     *  this event will no longer be inside the upcoming page.
     * There is a button "back" which directed the Organization back to the home page.
     *
     * @param orgUsername the username of the organization.
     */
    public OrgUpcomingEventPage(String orgUsername) throws SQLException, ClassNotFoundException {

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
        back.addActionListener(new OrgUpcomingEventActionListener(this,orgUsername));
        back.setBounds(0, 100, 150, 30);

        JPanel events = new JPanel();
        events.setBounds(150,100,getConstantX()-170,getConstantY()-150);

        OrgDsGateway o = new OrgFileUser();
        EventDsGateway e = new EventFileUser();

        ExtractInfoInputBoundary interactor1= new ExtractInfoInteractor(o);
        ExtractInfoController controller1= new ExtractInfoController(interactor1);
        ExtractInfoResponseModel<String> response1= controller1.extractOrg("getUpcomingEvents",orgUsername);


        ArrayList<String> upcomingEvents = response1.getAl();

        //If there are no upcoming event, there will only be the title and back button, but no any events.
        int numberOfEvent = upcomingEvents.size();
        if (numberOfEvent == 0){
            this.add(title);
            this.add(back);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            this.setVisible(true);
            return;
        }
        events.setLayout(new GridLayout(numberOfEvent,0,10,10));

        int x = 0;
        int y = 0;

        //When these code is running, there will be at least 1 event so this for loop will add the upcoming events, one
        //event at each loop.
        for (String upcomingEventTitle : upcomingEvents) {

            JButton eventTitle = new JButton(upcomingEventTitle);
            eventTitle.addActionListener(new OrgUpcomingEventActionListener(this,orgUsername));
            eventTitle.setBounds (x, y, 250, 30);
            eventTitle.setVisible(true);

            //This will add the event title
            ExtractInfoInputBoundary interactor2= new ExtractInfoInteractor(e);
            ExtractInfoController controller2= new ExtractInfoController(interactor2);
            ExtractInfoResponseModel<Integer> response2= controller2.extractEventTime(upcomingEventTitle);


            //This will add event's time
            ArrayList<Integer> times = response2.getAl();
            String time = times.get(0) + " " + times.get(1) + "-" + times.get(2) + " " +
                    times.get(3) + ":" + times.get(4);

            JLabel eventTime = new JLabel(time);
            eventTime.setBounds (x+20, y+40, 250, 30);
            eventTime.setVisible(true);


            //This will add the event's location
            ExtractInfoInputBoundary interactor3= new ExtractInfoInteractor(e);
            ExtractInfoController controller3= new ExtractInfoController(interactor3);
            ExtractInfoResponseModel<String> response3= controller3.extractEvent("getLocation",
                    upcomingEventTitle);


            String location = response3.getStr();
            JLabel eventLocation = new JLabel(location);
            eventLocation.setBounds (x+20, y+70, 250, 30);
            eventLocation.setVisible(true);

            //This is the notify button
            JButton notify = new JButton("Notify");
            notify.setActionCommand(upcomingEventTitle + "Notify");
            notify.addActionListener(new OrgUpcomingEventActionListener(this,orgUsername));
            notify.setBounds (x+250, y+15, 100, 30);
            notify.setVisible(true);

            //This is the delete button
            JButton delete = new JButton("Delete");
            delete.setActionCommand(upcomingEventTitle + "Delete");
            delete.addActionListener(new OrgUpcomingEventActionListener(this,orgUsername));
            delete.setBounds (x+250, y+55, 100, 30);
            delete.setVisible(true);

            events.add(eventTitle);
            events.add(eventTime);
            events.add(eventLocation);
            events.add(notify);
            events.add(delete);
            y += 100;
        }

        JScrollPane eventScroll = new JScrollPane(events);
        eventScroll.setBounds(150, 100, getConstantX()-170,getConstantY()-150);
        eventScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        eventScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        eventScroll.setVisible(true);

        this.add(title);
        this.add(back);
        this.add(eventScroll);

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