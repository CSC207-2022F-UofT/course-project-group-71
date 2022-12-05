package controller_presenter_view.common_view;


import database.OrgDsGateway;
import database.OrgFileUser;
import controller_presenter_view.common_controller_presenter.extract_information.ExtractInfoController;
import use_cases.extract_information_use_case.ExtractInfoInputBoundary;
import use_cases.extract_information_use_case.ExtractInfoInteractor;
import use_cases.extract_information_use_case.ExtractInfoResponseModel;

import javax.swing.*;

import java.util.ArrayList;

import static controller_presenter_view.screens.ScreenConstants.getConstantX;
import static controller_presenter_view.screens.ScreenConstants.getConstantY;


public class OrgDetailsPage extends JFrame {

    final OrgDsGateway o = new OrgFileUser();

    /** When this constructor is called it will generate an organizers details page that will include the organizer's
     * name as well as all the upcoming events for the organizer based on orgName parameter
     *
     * @param orgName The name of the organizer
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public OrgDetailsPage(String orgName) throws ClassNotFoundException {

        this.setSize(getConstantX() - 300, getConstantY() - 500);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        //Creates title
        JLabel title = new JLabel("Organization Details");
        title.setBounds(0, 0, getConstantX() - 300, 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        //Adds text for organizer name
        JLabel orgTitle = new JLabel("Organization: " + orgName);
        orgTitle.setBounds(0, 50, getConstantX() - 300, 30);
        orgTitle.setHorizontalAlignment(JLabel.CENTER);
        JLabel upcoming = new JLabel("Upcoming Events");
        upcoming.setBounds(0, 80, getConstantX() - 300, 30);
        upcoming.setHorizontalAlignment(JLabel.CENTER);

        ExtractInfoInputBoundary interactor1= new ExtractInfoInteractor(o);
        ExtractInfoController controller1= new ExtractInfoController(interactor1);
        ExtractInfoResponseModel<String> response1= controller1.extractOrg("getUpcomingEvents",orgName);


        ArrayList<String> orgUpcomingEvents = response1.getAl();

        JPanel panel = new JPanel();
        panel.setBounds(100, 110, 200, 140);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //loops through all the upcoming events for organizer and adds them to the page
        for (String eventTitle : orgUpcomingEvents) {
            JLabel event = new JLabel(eventTitle);
            panel.add(event);
        }
        JScrollPane scroll = new JScrollPane(panel);

        scroll.setLayout(new ScrollPaneLayout());
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(100, 110, 300, 140);

        this.add(title);
        this.add(orgTitle);
        this.add(upcoming);
        this.add(scroll);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }


}
