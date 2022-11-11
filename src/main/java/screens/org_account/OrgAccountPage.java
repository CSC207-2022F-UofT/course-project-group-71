package screens.org_account;

import javax.swing.*;

public class OrgAccountPage extends JFrame {
    private String orgUsername;
    public OrgAccountPage(String orgUsername){
        this.orgUsername = orgUsername;

        this.setLayout(null);

        this.setSize(500, 500);

        this.setLocationRelativeTo(null);

        JLabel title = new JLabel(this.orgUsername + "'s Account Page");
        title.setBounds(0, 0, 500, 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        JButton back = new JButton("Back");
        back.addActionListener(new OrgAccountActionListener(this));
        back.setBounds(0, 100, 150, 30);

        this.add(title);
        this.add(back);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    public String getOrgUsername() {
        return orgUsername;
    }
}
