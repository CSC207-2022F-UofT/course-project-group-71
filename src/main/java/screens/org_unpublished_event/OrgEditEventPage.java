package screens.org_unpublished_event;

import database.EventDsGateway;
import org_edit_event_use_case.OrgEditEventResponseModel;
import screens.LabelTextPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrgEditEventPage extends JFrame implements ActionListener {

    OrgEditEventController controller;
    EventDsGateway eventDsGateway;
    OrgUnpublishedEventPage orgUnpublishedEventPage;

    String eventName;

    JTextField description = new JTextField(15);
    JTextField year = new JTextField(4);
    JTextField month = new JTextField(2);
    JTextField day = new JTextField(2);
    JTextField hour = new JTextField(2);
    JTextField minute = new JTextField(2);
    JTextField location = new JTextField(15);

    /**The method generate an edit event window and allowed the organization to edit the unpublished event by input details.
     * It allows user to input title, description, year, month, day, hour, minutes and location,
     * with two buttons called "Cancel" and "Edit".
     * The "Cancel" button will close the window and won't have any changes to the Unpublished Event page.
     * The "Edit" button will close the window and updated the Unpublished Event page with the event edited.
     *
     * @param controller OrgCreateEventController that takes information got from the page.
     * @param orgUnpublishedEventPage OrgUnpublishedEventPage that will be updated after the event was created.
     * @param eventName String of the event's name.
     * @param eventDsGateway EventDsGateway that we need to access the old event and modify it.
     */
    public OrgEditEventPage(OrgEditEventController controller, OrgUnpublishedEventPage orgUnpublishedEventPage,
                            String eventName, EventDsGateway eventDsGateway) throws SQLException, ClassNotFoundException {
        this.controller = controller;
        this.orgUnpublishedEventPage = orgUnpublishedEventPage;
        this.eventName = eventName;
        this.eventDsGateway = eventDsGateway;
        
        int x = 500;
        int y = 500;

        this.setLayout(null);

        this.setSize(x, y);

        this.setLocationRelativeTo(null);

        JLabel title = new JLabel("Edit Your Event");
        title.setBounds(0, 0, x, 50);
        title.setHorizontalAlignment(JLabel.CENTER);


        JLabel eventTitle = new JLabel("Title:   " + eventName);
        JPanel eventTitleInfo = new JPanel();
        eventTitleInfo.add(eventTitle);
        eventTitleInfo.setBounds(0,100,x,30);


        JLabel oldDescription = new JLabel("Description:   " + eventDsGateway.getDescription(eventName));
        JPanel oldDescriptionInfo = new JPanel();
        oldDescriptionInfo.add(oldDescription);
        oldDescriptionInfo.setBounds(0,150,x,30);

        LabelTextPanel descriptionInfo = new LabelTextPanel(
                new JLabel("Description"), description);
        descriptionInfo.setBounds (0,180, x, 50);


        ArrayList<Integer> times = eventDsGateway.getTime(eventName);

        JLabel oldYear = new JLabel("Year:   " + times.get(0));
        JPanel oldYearInfo = new JPanel();
        oldYearInfo.add(oldYear);
        oldYearInfo.setBounds(0,230,x/5,30);

        LabelTextPanel yearInfo = new LabelTextPanel(
                new JLabel("Year"), year);
        yearInfo.setBounds (0,260, x/5, 50);


        JLabel oldMonth = new JLabel("Month:   " + times.get(1));
        JPanel oldMonthInfo = new JPanel();
        oldMonthInfo.add(oldMonth);
        oldMonthInfo.setBounds(x/5,230,x/5,30);

        LabelTextPanel monthInfo = new LabelTextPanel(
                new JLabel("Month"), month);
        monthInfo.setBounds (x/5,260, x/5, 50);


        JLabel oldDay = new JLabel("Day:   " + times.get(2));
        JPanel oldDayInfo = new JPanel();
        oldDayInfo.add(oldDay);
        oldDayInfo.setBounds(2*x/5,230,x/5,30);

        LabelTextPanel dayInfo = new LabelTextPanel(
                new JLabel("Day"), day);
        dayInfo.setBounds (2*x/5,260, x/5, 50);


        JLabel oldHour = new JLabel("Hour:   " + times.get(3));
        JPanel oldHourInfo = new JPanel();
        oldHourInfo.add(oldHour);
        oldHourInfo.setBounds(3*x/5,230,x/5,30);

        LabelTextPanel hourInfo = new LabelTextPanel(
                new JLabel("Hour"), hour);
        hourInfo.setBounds (3*x/5,260, x/5, 50);


        JLabel oldMinute = new JLabel("Minute:   " + times.get(4));
        JPanel oldMinuteInfo = new JPanel();
        oldMinuteInfo.add(oldMinute);
        oldMinuteInfo.setBounds(4*x/5,230,x/5,30);

        LabelTextPanel minuteInfo = new LabelTextPanel(
                new JLabel("Minute"), minute);
        minuteInfo.setBounds (4*x/5,260, x/5, 50);


        JLabel oldLocation = new JLabel("Location:   " + eventDsGateway.getLocation(eventName));
        JPanel oldLocationInfo = new JPanel();
        oldLocationInfo.add(oldLocation);
        oldLocationInfo.setBounds(0,310, x,30);

        LabelTextPanel locationInfo = new LabelTextPanel(
                new JLabel("Location"), location);
        locationInfo.setBounds (0,340, x, 50);


        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new OrgEditEventPageActionListener(this));

        JButton edit = new JButton("Edit");
        edit.addActionListener(this);

        JPanel buttons = new JPanel();
        buttons.add(cancel);
        buttons.add(edit);
        buttons.setBounds (0,390, x, 50);

        this.add(title);
        this.add(eventTitle);
        this.add(oldDescriptionInfo);
        this.add(descriptionInfo);
        this.add(oldYearInfo);
        this.add(yearInfo);
        this.add(oldMonthInfo);
        this.add(monthInfo);
        this.add(oldDayInfo);
        this.add(dayInfo);
        this.add(oldHourInfo);
        this.add(hourInfo);
        this.add(oldMinuteInfo);
        this.add(minuteInfo);
        this.add(oldLocationInfo);
        this.add(locationInfo);
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
        try {
            OrgEditEventResponseModel responseModel = controller.edit(eventName,
                    description.getText(), location.getText(),
                    year.getText(), month.getText(), day.getText(), hour.getText(), minute.getText());
            JOptionPane.showMessageDialog(this, responseModel.getMessage());
            this.dispose();
            this.orgUnpublishedEventPage.dispose();
            new OrgUnpublishedEventPage(getOrgUsername());
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage());
        }
    }
}





