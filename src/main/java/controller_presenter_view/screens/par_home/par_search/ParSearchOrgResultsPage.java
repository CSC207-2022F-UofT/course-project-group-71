package controller_presenter_view.screens.par_home.par_search;



import database.ParDsGateway;
import database.ParFileUser;
import controller_presenter_view.common_controller_presenter.extract_information.ExtractInfoController;
import use_cases.extract_information_use_case.ExtractInfoInputBoundary;
import use_cases.extract_information_use_case.ExtractInfoInteractor;
import use_cases.extract_information_use_case.ExtractInfoResponseModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static controller_presenter_view.screens.ScreenConstants.getConstantX;
import static controller_presenter_view.screens.ScreenConstants.getConstantY;


public class ParSearchOrgResultsPage extends JFrame {

    private final ArrayList<String> orgNames;
    final ArrayList<String> followedList;
    private final String parUsername;
    final ParDsGateway p = new ParFileUser();

    /**The main method for creating the search results page.
     *
     * @param orgNames An ArrayList<String> containing all the search results
     * @param parUsername A string containing the participant's username
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public ParSearchOrgResultsPage(ArrayList<String> orgNames, String parUsername) throws ClassNotFoundException {

        this.parUsername = parUsername;
        this.orgNames = orgNames;

        ExtractInfoInputBoundary interactor1 = new ExtractInfoInteractor(p);
        ExtractInfoController controller1 = new ExtractInfoController(interactor1);
        ExtractInfoResponseModel<String> response1 = controller1.extractPar("getFollowedOrg", parUsername);

        this.followedList= response1.getAl();


        this.setLayout(null);

        this.setSize(getConstantX(), getConstantY());

        this.setLocationRelativeTo(null);

        JLabel title = new JLabel("Organizer Search Results");
        title.setBounds(0, 0, getConstantX(), 50);
        title.setHorizontalAlignment(JLabel.CENTER);


        JButton back = new JButton("Back");
        back.addActionListener(new ParSearchOrgResultsPageActionListener(this, "none"));
        back.setBounds(0, 100, 150, 30);

        JPanel organizers = new JPanel();
        organizers.setBounds(150, 100, getConstantX() - 170, getConstantY() - 150);

        int numberOrg = orgNames.size();
        if (numberOrg != 0) {

            organizers.setLayout(new GridLayout(numberOrg, 0, 10, 10));

            int x = 0;
            int y = 0;

            for (String nextOrg : orgNames) {

                JButton orgName = new JButton(nextOrg);
                orgName.addActionListener(new ParSearchOrgResultsPageActionListener(this, nextOrg));
                orgName.setBounds(x, y, 250, 30);
                organizers.add(orgName);
                orgName.setVisible(true);


                if (this.followedList.contains(nextOrg)) {
                    JButton unfollow = new JButton("Unfollow");
                    unfollow.setActionCommand("Unfollow " + nextOrg);
                    unfollow.addActionListener(new ParSearchOrgResultsPageActionListener(this, nextOrg));
                    unfollow.setBounds(x, y, 250, 30);
                    organizers.add(unfollow);
                    unfollow.setVisible(true);

                } else {
                    JButton follow = new JButton("Follow");
                    follow.setActionCommand("Follow " + nextOrg);
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

    /**This method will be called in ParSearchOrgResultsPageActionListener.
     * @return it will return a string which is participant's username.
     */
    public String getParUsername() {
        return parUsername;
    }

    /**This method will be called in ParSearchOrgResultsPageActionListener.
     * @return it will return an ArrayList<string> which is participant's username.
     */
    public ArrayList<String> getOrgNames() {
        return orgNames;
    }
}