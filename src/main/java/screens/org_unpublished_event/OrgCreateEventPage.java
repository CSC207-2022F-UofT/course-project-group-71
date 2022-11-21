package screens.org_unpublished_event;

import org_create_event_use_case.OrgCreateEventResponseModel;
import screens.LabelTextPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgCreateEventPage extends JFrame implements ActionListener {

    OrgCreateEventController controller;
    OrgUnpublishedEventPage orgUnpublishedEventPage;

    //The input bar for all sorts of information
    JTextField eventTitle = new JTextField(15);
    JTextField description = new JTextField(15);
    JTextField year = new JTextField(4);
    JTextField month = new JTextField(2);
    JTextField day = new JTextField(2);
    JTextField hour = new JTextField(2);
    JTextField minute = new JTextField(2);
    JTextField location = new JTextField(15);

    /**The method generate a create event window and allowed the organization to create a new event by input details.
     * It allows user to input title, description, year, month, day, hour, minutes and location,
     * with two buttons called "Cancel" and "Create".
     * The "Cancel" button will close the window and won't have any changes to the Unpublished Event page.
     * The "Create" button will close the window and updated the Unpublished Event page with the new event added.
     *
     * @param controller OrgCreateEventController that takes information got from the page.
     * @param orgUnpublishedEventPage OrgUnpublishedEventPage that will be updated after the event was created.
     */
    public OrgCreateEventPage(OrgCreateEventController controller, OrgUnpublishedEventPage orgUnpublishedEventPage){
        this.controller = controller;
        this.orgUnpublishedEventPage = orgUnpublishedEventPage;

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

        //Generate the panel to show title information
        LabelTextPanel eventTitleInfo = new LabelTextPanel(
                new JLabel("Title"), eventTitle);
        eventTitleInfo.setBounds (0,100, x, 50);

        //Generate the panel to show description information
        LabelTextPanel descriptionInfo = new LabelTextPanel(
                new JLabel("Description"), description);
        descriptionInfo.setBounds (0,150, x, 50);

        //Generate the panel to show year information
        LabelTextPanel yearInfo = new LabelTextPanel(
                new JLabel("Year"), year);
        yearInfo.setBounds (0,200, x/5, 50);

        //Generate the panel to show month information
        LabelTextPanel monthInfo = new LabelTextPanel(
                new JLabel("Month"), month);
        monthInfo.setBounds (x/5,200, x/5, 50);

        //Generate the panel to show day information
        LabelTextPanel dayInfo = new LabelTextPanel(
                new JLabel("Day"), day);
        dayInfo.setBounds (2*x/5,200, x/5, 50);

        //Generate the panel to show hour information
        LabelTextPanel hourInfo = new LabelTextPanel(
                new JLabel("Hour"), hour);
        hourInfo.setBounds (3*x/5,200, x/5, 50);

        //Generate the panel to show minute information
        LabelTextPanel minuteInfo = new LabelTextPanel(
                new JLabel("Minute"), minute);
        minuteInfo.setBounds (4*x/5,200, x/5, 50);

        //Generate the panel to show location information
        LabelTextPanel locationInfo = new LabelTextPanel(
                new JLabel("Location"), location);
        locationInfo.setBounds (0,250, x, 50);

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
        this.add(eventTitleInfo);
        this.add(descriptionInfo);
        this.add(yearInfo);
        this.add(monthInfo);
        this.add(dayInfo);
        this.add(hourInfo);
        this.add(minuteInfo);
        this.add(locationInfo);
        this.add(buttons);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }

    /**The method returns organization's Username.
     * @return it will return a string which is organization's username.
     */
    public String getOrgUsername() { return this.orgUnpublishedEventPage.getOrgUsername(); }

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
            OrgCreateEventResponseModel responseModel = controller.create(getOrgUsername(), eventTitle.getText(),
                    description.getText(), location.getText(),
                    year.getText(), month.getText(), day.getText(), hour.getText(), minute.getText());
            JOptionPane.showMessageDialog(this, responseModel.getMessage());
            this.dispose();
            this.orgUnpublishedEventPage.dispose();
            new OrgUnpublishedEventPage(getOrgUsername());
        } catch (Exception exception) {
            //If the trying above meet some exception, it goes here
            JOptionPane.showMessageDialog(this, exception.getMessage());
        }
    }
}





