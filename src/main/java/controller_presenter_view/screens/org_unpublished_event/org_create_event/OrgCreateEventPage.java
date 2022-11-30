package controller_presenter_view.screens.org_unpublished_event.org_create_event;

import controller_presenter_view.screens.org_unpublished_event.OrgUnpublishedEventPage;
import use_cases.org_create_event_use_case.OrgCreateEventResponseModel;
import controller_presenter_view.screens.LabelTextPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgCreateEventPage extends JFrame implements ActionListener {

    final OrgCreateEventController CONTROLLER;
    final OrgUnpublishedEventPage ORGUNPUBLISHEDEVENTPAGE;

    //The input bar for all sorts of information
    final JTextField EVENT_TITLE = new JTextField(15);
    final JTextField DESCRIPTION = new JTextField(15);
    final JTextField YEAR = new JTextField(4);
    final JTextField MONTH = new JTextField(2);
    final JTextField DAY = new JTextField(2);
    final JTextField HOUR = new JTextField(2);
    final JTextField MINUTE = new JTextField(2);
    final JTextField LOCATION = new JTextField(15);

    /**
     * This method creates a label text panel for organizer to input data
     * @param text the text we want to show
     * @param J The JTextField
     * @param x the integer x for set bounds
     * @param y the integer y for set bounds
     * @param width the integer representing the width for set bounds
     * @param height the integer representing the height for set bounds
     * @return a text panel
     */
    public LabelTextPanel create_text_panel(String text, JTextField J, int x, int y, int width, int height){
        LabelTextPanel output = new LabelTextPanel(
                new JLabel(text), J);
        output.setBounds (x, y, width, height);
        return output;
    }

    /**The method generate a create event window and allowed the organization to create a new event by input details.
     * It allows user to input title, DESCRIPTION, YEAR, MONTH, DAY, HOUR, MINUTEEs and LOCATION,
     * with two buttons called "Cancel" and "Create".
     * The "Cancel" button will close the window and won't have any changes to the Unpublished Event page.
     * The "Create" button will close the window and updated the Unpublished Event page with the new event added.
     *
     * @param CONTROLLER OrgCreateEventController that takes information got from the page.
     * @param ORGUNPUBLISHEDEVENTPAGE OrgUnpublishedEventPage that will be updated after the event was created.
     */
    public OrgCreateEventPage(OrgCreateEventController CONTROLLER, OrgUnpublishedEventPage ORGUNPUBLISHEDEVENTPAGE){
        this.CONTROLLER = CONTROLLER;
        this.ORGUNPUBLISHEDEVENTPAGE = ORGUNPUBLISHEDEVENTPAGE;

        //Initialize the page
        int x = 500;
        int y = 500;
        this.setLayout(null);
        this.setSize(x, y);
        this.setLocationRelativeTo(null);

        //Generate the title
        JLabel title = new JLabel("Create Your Event");
        title.setBounds(0, 0, x, 50);
        title.setHorizontalAlignment(JLabel.CENTER);

//        //Generate the panel to show title information
//        LabelTextPanel EVENT_TITLEInfo = new LabelTextPanel(
//                new JLabel("Title"), EVENT_TITLE);
//        EVENT_TITLEInfo.setBounds (0,100, x, 50);
//
//        //Generate the panel to show DESCRIPTION information
//        LabelTextPanel DESCRIPTIONInfo = new LabelTextPanel(
//                new JLabel("Description"), DESCRIPTION);
//        DESCRIPTIONInfo.setBounds (0,150, x, 50);
//
//        //Generate the panel to show YEAR information
//        LabelTextPanel YEARInfo = new LabelTextPanel(
//                new JLabel("Year"), YEAR);
//        YEARInfo.setBounds (0,200, x/5, 50);
//
//        //Generate the panel to show MONTH information
//        LabelTextPanel MONTHInfo = new LabelTextPanel(
//                new JLabel("Month"), MONTH);
//        MONTHInfo.setBounds (x/5,200, x/5, 50);
//
//        //Generate the panel to show DAY information
//        LabelTextPanel DAYInfo = new LabelTextPanel(
//                new JLabel("Day"), DAY);
//        DAYInfo.setBounds (2*x/5,200, x/5, 50);
//
//        //Generate the panel to show HOUR information
//        LabelTextPanel HOURInfo = new LabelTextPanel(
//                new JLabel("Hour"), HOUR);
//        HOURInfo.setBounds (3*x/5,200, x/5, 50);
//
//        //Generate the panel to show MINUTE information
//        LabelTextPanel MINUTEInfo = new LabelTextPanel(
//                new JLabel("Minute"), MINUTE);
//        MINUTEInfo.setBounds (4*x/5,200, x/5, 50);
//
//        //Generate the panel to show LOCATION information
//        LabelTextPanel LOCATIONInfo = new LabelTextPanel(
//                new JLabel("Location"), LOCATION);
//        LOCATIONInfo.setBounds (0,250, x, 50);
//
        //Generate a cancel button
        JButton cancel = new JButton("Cancel");
        //Set the action listener for user clicking "Cancel"
        cancel.addActionListener(new OrgCreateEventPageActionListener(this));

        //Generate a button for creation
        JButton create = new JButton("Create");
        create.addActionListener(this);

        JPanel buttons = new JPanel();
        buttons.add(cancel);
        buttons.add(create);
        buttons.setBounds (0,300, x, 50);

        //Add all the prepared elements to the page
        this.add(title);
        this.add(create_text_panel("Title", EVENT_TITLE, 0,100, x, 50));
        this.add(create_text_panel("Description", DESCRIPTION, 0,150, x, 50));
        this.add(create_text_panel("Year", YEAR, 0,200, x/5, 50));
        this.add(create_text_panel("Month", MONTH, x/5,200, x/5, 50));
        this.add(create_text_panel("Day", DAY, 2*x/5,200, x/5, 50));
        this.add(create_text_panel("Hour", HOUR, 3*x/5,200, x/5, 50));
        this.add(create_text_panel("Minute", MINUTE, 4*x/5,200, x/5, 50));
        this.add(create_text_panel("Location", LOCATION, 0,250, x, 50));
        this.add(buttons);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }

    /**The method returns organization's Username.
     * @return it will return a string which is organization's username.
     */
    public String getOrgUsername() { return this.ORGUNPUBLISHEDEVENTPAGE.getOrgUsername(); }

    /**The action listener for button "Create", which will intake the information of the typed strings and send it to
     * the OrgCreateEvent use case.
     * If succeeds, the OrgCreateEventPage will dispose and the OrgUnpublishedEventPage will be renewed.
     * If fails, the OrgCreateEventPage will raise a message showing the reason why it fails.
     *
     * @param e ActionEvent by button "Create".
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //Try to generate the new page in response of the success
        try {
            OrgCreateEventResponseModel responseModel = CONTROLLER.create(getOrgUsername(), EVENT_TITLE.getText(),
                    DESCRIPTION.getText(), LOCATION.getText(),
                    YEAR.getText(), MONTH.getText(), DAY.getText(), HOUR.getText(), MINUTE.getText());
            JOptionPane.showMessageDialog(this, responseModel.getMessage());
            this.dispose();
            this.ORGUNPUBLISHEDEVENTPAGE.dispose();
            new OrgUnpublishedEventPage(getOrgUsername());
        } catch (Exception exception) {
            //If the trying above meet some exception, it goes here
            JOptionPane.showMessageDialog(this, exception.getMessage());
        }
    }
}





