package controller_presenter_view.screens.org_home;

import javax.swing.*;

import static controller_presenter_view.screens.screen_constants.getConstantX;
import static controller_presenter_view.screens.screen_constants.getConstantY;


public class OrgHomePage extends JFrame {

    private final String orgUsername;

    /**The method generate a page of organization's homepage.
     * It contains six buttons at left vertically.
     * "Account" button will jump to the account page which can let the organization to changes password.
     * "Unpublished Event" button will jump to the Unpublished Event page which can let the organization both create
     *      a new unpublished events or modify the unpublished events, they can publish, edit or delete specific events.
     * "Upcoming Event" button will jump to the Upcoming Event page which can let the organization
     *      notify the participants or delete the Upcoming events.
     * "Past Event" button will jump to the Past Event page which can let the organization delete specific past events.
     * "Followers" button will jump to the followers page which the organization can see all followers
     * There is a button "Log Out" at the button which logged the Organization out and jump to the login page.
     *
     * @param orgUsername the username of the organization.
     */
    public OrgHomePage(String orgUsername){

        this.orgUsername = orgUsername;

        this.setLayout(null);

        this.setSize(getConstantX(), getConstantY());

        this.setLocationRelativeTo(null);

        JLabel title = new JLabel(this.orgUsername + "'s Home Page");
        title.setBounds (0,0, getConstantX(), 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        this.add(title);
        this.add(create_JButton("Account", 0,150, 150, 30));
        this.add(create_JButton("Unpublished Event", 0,210, 150, 30));
        this.add(create_JButton("Upcoming Event", 0,270, 150, 30));
        this.add(create_JButton("Past Event", 0,330, 150, 30));
        this.add(create_JButton("Follower", 0,390, 150, 30));
        this.add(create_JButton("Log Out", 0,510, 150, 30));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    /**This method will be called in OrgHomeActionListener.
     * @return it will return a string which is organization's username.
     */
    public String getOrgUsername() {
        return this.orgUsername;
    }

    /**
     * This function returns a JButton with the input as set bounds
     * @param text string of the button showing
     * @param x the integer x for set bounds
     * @param y the integer y for set bounds
     * @param width the integer representing the width for set bounds
     * @param height the integer representing the height for set bounds
     * @return return the JButton
     */
    public JButton create_JButton(String text, int x, int y, int width, int height){
        JButton output = new JButton(text);
        output.addActionListener(new OrgHomeActionListener(this));
        output.setBounds (x, y, width, height);
        return output;
    }
}

