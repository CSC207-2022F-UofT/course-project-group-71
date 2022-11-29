package controller_presenter_view.screens.par_upcoming_event;

import database.*;
import controller_presenter_view.common_controller_presenter.extract_information.ExtractInfoController;
import use_cases.extract_information_use_case.ExtractInfoInputBoundary;
import use_cases.extract_information_use_case.ExtractInfoInteractor;
import use_cases.extract_information_use_case.ExtractInfoResponseModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static controller_presenter_view.screens.screen_constants.getConstantX;
import static controller_presenter_view.screens.screen_constants.getConstantY;


public class ParUpcomingEventPage extends JFrame {
    final String parUsername;

    /**The constructor of the Participant upcoming event page.
     * It takes a parUsername to obtain necessary information from the database.
     *
     * @param parUsername The username of the participant
     */
    public ParUpcomingEventPage(String parUsername) {
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

        JPanel events = new JPanel();
        events.setBounds(150,100,getConstantX()-170,getConstantY()-150);

        EventDsGateway e = new EventFileUser();
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

                JButton eventTitle = new JButton(upcomingEventTitle);
                eventTitle.addActionListener(new ParUpcomingEventActionListener(this));
                eventTitle.setBounds(x, y, 250, 30);
                eventTitle.setVisible(true);

                ExtractInfoInputBoundary interactor2= new ExtractInfoInteractor(e);
                ExtractInfoController controller2= new ExtractInfoController(interactor2);
                ExtractInfoResponseModel<Integer> response2= controller2.extractEventTime(upcomingEventTitle);

                ArrayList<Integer> times =response2.getAl();
                String time = times.get(0) + " " + times.get(1) + "-" + times.get(2) + " " +
                        times.get(3) + ":" + times.get(4);

                JLabel eventTime = new JLabel(time);
                eventTime.setBounds(x + 20, y + 40, 250, 30);
                eventTime.setVisible(true);

                ExtractInfoInputBoundary interactor3= new ExtractInfoInteractor(e);
                ExtractInfoController controller3= new ExtractInfoController(interactor3);
                ExtractInfoResponseModel<String> response3= controller3.extractEvent("getLocation",
                        upcomingEventTitle);

                String location = response3.getStr();
                JLabel eventLocation = new JLabel(location);
                eventLocation.setBounds(x + 20, y + 70, 250, 30);
                eventLocation.setVisible(true);

                JButton leave = new JButton("Leave");
                leave.setActionCommand(upcomingEventTitle + "Leave");
                leave.addActionListener(new ParUpcomingEventActionListener(this));
                leave.setBounds(x + 250, y + 55, 100, 30);
                leave.setVisible(true);

                events.add(eventTitle);
                events.add(eventTime);
                events.add(eventLocation);
                events.add(leave);
                y += 100;
            }

            JScrollPane eventScroll = new JScrollPane(events);
            eventScroll.setBounds(150, 100, getConstantX()-170, getConstantY()-150);
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

    /**This method will be called in ParUpcomingEventActionListener.
     * @return it will return a string which is participant's username.
     */
    public String getParUsername() {
        return parUsername;
    }
}
