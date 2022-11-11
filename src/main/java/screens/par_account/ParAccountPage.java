package screens.par_account;

import javax.swing.*;

public class ParAccountPage extends JFrame {
    private String parUsername;
    public ParAccountPage(String parUsername){
        this.parUsername = parUsername;

        this.setLayout(null);

        this.setSize(500, 500);

        this.setLocationRelativeTo(null);

        JLabel title = new JLabel(this.parUsername + "'s Account Page");
        title.setBounds(0, 0, 500, 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        JButton back = new JButton("Back");
        back.addActionListener(new ParAccountActionListener(this));
        back.setBounds(0, 100, 150, 30);

        this.add(title);
        this.add(back);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    public String getParUsername() {
        return parUsername;
    }
}
