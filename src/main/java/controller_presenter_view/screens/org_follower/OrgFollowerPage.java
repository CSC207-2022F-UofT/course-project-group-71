package controller_presenter_view.screens.org_follower;

import controller_presenter_view.common_controller_presenter.extract_information.ExtractInfoController;
import controller_presenter_view.screens.CommonMethod;
import database.*;
import use_cases.extract_information_use_case.ExtractInfoInputBoundary;
import use_cases.extract_information_use_case.ExtractInfoInteractor;
import use_cases.extract_information_use_case.ExtractInfoResponseModel;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static controller_presenter_view.screens.ScreenConstants.getConstantX;
import static controller_presenter_view.screens.ScreenConstants.getConstantY;


public class OrgFollowerPage extends JFrame {
    private final String orgUsername;

    /**The method generate a page of organizer's followers.
     * It contains all participants who followed the organization.
     * There is a button "back" which directed the Organization back to the home page.
     *
     * @param orgUsername the username of the organization.
     * @throws ClassNotFoundException when JDBC or MySQL class is not found.
     */
    public OrgFollowerPage(String orgUsername) throws ClassNotFoundException {
        this.orgUsername = orgUsername;

        //Set the parameter for the page
        this.setLayout(null);
        this.setSize(getConstantX(), getConstantY());
        this.setLocationRelativeTo(null);

        //Set the title of the followers' page
        JLabel title = new JLabel(this.orgUsername + "'s Follower Page");
        title.setBounds(0, 0, getConstantX(), 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        //Create the back button
        JButton back = new JButton("Back");
        back.addActionListener(new OrgFollowerActionListener(this));
        back.setBounds(0, 100, 150, 30);

        //Create a JPanel to store followers
        JPanel followers = new JPanel();
        followers.setBounds(150,100,getConstantX()-170,getConstantY()-150);

        //generate followers' username in the JPanel followers, and return the number of follower
        int numberOfFollower = generateFollowers(followers);

        //Create a JPanel to show total number of followers under page title
        JLabel number = new JLabel("Total Number of Followers: " + numberOfFollower);
        JPanel followerN = new JPanel();
        followerN.add(number);
        followerN.setBounds(0,50, getConstantX(),40);

        //Add the buttons to the screen
        this.add(title);
        this.add(followerN);
        this.add(back);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**This method will be called in OrgFollowerActionListener.
     * @return it will return a string which is organization's username.
     */
    public String getOrgUsername(){
        //Obtain the username of the organizer
        return orgUsername;
    }

    /**This method will generate events to fit into the JPanel events
     *
     * @param followers A JPanel that is designed to contain events
     */
    public int generateFollowers(JPanel followers) throws ClassNotFoundException {
        //Obtain OrgDsGateway and followers
        OrgDsGateway orgDsGateway = new OrgFileUser();
        ExtractInfoInputBoundary interactor = new ExtractInfoInteractor(orgDsGateway);
        ExtractInfoController extractInfoController = new ExtractInfoController(interactor);
        ExtractInfoResponseModel<String> responseModel;
        responseModel = extractInfoController.extractOrg("getFollowers", this.orgUsername);

        ArrayList<String> Followers = responseModel.getAl();
        int numberOfFollower = Followers.size();
        //If there are events, there's going to be a scrolling bar with information in it
        if (numberOfFollower != 0) {
            followers.setLayout(new GridLayout(numberOfFollower, 0, 10, 10));
            int x = 0;
            int y = 0;
            //Add all followers to the followers panel
            for (String follower : Followers) {
                //A Label with the followers' name, can't be used to click
                JLabel f = new JLabel(follower);
                f.setBounds(x, y, 250, 30);
                followers.add(f);
                y += 100;
            }
            //Put the JPanel into a JScrollPane
            JScrollPane followerScroll = CommonMethod.generateJScrollPane(followers);
            followerScroll.setVisible(true);
            this.add(followerScroll);
        }
        else {
            this.add(CommonMethod.create_JLabel("None", 0,100, getConstantX(),30));
        }
        return numberOfFollower;
    }
}
