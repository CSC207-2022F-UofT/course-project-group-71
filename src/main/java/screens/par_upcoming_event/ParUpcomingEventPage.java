package screens.par_upcoming_event;

import javax.swing.*;

public class ParUpcomingEventPage extends JFrame {
    private String parUsername;
    public ParUpcomingEventPage(String parUsername){
        this.parUsername = parUsername;

        this.setLayout(null);

        this.setSize(500, 500);

        this.setLocationRelativeTo(null);

        JLabel title = new JLabel(this.parUsername + "'s Follower Page");
        title.setBounds(0, 0, 500, 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        JButton back = new JButton("Back");
        back.addActionListener(new ParUpcomingEventActionListener(this));
        back.setBounds(0, 100, 150, 30);

        this.add(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    public String getParUsername() {
        return parUsername;
    }
}
