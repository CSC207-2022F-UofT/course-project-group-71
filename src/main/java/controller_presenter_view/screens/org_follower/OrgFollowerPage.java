package controller_presenter_view.screens.org_follower;

import controller_presenter_view.common_controller_presenter.extract_information.ExtractInfoController;
import database.*;
import use_cases.extract_information_use_case.ExtractInfoInputBoundary;
import use_cases.extract_information_use_case.ExtractInfoInteractor;
import use_cases.extract_information_use_case.ExtractInfoResponseModel;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static controller_presenter_view.screens.screen_constants.getConstantX;
import static controller_presenter_view.screens.screen_constants.getConstantY;


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

        //Add a button "Back", clicking it will come back to last page
        JButton back = new JButton("Back");
        back.addActionListener(new OrgFollowerActionListener(this));
        back.setBounds(0, 100, 150, 30);

        //Create a JPanel to store followers
        JPanel followers = new JPanel();
        followers.setBounds(150,100,getConstantX()-170,getConstantY()-150);

        //Obtain OrgDsGateway and followers
        OrgDsGateway orgDsGateway = new OrgFileUser();


        ExtractInfoInputBoundary interactor = new ExtractInfoInteractor(orgDsGateway);
        ExtractInfoController extractInfoController = new ExtractInfoController(interactor);
        ExtractInfoResponseModel<String> responseModel = extractInfoController.extractOrg("getFollowers", this.orgUsername);
        ArrayList<String> Followers = responseModel.getAl();


        int numberOfFollower = Followers.size();
        JLabel number = new JLabel("Total Number of Followers: " + numberOfFollower);
        JPanel followerN = new JPanel();
        followerN.add(number);
        followerN.setBounds(0,50, getConstantX(),40);

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
            //Set the followerScroll as the container of followers JPanel
            JScrollPane followerScroll = new JScrollPane(followers);
            followerScroll.setBounds(150, 100, getConstantX() - 170, getConstantY() - 150);
            followerScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            followerScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            followerScroll.setVisible(true);
            //Add the followerScroll back to the screen
            this.add(followerScroll);
        }

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
}
