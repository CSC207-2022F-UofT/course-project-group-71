package screens.par_search;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static tutorial.HelloWorld.getConstantX;
import static tutorial.HelloWorld.getConstantY;

public class OrganizerResultsPage extends JFrame {

     private ArrayList<String> orgNames;
     private String parUsername;
    public OrganizerResultsPage(ArrayList<String> orgNames, String parUsername) {

        this.orgNames = orgNames;
        this.parUsername=parUsername;

        this.setLayout(null);

        this.setSize(getConstantX(), getConstantY());

        this.setLocationRelativeTo(null);

        JLabel title = new JLabel("Organizer Search Results");
        title.setBounds(0, 0, getConstantX(), 50);
        title.setHorizontalAlignment(JLabel.CENTER);


        JButton back = new JButton("Back");
        back.addActionListener(new OrganizerResultsPageActionListener(this));
        back.setBounds(0, 100, 150, 30);

        JPanel organizers = new JPanel();
        organizers.setBounds(150, 100, getConstantX() - 170, getConstantY() - 150);

        int numberOrgs= this.orgNames.size();
        if (numberOrgs != 0) {

            organizers.setLayout(new GridLayout(numberOrgs, 0, 10, 10));

            int x = 0;
            int y = 0;

            for (String nextOrg : this.orgNames ) {

                JButton orgName = new JButton(nextOrg);
//                orgName.addActionListener(new OrganizerResultsPageActionListener(this));
                orgName.setBounds(x, y, 250, 30);
                orgName.setVisible(true);


                JButton follow = new JButton("Follow");
//              follow.addActionListener(new OrganizerResultsPageActionListener(this));
                follow.setBounds(x, y, 250, 30);
                follow.setVisible(true);


                JButton unfollow = new JButton("Unfollow");
//                unfollow.addActionListener(new OrganizerResultsPageActionListener(this));
                unfollow.setBounds(x + 250, y + 15, 100, 30);
                unfollow.setVisible(true);


                organizers.add(orgName);
                organizers.add(follow);
                organizers.add(unfollow);


                y += 100;
            }

            JScrollPane orgScroll = new JScrollPane(organizers);
            orgScroll.setBounds(150, 100, getConstantX() - 170, getConstantY() - 150);
            orgScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            orgScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            orgScroll.setVisible(true);
            this.add(orgScroll);
        }


        this.add(title);
        this.add(back);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }

    public String getParUsername() {
        return parUsername;
    }

}
