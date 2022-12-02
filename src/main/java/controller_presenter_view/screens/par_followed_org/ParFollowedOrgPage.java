package controller_presenter_view.screens.par_followed_org;

import controller_presenter_view.screens.Util_Method;
import database.*;
import controller_presenter_view.common_controller_presenter.extract_information.ExtractInfoController;
import use_cases.extract_information_use_case.ExtractInfoInputBoundary;
import use_cases.extract_information_use_case.ExtractInfoInteractor;
import use_cases.extract_information_use_case.ExtractInfoResponseModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static controller_presenter_view.screens.screen_constants.getConstantX;
import static controller_presenter_view.screens.screen_constants.getConstantY;


public class ParFollowedOrgPage extends JFrame {
    private final String parUsername;

    /**The page that displays the participant's followed organizers.
     *
     * @param parUsername The username of the participant
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public ParFollowedOrgPage(String parUsername) throws ClassNotFoundException {
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

        JPanel followedOrg = new JPanel();
        followedOrg.setBounds(150,100,getConstantX()-170,getConstantY()-150);

        //put followed organizations' username in the JPanel followedOrg, and return the number of organizations
        int numberOfOrg = generateFollowedOrg(followedOrg);
        
        JLabel number = new JLabel("Total Number of Followed Organizations: " + numberOfOrg);
        JPanel followedN = new JPanel();
        followedN.add(number);
        followedN.setBounds(0,50, getConstantX(),40);

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
    
    public int generateFollowedOrg(JPanel followedOrganization) throws ClassNotFoundException {
        ParDsGateway parDsGateway = new ParFileUser();
        ExtractInfoInputBoundary interactor = new ExtractInfoInteractor(parDsGateway);
        ExtractInfoController controller = new ExtractInfoController(interactor);
        ExtractInfoResponseModel<String> response1= controller.extractPar("getFollowedOrg",
                this.parUsername);
        ArrayList<String> followedOrg = response1.getAl();

        int numberOfOrg = followedOrg.size();
        if (numberOfOrg != 0) {
            followedOrganization.setLayout(new GridLayout(numberOfOrg, 0, 10, 10));
            int x = 0;
            int y = 0;
            for (String orgUsername : followedOrg) {
                JButton organization = new JButton(orgUsername);
                organization.addActionListener(new ParFollowedOrgActionListener(this, orgUsername));
                organization.setBounds(x, y, 250, 30);
                organization.setVisible(true);
                JButton unFollow = new JButton("UnFollow");
                unFollow.setActionCommand(orgUsername + "UnFollow");
                unFollow.addActionListener(new ParFollowedOrgActionListener(this, orgUsername));
                unFollow.setBounds(x + 250, y + 55, 100, 30);
                unFollow.setVisible(true);
                followedOrganization.add(organization);
                followedOrganization.add(unFollow);
                y += 100;
            }
            //Put the JPanel into a JScrollPane
            JScrollPane followerScroll = Util_Method.generateJScrollPane(followedOrganization);
            this.add(followerScroll);
        }
        return numberOfOrg;
    }
}
