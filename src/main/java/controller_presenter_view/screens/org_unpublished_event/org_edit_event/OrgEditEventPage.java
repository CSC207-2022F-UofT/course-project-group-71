package controller_presenter_view.screens.org_unpublished_event.org_edit_event;

import controller_presenter_view.screens.org_unpublished_event.OrgUnpublishedEventPage;
import database.EventDsGateway;
import use_cases.org_edit_event_use_case.OrgEditEventResponseModel;
import controller_presenter_view.screens.LabelTextPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrgEditEventPage extends JFrame implements ActionListener {

    final EventDsGateway eventDsGateway;
    final OrgEditEventController controller;
    final OrgUnpublishedEventPage orgUnpublishedEventPage;

    final String eventName;

    final JTextField description = new JTextField(15);
    final JTextField year = new JTextField(4);
    final JTextField month = new JTextField(2);
    final JTextField day = new JTextField(2);
    final JTextField hour = new JTextField(2);
    final JTextField minute = new JTextField(2);
    final JTextField location = new JTextField(15);

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

    public JPanel create_J_panel(String text, int x, int y, int width, int height){
        JLabel oldtext = new JLabel(text);
        JPanel oldTextInfo = new JPanel();
        oldTextInfo.add(oldtext);
        oldTextInfo.setBounds(x, y, width, height);
        return oldTextInfo;
    }


    /**The method generate an edit event window and allowed the organization to edit the unpublished event by input details.
     * It allows user to input title, description, year, month, day, hour, minutes and location,
     * with two buttons called "Cancel" and "Edit".
     * The "Cancel" button will close the window and won't have any changes to the Unpublished Event page.
     * The "Edit" button will close the window and updated the Unpublished Event page with the event edited.
     *
     * @param controller OrgCreateEventController that takes information got from the page.
     * @param orgUnpublishedEventPage OrgUnpublishedEventPage that will be updated after the event was created.
     * @param eventName String of the event's name.
     */
    public OrgEditEventPage(OrgEditEventController controller, OrgUnpublishedEventPage orgUnpublishedEventPage,
                            String eventName, EventDsGateway eventDsGateway) throws ClassNotFoundException {
        this.controller = controller;
        this.orgUnpublishedEventPage = orgUnpublishedEventPage;
        this.eventName = eventName;
        this.eventDsGateway = eventDsGateway;

        //Initialise the page
        int x = 500;
        int y = 500;
        this.setLayout(null);
        this.setSize(x,y);
        this.setLocationRelativeTo(null);

        //Prepare the title
        JLabel title = new JLabel("Edit Your Event");
        title.setBounds(0, 0, x, 50);
        title.setHorizontalAlignment(JLabel.CENTER);

//        //Prepare the title of the event which are edited
//        JLabel eventTitle = new JLabel("Title:   " + eventName);
//        JPanel eventTitleInfo = new JPanel();
//        eventTitleInfo.add(eventTitle);
//        eventTitleInfo.setBounds(0,100,x,30);
//


        //Prepare the description that need to be shown
//        JLabel oldDescription = new JLabel("Description:   " + eventDsGateway.getDescription(eventName));
//        JPanel oldDescriptionInfo = new JPanel();
//        oldDescriptionInfo.add(oldDescription);
//        oldDescriptionInfo.setBounds(0,150,x,30);
//

//        //Obtain the new description inputted
//        LabelTextPanel descriptionInfo = new LabelTextPanel(
//                new JLabel("Description"), description);
//        descriptionInfo.setBounds (0,180, x, 50);
//
        //Obtain the event time from the database
        ArrayList<Integer> times = eventDsGateway.getTime(eventName);

        //Show year on the page
//        JLabel oldYear = new JLabel();
//        JPanel oldYearInfo = new JPanel();
//        oldYearInfo.add(oldYear);
//        oldYearInfo.setBounds(0,230,x/5,30);

//        //Give the edit window for YEAR on the page
//        LabelTextPanel yearInfo = new LabelTextPanel(
//                new JLabel("Year"), year);
//        yearInfo.setBounds (0,260, x/5, 50);

        //Show month on the page
//        JLabel oldMonth = new JLabel("Month:   " + times.get(1));
//        JPanel oldMonthInfo = new JPanel();
//        oldMonthInfo.add(oldMonth);
//        oldMonthInfo.setBounds(x/5,230,x/5,30);


//        //Give the edit window for MONTH on the page
//        LabelTextPanel monthInfo = new LabelTextPanel(
//                new JLabel("Month"), month);
//        monthInfo.setBounds (x/5,260, x/5, 50);
//
        //Show the day on the page
//        JLabel oldDay = new JLabel("Day:   " + times.get(2));
//        JPanel oldDayInfo = new JPanel();
//        oldDayInfo.add(oldDay);
//        oldDayInfo.setBounds(2*x/5,230,x/5,30);
//

//        //Give the edit window for DAY on the page
//        LabelTextPanel dayInfo = new LabelTextPanel(
//                new JLabel("Day"), day);
//        dayInfo.setBounds (2*x/5,260, x/5, 50);
//

//        //Show the hour on the page
//        JLabel oldHour = new JLabel();
//        JPanel oldHourInfo = new JPanel();
//        oldHourInfo.add(oldHour);
//        oldHourInfo.setBounds(3*x/5,230,x/5,30);
//
//        //Give the edit window for HOUR on the page
//        LabelTextPanel hourInfo = new LabelTextPanel(
//                new JLabel("Hour"), hour);
//        hourInfo.setBounds (3*x/5,260, x/5, 50);
//
//        //Show the minute on the page
//        JLabel oldMinute = new JLabel("Minute:   " + times.get(4));
//        JPanel oldMinuteInfo = new JPanel();
//        oldMinuteInfo.add(oldMinute);
//        oldMinuteInfo.setBounds(4*x/5,230,x/5,30);
//
//        //Give the edit window for MINUTE on the page
//        LabelTextPanel minuteInfo = new LabelTextPanel(
//                new JLabel("Minute"), minute);
//        minuteInfo.setBounds (4*x/5,260, x/5, 50);
//
        //Show the location on the page
//        JLabel oldLocation = new JLabel("Location:   " + eventDsGateway.getLocation(eventName));
//        JPanel oldLocationInfo = new JPanel();
//        oldLocationInfo.add(oldLocation);
//        oldLocationInfo.setBounds(0,310, x,30);
//
//        //Give the edit window for LOCATION on the page
//        LabelTextPanel locationInfo = new LabelTextPanel(
//                new JLabel("Location"), location);
//        locationInfo.setBounds (0,340, x, 50);
//
        //Prepare a cancel button
        JButton cancel = new JButton("Cancel");
        //Set an action listener for the "Cancel" clicking
        cancel.addActionListener(new OrgEditEventPageActionListener(this));

        //Prepare a edit button
        JButton edit = new JButton("Edit");
        //Set an action listener for the "Edit" clicking
        edit.addActionListener(this);

        JPanel buttons = new JPanel();
        buttons.add(cancel);
        buttons.add(edit);
        buttons.setBounds (0,390, x, 50);

        //Add all the buttons to the page
        this.add(title);
        this.add(create_J_panel("Title:   " + eventName, 0,100,x,30));
        this.add(create_J_panel("Description:   " + eventDsGateway.getDescription(eventName), 0,150,x,30));
        this.add(create_text_panel("Description", year, 0,180, x, 50));
        this.add(create_J_panel("Year:   " + times.get(0), 0,230,x/5,30));
        this.add(create_text_panel("Year", year, 0,260, x/5, 50));
        this.add(create_J_panel("Month:   " + times.get(1), x/5,230,x/5,30));
        this.add(create_text_panel("Month", month, x/5,260, x/5, 50));
        this.add(create_J_panel("Day:   " + times.get(2), 2*x/5,230,x/5,30));
        this.add(create_text_panel("Day", day, 2*x/5,260, x/5, 50));
        this.add(create_J_panel("Hour:   " + times.get(3), 3*x/5,230,x/5,30)));
        this.add(create_text_panel("Hour", hour, 3*x/5,260, x/5, 50));
        this.add(create_J_panel("Minute:   " + times.get(4), 4*x/5,230,x/5,30));
        this.add(create_text_panel("Minute", minute, 4*x/5,260, x/5, 50));
        this.add(create_J_panel("Location:   " + eventDsGateway.getLocation(eventName), 0,310, x,30));
        this.add(create_text_panel("Location", location, 0,340, x, 50));
        this.add(buttons);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }

    /**The method returns organization's Username.
     * @return it will return a string which is organization's username.
     */
    public String getOrgUsername() { return this.orgUnpublishedEventPage.getOrgUsername(); }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Try to dispose the current page and show the new page
        try {
            OrgEditEventResponseModel responseModel = controller.edit(eventName,
                    description.getText(), location.getText(),
                    year.getText(), month.getText(), day.getText(), hour.getText(), minute.getText());
            JOptionPane.showMessageDialog(this, responseModel.getMessage());
            this.dispose();
            this.orgUnpublishedEventPage.dispose();
            new OrgUnpublishedEventPage(getOrgUsername());
        } catch (Exception exception) {
            //If catch an error, it shows a message
            JOptionPane.showMessageDialog(this, exception.getMessage());
        }
    }
}





