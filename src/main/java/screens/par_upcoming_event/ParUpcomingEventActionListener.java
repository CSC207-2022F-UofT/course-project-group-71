package screens.par_upcoming_event;

import screens.par_home.ParHomePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParUpcomingEventActionListener implements ActionListener {
    public ParUpcomingEventPage parUpcomingEventPage;

    public ParUpcomingEventActionListener(ParUpcomingEventPage parUpcomingEventPage){
        this.parUpcomingEventPage = parUpcomingEventPage;
    }

    public void actionPerformed(ActionEvent arg0){
        String actionCommand = arg0.getActionCommand();

        if (actionCommand.equals("Back")) {
            this.parUpcomingEventPage.dispose();
            new ParHomePage(this.parUpcomingEventPage.getParUsername());
        }
        /*
        else if (actionCommand.contains("Notify")) {
            EventDsGateway eventDsGateway = new EventFileUser();

            ParDsGateway parDsGateway = new ParFileUser();

            ParNotifyEventPresenter parNotifyEventPresenter = new ParNotifyEventResponseFormatter();

            ParNotifyEventInputBoundary interactor = new ParNotifyEventInteractor(eventDsGateway, parDsGateway, parNotifyEventPresenter);

            ParNotifyEventController parNotifyEventController = new ParNotifyEventController(interactor);

            try {
                ParNotifyEventResponseModel responseModel = parNotifyEventController.sendNotification(this.parUpcomingEventPage.getParUsername());
                JOptionPane.showMessageDialog(this.parUpcomingEventPage, responseModel.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this.parUpcomingEventPage, e.getMessage());
            }
        }
        else if (actionCommand.contains("Delete")) {

        }*/
        else {

        }
    }
}
