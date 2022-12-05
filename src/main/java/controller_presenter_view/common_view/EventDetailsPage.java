package controller_presenter_view.common_view;


import controller_presenter_view.common_controller_presenter.extract_information.ExtractInfoController;
import database.EventDsGateway;
import database.EventFileUser;
import use_cases.extract_information_use_case.ExtractInfoInputBoundary;
import use_cases.extract_information_use_case.ExtractInfoInteractor;
import use_cases.extract_information_use_case.ExtractInfoResponseModel;

import javax.swing.*;
import java.util.ArrayList;

import static controller_presenter_view.screens.ScreenConstants.getConstantX;
import static controller_presenter_view.screens.ScreenConstants.getConstantY;


public class EventDetailsPage extends JFrame {

    /** When this constructor is called it will generate an event details page for the event of interest using the
     * EVENT_TITLE parameter. The page will contain information such as the event's name, description, time, and location.
     *
     * @param EVENT_TITLE The title for the event we want to get the details page for
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public EventDetailsPage(String EVENT_TITLE) throws ClassNotFoundException {

        EventDsGateway e = new EventFileUser();
        this.setSize(getConstantX() - 300, getConstantY() - 500);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        //Creates title
        JLabel title = new JLabel("Event Details");
        title.setBounds(0, 0, getConstantX() - 300, 50);
        title.setHorizontalAlignment(JLabel.CENTER);


        //Adds text for event name
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel eventName = new JLabel("Event Title:     \t" + EVENT_TITLE);

        ExtractInfoInputBoundary interactor = new ExtractInfoInteractor(e);
        ExtractInfoController controller = new ExtractInfoController(interactor);

        //Adds text for event description
        ExtractInfoResponseModel<String> response0 = controller.extractEvent("getOrganization", EVENT_TITLE);
        JLabel organization = new JLabel("Organization: \t" + response0.getStr());

        //Adds text for event description
        ExtractInfoResponseModel<String> response1 = controller.extractEvent("getDescription", EVENT_TITLE);
        JLabel description = new JLabel("Description:   \t" + response1.getStr());

        //Adds text for event time
        ExtractInfoResponseModel<Integer> response2= controller.extractEventTime(EVENT_TITLE);
        ArrayList<Integer> times = response2.getAl();
        JLabel time = new JLabel("Time:             \t" + times.get(0) + " " + times.get(1) + "-" +
                times.get(2) +" "+times.get(3) + ":" + times.get(4));

        ExtractInfoResponseModel<String> response3= controller.extractEvent("getLocation", EVENT_TITLE);
        //Adds text for event location
        JLabel location = new JLabel("Location:        \t"+ response3.getStr());


        panel.add(eventName);
        panel.add(organization);
        panel.add(description);
        panel.add(time);
        panel.add(location);
        panel.setBounds(50, 70, getConstantX() - 300, getConstantY() - 500);


        this.add(title);
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }


}
