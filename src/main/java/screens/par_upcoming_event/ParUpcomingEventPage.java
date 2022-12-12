package screens.par_upcoming_event;

import controllers.ExtractInfoController;
import database.ParDsGateway;
import database.ParFileUser;
import screens.ScreenConstants;
import screens.UICreatorAssistant;
import use_cases.extract_information_use_case.ExtractInfoInputBoundary;
import use_cases.extract_information_use_case.ExtractInfoInteractor;
import use_cases.extract_information_use_case.ExtractInfoResponseModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class ParUpcomingEventPage extends JFrame {
    private final String parUsername;

    /**The constructor of the Participant upcoming event page.
     * It takes a parUsername to obtain necessary information from the database.
     *
     * @param parUsername The username of the participant
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public ParUpcomingEventPage(String parUsername) throws ClassNotFoundException {
        this.parUsername = parUsername;
        this.setLayout(null);
        this.setSize(ScreenConstants.getConstantX(), ScreenConstants.getConstantY());
        this.setLocationRelativeTo(null);

        JLabel title = new JLabel(this.parUsername + "'s Upcoming Events Page");
        title.setBounds(0, 0, ScreenConstants.getConstantX(), 50);
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
        events.setBounds(150,100, ScreenConstants.getConstantX()-170, ScreenConstants.getConstantY()-150);
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
                UICreatorAssistant.setEventInfo(this, events, upcomingEventTitle, x, y, "ParUpcomingEvent");
                JButton leave = new JButton("Leave");
                leave.setActionCommand(upcomingEventTitle + "Leave");
                leave.addActionListener(new ParUpcomingEventActionListener(this));
                leave.setBounds(x + 250, y + 55, 100, 30);
                leave.setVisible(true);
                events.add(leave);
                y += 100;
            }
            //Set parameters for JScrollPane
            JScrollPane eventScroll = UICreatorAssistant.generateJScrollPane(events);
            this.add(eventScroll);
        }
        else {
            this.add(UICreatorAssistant.create_JLabel("None", 0,100, ScreenConstants.getConstantX(),30));
        }
    }
}
