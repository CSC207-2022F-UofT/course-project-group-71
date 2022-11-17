package screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventCreatedScreen extends JFrame implements EventCreateViewModel, ActionListener {

    private String successMessage;

    public EventCreatedScreen(String title) {
        this.successMessage = "Successfully created event " + title + ".";
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String title) {
        this.successMessage = "Successfully created event " + title + ".";
    }

    // TODO
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
    }
}
