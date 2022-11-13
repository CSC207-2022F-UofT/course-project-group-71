package screens.par_account;

import screens.par_home.ParHomePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParAccountActionListener implements ActionListener {
    public ParAccountPage parAccountPage;

    public ParAccountActionListener(ParAccountPage parAccountPage){
        this.parAccountPage = parAccountPage;
    }

    public void actionPerformed(ActionEvent arg0){
        String actionCommand = arg0.getActionCommand();

        if (actionCommand.equals("Back")) {
            this.parAccountPage.dispose();
            new ParHomePage(this.parAccountPage.getParUsername());
        }
        else {

        }
    }
}
