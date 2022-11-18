package screens.org_unpublished_event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditEventPageActionListener implements ActionListener {

    public EditEventPage editEventPage;

    public EditEventPageActionListener(EditEventPage editEventPage){
        this.editEventPage= editEventPage;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.editEventPage.dispose();
    }
}