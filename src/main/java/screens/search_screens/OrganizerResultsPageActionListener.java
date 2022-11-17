package screens.search_screens;

import screens.par_home.ParHomePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrganizerResultsPageActionListener implements ActionListener {


    public OrganizerResultsPage organizerResultsPage;

    public OrganizerResultsPageActionListener(OrganizerResultsPage organizerResultsPage){

        this.organizerResultsPage= organizerResultsPage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if (actionCommand.equals("Back")) {
            this.organizerResultsPage.dispose();
            new ParHomePage(this.organizerResultsPage.getParUsername());
        }

    }
}
