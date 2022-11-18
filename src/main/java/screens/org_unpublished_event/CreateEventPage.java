package screens.org_unpublished_event;

import org_create_event_use_case.OrgCreateEventResponseModel;
import screens.LabelTextPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateEventPage extends JFrame implements ActionListener {

    OrgCreateEventController controller;
    OrgUnpublishedEventPage orgUnpublishedEventPage;

    JTextField eventTitle = new JTextField(15);
    JTextField description = new JTextField(15);
    JTextField year = new JTextField(4);
    JTextField month = new JTextField(2);
    JTextField day = new JTextField(2);
    JTextField hour = new JTextField(2);
    JTextField minute = new JTextField(2);
    JTextField location = new JTextField(15);

    public CreateEventPage(OrgCreateEventController controller, OrgUnpublishedEventPage orgUnpublishedEventPage){
        this.controller = controller;
        this.orgUnpublishedEventPage = orgUnpublishedEventPage;
        
        int x = 500;
        int y = 500;

        this.setLayout(null);

        this.setSize(x, y);

        this.setLocationRelativeTo(null);

        JLabel title = new JLabel("Create Your Event");
        title.setBounds(0, 0, x, 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        LabelTextPanel eventTitleInfo = new LabelTextPanel(
                new JLabel("Title"), eventTitle);
        eventTitleInfo.setBounds (0,100, x, 50);

        LabelTextPanel descriptionInfo = new LabelTextPanel(
                new JLabel("Description"), description);
        descriptionInfo.setBounds (0,150, x, 50);

        LabelTextPanel yearInfo = new LabelTextPanel(
                new JLabel("Year"), year);
        yearInfo.setBounds (0,200, x/5, 50);

        LabelTextPanel monthInfo = new LabelTextPanel(
                new JLabel("Month"), month);
        monthInfo.setBounds (x/5,200, x/5, 50);

        LabelTextPanel dayInfo = new LabelTextPanel(
                new JLabel("Day"), day);
        dayInfo.setBounds (2*x/5,200, x/5, 50);
        
        LabelTextPanel hourInfo = new LabelTextPanel(
                new JLabel("Hour"), hour);
        hourInfo.setBounds (3*x/5,200, x/5, 50);

        LabelTextPanel minuteInfo = new LabelTextPanel(
                new JLabel("Minute"), minute);
        minuteInfo.setBounds (4*x/5,200, x/5, 50);

        LabelTextPanel locationInfo = new LabelTextPanel(
                new JLabel("Location"), location);
        locationInfo.setBounds (0,250, x, 50);

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new CreateEventPageActionListener(this));

        JButton create = new JButton("Create");
        create.addActionListener(this);

        JPanel buttons = new JPanel();
        buttons.add(cancel);
        buttons.add(create);
        buttons.setBounds (0,300, x, 50);

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

    public String getOrgUsername() { return this.orgUnpublishedEventPage.getOrgUsername(); }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            OrgCreateEventResponseModel responseModel = controller.create(getOrgUsername(), eventTitle.getText(), description.getText(), location.getText(),
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





