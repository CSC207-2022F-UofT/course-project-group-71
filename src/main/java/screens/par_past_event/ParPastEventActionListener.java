package screens.par_past_event;

import screens.ParHomePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParPastEventActionListener implements ActionListener {
    public ParPastEventPage parPastEventPage;

    public ParPastEventActionListener(ParPastEventPage parPastEventPage){
        this.parPastEventPage = parPastEventPage;
    }

    public void actionPerformed(ActionEvent arg0){
        String actionCommand = arg0.getActionCommand();

        if (actionCommand.equals("Back")) {
            this.parPastEventPage.dispose();
            new ParHomePage(this.parPastEventPage.getParUsername());
        }
        else {

        }
    }
}
