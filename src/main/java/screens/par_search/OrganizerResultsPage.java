package screens.par_search;



import database.ParDsGateway;
import database.ParFileUser;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static tutorial.HelloWorld.getConstantX;
import static tutorial.HelloWorld.getConstantY;

public class OrganizerResultsPage extends JFrame {

    private final String parUsername;

    ParDsGateway par = new ParFileUser();

    public OrganizerResultsPage(ArrayList<String> orgNames, String parUsername) {

        this.parUsername = parUsername;
        ArrayList<String> orgFollowed = par.getFollowedOrg(this.parUsername);

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

        int numberOrgs = orgNames.size();
        if (numberOrgs != 0) {

            organizers.setLayout(new GridLayout(numberOrgs, 0, 10, 10));

            int x = 0;
            int y = 0;

            for (String nextOrg : orgNames) {

                JButton orgName = new JButton(nextOrg);
//                orgName.addActionListener(new OrganizerResultsPageActionListener(this));
                orgName.setBounds(x, y, 250, 30);
                organizers.add(orgName);
                orgName.setVisible(true);


                if (orgFollowed.contains(nextOrg)) {
                    JButton unfollow = new JButton("Unfollow");
//                unfollow.addActionListener(new OrganizerResultsPageActionListener(this));
                    unfollow.setBounds(x, y, 250, 30);
                    organizers.add(unfollow);
                    unfollow.setVisible(true);

                } else {
                    JButton follow = new JButton("Follow");
//              follow.addActionListener(new OrganizerResultsPageActionListener(this));
                    follow.setBounds(x, y, 250, 30);
                    organizers.add(follow);
                    follow.setVisible(true);
                }




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
