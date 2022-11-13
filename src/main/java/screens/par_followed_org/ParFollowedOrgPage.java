package screens.par_followed_org;

import static tutorial.HelloWorld.getConstantX;
import static tutorial.HelloWorld.getConstantY;
import javax.swing.*;

public class ParFollowedOrgPage extends JFrame {
    private String parUsername;
    public ParFollowedOrgPage(String parUsername){
        this.parUsername = parUsername;

        this.setLayout(null);

        this.setSize(getConstantX(), getConstantY());

        this.setLocationRelativeTo(null);

        JLabel title = new JLabel(this.parUsername + "'s Followed Organization Page");
        title.setBounds(0, 0, getConstantX(), 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        JButton back = new JButton("Back");
        back.addActionListener(new ParFollowedOrgActionListener(this));
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
