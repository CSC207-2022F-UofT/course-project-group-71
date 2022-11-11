package screens;

import javax.swing.*;

public class OrgUpcomingEventPage extends JFrame {

    public OrgUpcomingEventPage(){
        this.setLayout(null);

        this.setSize(500,500);

        this.setLocationRelativeTo(null);
        JLabel title = new JLabel("Org Upcoming Event Page");
        title.setBounds (0,0, 500, 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        this.add(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }
}
