package screens.par_past_event;

import screens.par_home.ParHomePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParPastEventActionListener implements ActionListener {
    public ParPastEventPage parPastEventPage;

    /**Constructs the acation listener for the participant's past events page.
     * It takes the past event page as input and sets it as an attribute.
     *
     * @param parPastEventPage The participant's past event page
     */
    public ParPastEventActionListener(ParPastEventPage parPastEventPage){
        this.parPastEventPage = parPastEventPage;
    }

    /**Listens for actions performed on the past events page.
     * The only possible action is "Back", which brings the participant back
     * to the home page.
     *
     * @param arg0 the event to be processed
     */
    public void actionPerformed(ActionEvent arg0){
        String actionCommand = arg0.getActionCommand();

        if (actionCommand.equals("Back")) {
            this.parPastEventPage.dispose();
            new ParHomePage(this.parPastEventPage.getParUsername());
        }
//        else if (actionCommand.contains("Delete")) {
//
//        }
    }
}
