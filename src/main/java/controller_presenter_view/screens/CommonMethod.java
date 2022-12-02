package controller_presenter_view.screens;

import controller_presenter_view.common_controller_presenter.extract_information.ExtractInfoController;
import controller_presenter_view.common_controller_presenter.notify_event.NotifyEventController;
import controller_presenter_view.common_controller_presenter.notify_event.NotifyEventPresenter;
import controller_presenter_view.common_controller_presenter.org_delete_event.OrgDeleteEventController;
import controller_presenter_view.common_controller_presenter.org_delete_event.OrgDeleteEventPresenter;
import controller_presenter_view.common_controller_presenter.upcoming_to_past.UpcomingToPastController;
import controller_presenter_view.common_controller_presenter.upcoming_to_past.UpcomingToPastPresenter;
import controller_presenter_view.screens.org_past_event.OrgPastEventActionListener;
import controller_presenter_view.screens.org_past_event.OrgPastEventPage;
import controller_presenter_view.screens.org_unpublished_event.OrgUnpublishedEventActionListener;
import controller_presenter_view.screens.org_unpublished_event.OrgUnpublishedEventPage;
import controller_presenter_view.screens.org_upcoming_event.OrgUpcomingEventActionListener;
import controller_presenter_view.screens.org_upcoming_event.OrgUpcomingEventPage;
import controller_presenter_view.screens.par_upcoming_event.ParUpcomingEventActionListener;
import controller_presenter_view.screens.par_upcoming_event.ParUpcomingEventPage;
import database.*;
import use_cases.extract_information_use_case.ExtractInfoInputBoundary;
import use_cases.extract_information_use_case.ExtractInfoInteractor;
import use_cases.extract_information_use_case.ExtractInfoResponseModel;
import use_cases.notify_event_use_case.NotifyEventInputBoundary;
import use_cases.notify_event_use_case.NotifyEventInteractor;
import use_cases.notify_event_use_case.NotifyEventOutputBoundary;
import use_cases.org_delete_event_use_case.OrgDeleteEventInputBoundary;
import use_cases.org_delete_event_use_case.OrgDeleteEventInteractor;
import use_cases.org_delete_event_use_case.OrgDeleteEventOutputBoundary;
import use_cases.upcoming_to_past_use_case.UpcomingToPastInputBoundary;
import use_cases.upcoming_to_past_use_case.UpcomingToPastInteractor;
import use_cases.upcoming_to_past_use_case.UpcomingToPastOutputBoundary;
import use_cases.upcoming_to_past_use_case.UpcomingToPastResponseModel;

import javax.swing.*;

import java.util.ArrayList;

import static controller_presenter_view.screens.ScreenConstants.getConstantX;
import static controller_presenter_view.screens.ScreenConstants.getConstantY;

public class CommonMethod {

    public static void convertAndNotify(String userType, String orgUsername){
        //convert upcoming events to past events if their time is in the past
        ParDsGateway parDsGateway = new ParFileUser();
        OrgDsGateway orgDsGateway = new OrgFileUser();
        EventDsGateway eventDsGateway = new EventFileUser();
        UpcomingToPastOutputBoundary upcomingToPastOutputBoundary = new UpcomingToPastPresenter();
        UpcomingToPastInputBoundary interactor = new UpcomingToPastInteractor(parDsGateway, orgDsGateway,
                eventDsGateway, upcomingToPastOutputBoundary);
        UpcomingToPastController controller = new UpcomingToPastController(interactor);
        UpcomingToPastResponseModel responseModel;
        try {
            responseModel = controller.convertToPast(userType, orgUsername);
        } catch (ClassNotFoundException exception) {
            throw new RuntimeException(exception);
        }

        //notify the relevant participant of the events
        if (!responseModel.getEventsToPast().isEmpty()) {
            NotifyEventOutputBoundary notifyEventOutputBoundary = new NotifyEventPresenter();
            NotifyEventInputBoundary interactor2 = new NotifyEventInteractor(eventDsGateway, parDsGateway,
                    notifyEventOutputBoundary);
            NotifyEventController notifyEventController = new NotifyEventController(interactor2);
            for (String event : responseModel.getEventsToPast()){
                try {
                    notifyEventController.sendNotification("Past", event);
                } catch (ClassNotFoundException exception) {
                    throw new RuntimeException(exception);
                }
            }
        }
    }

    public static OrgDeleteEventController utilGetDeleteEventControllerHelper(){
        EventDsGateway eventDsGateway = new EventFileUser();

        ParDsGateway parDsGateway = new ParFileUser();

        OrgDeleteEventOutputBoundary orgDeleteEventOutputBoundary = new OrgDeleteEventPresenter();

        OrgDeleteEventInputBoundary interactor = new OrgDeleteEventInteractor(eventDsGateway,
                parDsGateway, orgDeleteEventOutputBoundary);

        return new OrgDeleteEventController(interactor);
    }

    public static JScrollPane generateJScrollPane(JPanel jPanel){
        JScrollPane jScrollPane = new JScrollPane(jPanel);
        jScrollPane.setBounds(150, 100, getConstantX() - 170, getConstantY() - 150);
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setVisible(true);
        return jScrollPane;
    }

    /**
     * This is the function to generate a label text panel
     * @param text the text we want to show
     * @param J the JPasswordField
     * @param x the integer x for set bounds
     * @param y the integer y for set bounds
     * @param width the integer representing the width for set bounds
     * @param height the integer representing the height for set bounds
     * @return a text panel
     */
    public static LabelTextPanel create_text_panel(String text, JPasswordField J, int x, int y, int width, int height){
        LabelTextPanel output = new LabelTextPanel(new JLabel(text), J);
        output.setBounds(x,y, width, height);
        return output;
    }

    /**
     * This is the function to generate a JLabel
     * @param text the text we want to show
     * @param x the integer x for set bounds
     * @param y the integer y for set bounds
     * @param width the integer representing the width for set bounds
     * @param height the integer representing the height for set bounds
     * @return a text panel
     */
    public static JLabel create_JLabel(String text, int x, int y, int width, int height){
        JLabel output = new JLabel(text);
        output.setBounds(x, y, width, height);
        output.setHorizontalAlignment(JLabel.CENTER);
        return output;
    }

    public static void setEventInfo(JFrame page, JPanel events, String title, int x, int y, String actionListener) throws ClassNotFoundException{
        JButton eventTitle = new JButton(title);
        //Set the action listener to show the detailed event information when clicking the event title
        switch (actionListener) {
            case "OrgUnpublishedEvent":
                eventTitle.addActionListener(new OrgUnpublishedEventActionListener((OrgUnpublishedEventPage) page));
                break;
            case "OrgUpcomingEvent":
                eventTitle.addActionListener(new OrgUpcomingEventActionListener((OrgUpcomingEventPage) page));
                break;
            case "OrgPastEvent":
                eventTitle.addActionListener(new OrgPastEventActionListener((OrgPastEventPage) page));
                break;
            case "ParUpcomingEvent":
                eventTitle.addActionListener(new ParUpcomingEventActionListener((ParUpcomingEventPage) page));
                break;
            case "ParPastEvent":

                break;
        }
        eventTitle.setBounds(x, y, 250, 30);
        eventTitle.setVisible(true);
        JLabel eventTime = CommonMethod.setEventTime(title, x, y);
        JLabel eventLocation = CommonMethod.setEventLocation(title, x, y);
        //Add the above events on the page
        events.add(eventTitle);
        events.add(eventTime);
        events.add(eventLocation);
    }

    public static JLabel setEventTime(String eventTitle, int x, int y) throws ClassNotFoundException {
        EventDsGateway e = new EventFileUser();
        ExtractInfoInputBoundary interactor2 = new ExtractInfoInteractor(e);
        ExtractInfoController controller2 = new ExtractInfoController(interactor2);
        ExtractInfoResponseModel<Integer> response2 = controller2.extractEventTime(eventTitle);

        //Obtain the times
        ArrayList<Integer> times = response2.getAl();
        String time = times.get(0) + " " + times.get(1) + "-" + times.get(2) + " " +
                times.get(3) + ":" + times.get(4);

        //Get the time to show on the screen
        JLabel eventTime = new JLabel(time);
        eventTime.setBounds(x + 20, y + 40, 250, 30);
        eventTime.setVisible(true);
        return eventTime;
    }

    public static JLabel setEventLocation(String eventTitle, int x, int y) throws ClassNotFoundException{
        EventDsGateway e = new EventFileUser();
        //Prepare the interactor, controller and response model
        ExtractInfoInputBoundary interactor3 = new ExtractInfoInteractor(e);
        ExtractInfoController controller3 = new ExtractInfoController(interactor3);
        ExtractInfoResponseModel<String> response3 = controller3.extractEvent("getLocation", eventTitle);

        //Get and show the information of location
        String location = response3.getStr();
        JLabel eventLocation = new JLabel(location);
        eventLocation.setBounds(x + 20, y + 70, 250, 30);
        eventLocation.setVisible(true);
        return eventLocation;
    }
}
