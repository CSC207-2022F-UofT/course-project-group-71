package screens.org_unpublished_event;

import screens.LabelTextPanel;

import javax.swing.*;
import java.awt.*;

public class CreateEventPage extends JFrame {

    OrgCreateEventController controller;

    JTextField eventTitle = new JTextField(15);
    JTextField description = new JTextField(15);
    JTextField year = new JTextField(15);
    JTextField month = new JTextField(15);
    JTextField day = new JTextField(15);
    JTextField hour = new JTextField(15);
    JTextField minute = new JTextField(15);
    JTextField location = new JTextField(15);

    public CreateEventPage(OrgCreateEventController controller){
        this.controller = controller;
        
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

        LabelTextPanel DescriptionInfo = new LabelTextPanel(
                new JLabel("Description"), description);
        DescriptionInfo.setBounds (0,150, x, 50);

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
        minuteInfo.setBounds (3*x/5,200, x/5, 50);

        LabelTextPanel locationInfo = new LabelTextPanel(
                new JLabel("Month"), location);
        locationInfo.setBounds (4*x/5,250, x, 50);

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new CreateEventPageActionListener(this));

        JButton create = new JButton("Create");
        create.addActionListener(new CreateEventPageActionListener(this));

        JPanel buttons = new JPanel();
        buttons.add(cancel);
        buttons.add(create);
        buttons.setBounds (0,300, x, 50);

        this.add(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }

}





