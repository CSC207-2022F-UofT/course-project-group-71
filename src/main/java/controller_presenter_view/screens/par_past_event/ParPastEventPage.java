package controller_presenter_view.screens.par_past_event;


import database.EventDsGateway;
import database.EventFileUser;
import database.ParDsGateway;
import database.ParFileUser;
import controller_presenter_view.common_controller_presenter.extract_information.ExtractInfoController;
import use_cases.extract_information_use_case.ExtractInfoInputBoundary;
import use_cases.extract_information_use_case.ExtractInfoInteractor;
import use_cases.extract_information_use_case.ExtractInfoResponseModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static controller_presenter_view.screens.screen_constants.getConstantX;
import static controller_presenter_view.screens.screen_constants.getConstantY;


public class ParPastEventPage extends JFrame {
    private final String parUsername;

    /**The page that shows the participant's past events (i.e., the events they previously)
     * registered for.
     *
     * @param parUsername The username of the participant
     */
    public ParPastEventPage(String parUsername) throws ClassNotFoundException {
        this.parUsername = parUsername;

        this.setLayout(null);

        this.setSize(getConstantX(), getConstantY());

        this.setLocationRelativeTo(null);

        JLabel title = new JLabel(this.parUsername + "'s Past Event Page");
        title.setBounds(0, 0, getConstantX(), 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        JButton back = new JButton("Back");
        back.addActionListener(new ParPastEventActionListener(this));
        back.setBounds(0, 100, 150, 30);

        JPanel events = new JPanel();
        events.setBounds(150,100,getConstantX()-170,getConstantY()-150);

        ParDsGateway p = new ParFileUser();
        EventDsGateway e = new EventFileUser();


        ExtractInfoInputBoundary interactor1= new ExtractInfoInteractor(p);
        ExtractInfoController controller1= new ExtractInfoController(interactor1);
        ExtractInfoResponseModel<String> response1= controller1.extractPar("getPastEvents",parUsername);

        ArrayList<String> pastEvents = response1.getAl();

        int numberOfEvent = pastEvents.size();

        if (numberOfEvent != 0) {

            events.setLayout(new GridLayout(numberOfEvent, 0, 10, 10));

            int x = 0;
            int y = 0;

            for (String unpublishedEventTitle : pastEvents) {

                JButton eventTitle = new JButton(unpublishedEventTitle);
                eventTitle.addActionListener(new ParPastEventActionListener(this));
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

                events.add(eventTitle);
                events.add(eventTime);
                events.add(eventLocation);
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

    /**A getter for the participant's username.
     *
     * @return The participant's username
     */
    public String getParUsername() {
        return parUsername;
    }
}
