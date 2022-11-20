package screens.par_search;



import database.ParDsGateway;
import database.ParFileUser;
import extract_information_use_case.ExtractInfoController;
import extract_information_use_case.ExtractInfoInputBoundary;
import extract_information_use_case.ExtractInfoInteractor;
import extract_information_use_case.ExtractInfoResponseModel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

import static tutorial.HelloWorld.getConstantX;
import static tutorial.HelloWorld.getConstantY;

public class ParSearchOrgResultsPage extends JFrame {

    private ArrayList<String> orgNames,followedList;
    private String parUsername;

    ParDsGateway p = new ParFileUser();

    /**The main method for creating the search results page.
     *
     * @param orgNames An array list containing all the search results
     * @param parUsername A string containing the participant's username
     */
    public ParSearchOrgResultsPage(ArrayList<String> orgNames, String parUsername) {

        this.parUsername = parUsername;
        this.orgNames = orgNames;

        ExtractInfoInputBoundary interactor1= new ExtractInfoInteractor(p);
        ExtractInfoController controller1= new ExtractInfoController(interactor1);
        ExtractInfoResponseModel<String> response1= controller1.extractPar("getFollowedOrg",parUsername);

        this.followedList= response1.getAl();


        this.setLayout(null);

        this.setSize(getConstantX(), getConstantY());

        this.setLocationRelativeTo(null);

        JLabel title = new JLabel("Organizer Search Results");
        title.setBounds(0, 0, getConstantX(), 50);
        title.setHorizontalAlignment(JLabel.CENTER);


        JButton back = new JButton("Back");
        back.addActionListener(new ParSearchOrgResultsPageActionListener(this,"none"));
        back.setBounds(0, 100, 150, 30);

        JPanel organizers = new JPanel();
        organizers.setBounds(150, 100, getConstantX() - 170, getConstantY() - 150);

        int numberOrgs = orgNames.size();
        if (numberOrgs != 0) {

            organizers.setLayout(new GridLayout(numberOrgs, 0, 10, 10));

            int x = 0;
            int y = 0;

            for (String nextOrg : orgNames) {
                System.out.println(nextOrg);

                JButton orgName = new JButton(nextOrg);
                orgName.addActionListener(new ParSearchOrgResultsPageActionListener(this,nextOrg));
                orgName.setBounds(x, y, 250, 30);
                organizers.add(orgName);
                orgName.setVisible(true);


               if (this.followedList.contains(nextOrg)) {
                    JButton unfollow = new JButton("Unfollow");
                    unfollow.setActionCommand("Unfollow "+nextOrg);
                    unfollow.addActionListener(new ParSearchOrgResultsPageActionListener(this,nextOrg));
                    unfollow.setBounds(x, y, 250, 30);
                    organizers.add(unfollow);
                    unfollow.setVisible(true);

               } else {
                   JButton follow = new JButton("Follow "+nextOrg);
                   follow.setActionCommand("Follow "+nextOrg);
                   follow.addActionListener(new ParSearchOrgResultsPageActionListener(this,nextOrg));
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

    /**A getter for the participant's username
     *
     * @return Returns the participant's username
     */
    public String getParUsername() {
        return parUsername;
    }

    public ArrayList<String> getOrgNames() {
        return orgNames;
    }
}
