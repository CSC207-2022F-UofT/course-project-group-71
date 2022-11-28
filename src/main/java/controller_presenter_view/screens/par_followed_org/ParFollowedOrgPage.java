package controller_presenter_view.screens.par_followed_org;

import database.*;
import controller_presenter_view.common_controller_presenter.extract_information.ExtractInfoController;
import use_cases.extract_information_use_case.ExtractInfoInputBoundary;
import use_cases.extract_information_use_case.ExtractInfoInteractor;
import use_cases.extract_information_use_case.ExtractInfoResponseModel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

import static controller_presenter_view.screens.screen_constants.getConstantX;
import static controller_presenter_view.screens.screen_constants.getConstantY;


public class ParFollowedOrgPage extends JFrame {
    private final String parUsername;

    /**The page that displays the participant's followed organizers.
     *
     * @param parUsername The username of the participant
     * @throws SQLException Exceptions raised from SQL
     * @throws ClassNotFoundException Exceptions raised from missing classes
     */
    public ParFollowedOrgPage(String parUsername) throws SQLException, ClassNotFoundException {
        this.parUsername = parUsername;

        this.setLayout(null);

        this.setSize(getConstantX(), getConstantY());

        this.setLocationRelativeTo(null);

        JLabel title = new JLabel(this.parUsername + "'s Followed Organization Page");
        title.setBounds(0, 0, getConstantX(), 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        JButton back = new JButton("Back");
        back.addActionListener(new ParFollowedOrgActionListener(this, "none"));
        back.setBounds(0, 100, 150, 30);

        JPanel events = new JPanel();
        events.setBounds(150,100,getConstantX()-170,getConstantY()-150);

        ParDsGateway parDsGateway = new ParFileUser();
        ExtractInfoInputBoundary interactor = new ExtractInfoInteractor(parDsGateway);
        ExtractInfoController controller = new ExtractInfoController(interactor);
        ExtractInfoResponseModel<String> response1= controller.extractPar("getFollowedOrg",
                this.parUsername);
        ArrayList<String> followedOrg = response1.getAl();

        int numberOfOrg = followedOrg.size();

        JLabel number = new JLabel("Total Number of Followed Organizations: " + numberOfOrg);
        JPanel followedN = new JPanel();
        followedN.add(number);
        followedN.setBounds(0,50, getConstantX(),40);

        if (numberOfOrg != 0) {

            events.setLayout(new GridLayout(numberOfOrg, 0, 10, 10));

            int x = 0;
            int y = 0;

            for (String orgname : followedOrg) {

                JButton organization = new JButton(orgname);
                organization.addActionListener(new ParFollowedOrgActionListener(this, orgname));
                organization.setBounds(x, y, 250, 30);
                organization.setVisible(true);

                JButton unFollow = new JButton("UnFollow");
                unFollow.setActionCommand(orgname + "UnFollow");
                unFollow.addActionListener(new ParFollowedOrgActionListener(this, orgname));
                unFollow.setBounds(x + 250, y + 55, 100, 30);
                unFollow.setVisible(true);

                events.add(organization);
                events.add(unFollow);
                y += 100;
            }

            JScrollPane followerscroll = new JScrollPane(events);
            followerscroll.setBounds(150, 100, getConstantX() - 170, getConstantY() - 150);
            followerscroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            followerscroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            followerscroll.setVisible(true);
            this.add(followerscroll);
        }

        this.add(title);
        this.add(followedN);
        this.add(back);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    /**A getter for the participant's username.
     *
     * @return The participant's username
     */
    public String getParUsername() {
        return parUsername;
    }
}
