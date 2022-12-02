package controller_presenter_view.screens.par_upcoming_event;

import controller_presenter_view.screens.CommonMethod;
import database.*;
import controller_presenter_view.common_controller_presenter.extract_information.ExtractInfoController;
import use_cases.extract_information_use_case.ExtractInfoInputBoundary;
import use_cases.extract_information_use_case.ExtractInfoInteractor;
import use_cases.extract_information_use_case.ExtractInfoResponseModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static controller_presenter_view.screens.ScreenConstants.getConstantX;
import static controller_presenter_view.screens.ScreenConstants.getConstantY;


public class ParUpcomingEventPage extends JFrame {
    final String parUsername;

    /**The constructor of the Participant upcoming event page.
     * It takes a parUsername to obtain necessary information from the database.
     *
     * @param parUsername The username of the participant
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public ParUpcomingEventPage(String parUsername) throws ClassNotFoundException {
        this.parUsername = parUsername;
        this.setLayout(null);
        this.setSize(getConstantX(), getConstantY());
        this.setLocationRelativeTo(null);

        JLabel title = new JLabel(this.parUsername + "'s Upcoming Events Page");
        title.setBounds(0, 0, getConstantX(), 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        JButton back = new JButton("Back");
        back.addActionListener(new ParUpcomingEventActionListener(this));
        back.setBounds(0, 100, 150, 30);

        //Generate a JScrollPane of events and add it to the page
        generateEvents();

        this.add(title);
        this.add(back);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    /**This method will be called in ParUpcomingEventActionListener.
     * @return it will return a string which is participant's username.
     */
    public String getParUsername() {
        return parUsername;
    }

    public void generateEvents() throws ClassNotFoundException {
        JPanel events = new JPanel();
        events.setBounds(150,100,getConstantX()-170,getConstantY()-150);
        ParDsGateway p = new ParFileUser();

        ExtractInfoInputBoundary interactor1= new ExtractInfoInteractor(p);
        ExtractInfoController controller1= new ExtractInfoController(interactor1);
        ExtractInfoResponseModel<String> response1= controller1.extractPar("getUpcomingEvents",parUsername);

        ArrayList<String> upcomingEvents = response1.getAl();

        int numberOfEvent = upcomingEvents.size();

        if (numberOfEvent != 0) {

            events.setLayout(new GridLayout(numberOfEvent, 0, 10, 10));

            int x = 0;
            int y = 0;

            for (String upcomingEventTitle : upcomingEvents) {
                CommonMethod.setEventInfo(this, events, upcomingEventTitle, x, y, "OrgUpcomingEvent");
                JButton leave = new JButton("Leave");
                leave.setActionCommand(upcomingEventTitle + "Leave");
                leave.addActionListener(new ParUpcomingEventActionListener(this));
                leave.setBounds(x + 250, y + 55, 100, 30);
                leave.setVisible(true);
                events.add(leave);
                y += 100;
            }
            //Set parameters for JScrollPane
            JScrollPane eventScroll = CommonMethod.generateJScrollPane(events);
            this.add(eventScroll);
        }
    }
}
