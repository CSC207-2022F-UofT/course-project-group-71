package controller_presenter_view.screens.par_past_event;


import controller_presenter_view.screens.Util_Method;
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
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
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

        //Generate a JScrollPane of events and add it to the page
        generateEvents();

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

    public void generateEvents() throws ClassNotFoundException {

        JPanel events = new JPanel();
        events.setBounds(150,100,getConstantX()-170,getConstantY()-150);

        ParDsGateway p = new ParFileUser();
        ExtractInfoInputBoundary interactor1= new ExtractInfoInteractor(p);
        ExtractInfoController controller1= new ExtractInfoController(interactor1);
        ExtractInfoResponseModel<String> response1 = controller1.extractPar("getPastEvents",parUsername);
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
                JLabel eventTime = Util_Method.setEventTime(unpublishedEventTitle, x, y);
                JLabel eventLocation = Util_Method.setEventLocation(unpublishedEventTitle, x, y);
                //Add the above events on the page
                events.add(eventTitle);
                events.add(eventTime);
                events.add(eventLocation);
                y += 100;
            }
            //Set parameters for JScrollPane
            JScrollPane eventScroll = Util_Method.generateJScrollPane(events);
            this.add(eventScroll);
        }
    }
}
