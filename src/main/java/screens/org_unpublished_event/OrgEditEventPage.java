package screens.org_unpublished_event;

import org_edit_event_use_case.OrgEditEventResponseModel;
import screens.LabelTextPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgEditEventPage extends JFrame implements ActionListener {

    OrgEditEventController controller;
    OrgUnpublishedEventPage orgUnpublishedEventPage;

    String eventName;

    JTextField description = new JTextField(15);
    JTextField year = new JTextField(4);
    JTextField month = new JTextField(2);
    JTextField day = new JTextField(2);
    JTextField hour = new JTextField(2);
    JTextField minute = new JTextField(2);
    JTextField location = new JTextField(15);

    public OrgEditEventPage(OrgEditEventController controller, OrgUnpublishedEventPage orgUnpublishedEventPage,
                            String eventName){
        this.controller = controller;
        this.orgUnpublishedEventPage = orgUnpublishedEventPage;
        this.eventName = eventName;
        
        int x = 500;
        int y = 500;

        this.setLayout(null);

        this.setSize(x, y);

        this.setLocationRelativeTo(null);

        JLabel title = new JLabel("Edit Your Event");
        title.setBounds(0, 0, x, 50);
        title.setHorizontalAlignment(JLabel.CENTER);


        JLabel oldEventTitle = new JLabel("Title:   " + eventName);
        oldEventTitle.setBounds(0,100,x,30);


        JLabel oldDescription = new JLabel("Description:   " + eventName);
        oldDescription.setBounds(0,150,x,30);

        LabelTextPanel descriptionInfo = new LabelTextPanel(
                new JLabel("Description"), description);
        descriptionInfo.setBounds (0,180, x, 50);


        JLabel oldYear = new JLabel("Year:   " + eventName);
        oldYear.setBounds(0,230,x/5,30);

        LabelTextPanel yearInfo = new LabelTextPanel(
                new JLabel("Year"), year);
        yearInfo.setBounds (0,260, x/5, 50);


        JLabel oldMonth = new JLabel("Month:   " + eventName);
        oldMonth.setBounds(x/5,230,x/5,30);

        LabelTextPanel monthInfo = new LabelTextPanel(
                new JLabel("Month"), month);
        monthInfo.setBounds (x/5,260, x/5, 50);


        JLabel oldDay = new JLabel("Day:   " + eventName);
        oldDay.setBounds(2*x/5,230,x/5,30);

        LabelTextPanel dayInfo = new LabelTextPanel(
                new JLabel("Day"), day);
        dayInfo.setBounds (2*x/5,260, x/5, 50);


        JLabel oldHour = new JLabel("Hour:   " + eventName);
        oldHour.setBounds(3*x/5,230,x/5,30);

        LabelTextPanel hourInfo = new LabelTextPanel(
                new JLabel("Hour"), hour);
        hourInfo.setBounds (3*x/5,260, x/5, 50);


        JLabel oldMinute = new JLabel("Minute:   " + eventName);
        oldMinute.setBounds(4*x/5,230,x/5,30);

        LabelTextPanel minuteInfo = new LabelTextPanel(
                new JLabel("Minute"), minute);
        minuteInfo.setBounds (4*x/5,260, x/5, 50);


        JLabel oldLocation = new JLabel("Location:   " + eventName);
        oldMinute.setBounds(0,310, x,30);

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
        this.add(oldEventTitle);
        this.add(oldDescription);
        this.add(descriptionInfo);
        this.add(oldYear);
        this.add(yearInfo);
        this.add(oldMonth);
        this.add(monthInfo);
        this.add(oldDay);
        this.add(dayInfo);
        this.add(oldHour);
        this.add(hourInfo);
        this.add(oldMinute);
        this.add(minuteInfo);
        this.add(oldLocation);
        this.add(locationInfo);
        this.add(buttons);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }

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





