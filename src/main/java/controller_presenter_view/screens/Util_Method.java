package controller_presenter_view.screens;

import controller_presenter_view.common_controller_presenter.notify_event.NotifyEventController;
import controller_presenter_view.common_controller_presenter.notify_event.NotifyEventPresenter;
import controller_presenter_view.common_controller_presenter.org_delete_event.OrgDeleteEventController;
import controller_presenter_view.common_controller_presenter.org_delete_event.OrgDeleteEventPresenter;
import controller_presenter_view.common_controller_presenter.upcoming_to_past.UpcomingToPastController;
import controller_presenter_view.common_controller_presenter.upcoming_to_past.UpcomingToPastPresenter;
import database.*;
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

import static controller_presenter_view.screens.screen_constants.getConstantX;
import static controller_presenter_view.screens.screen_constants.getConstantY;

public class Util_Method {

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
        output.setBounds (x,y, width, height);
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
}
