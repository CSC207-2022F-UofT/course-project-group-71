package screens.par_search;

import screens.par_home.ParHomePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventResultsPageActionListener implements ActionListener {

    public EventResultsPage eventResultsPage;

    public EventResultsPageActionListener( EventResultsPage eventResultsPage){
        this.eventResultsPage= eventResultsPage;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if (actionCommand.equals("Back")) {
            this.eventResultsPage.dispose();
            new ParHomePage(this.eventResultsPage.getParUsername());
        }
    }
}
