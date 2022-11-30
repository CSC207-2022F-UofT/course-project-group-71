package controller_presenter_view.screens.org_account;

import controller_presenter_view.screens.LabelTextPanel;

import javax.swing.*;

import static controller_presenter_view.screens.screen_constants.getConstantX;
import static controller_presenter_view.screens.screen_constants.getConstantY;


public class OrgAccountPage extends JFrame {
    final String orgUsername;
    final JPasswordField oldPassword = new JPasswordField(15);
    final JPasswordField newPassword = new JPasswordField(15);
    final JPasswordField retypeNewPassword = new JPasswordField(15);

    /**
     * This is the function to generate a label text panel
     * @param text the text we want to show
     * @param J the JPasswordField
     * @param x the integer x for set bounds
     * @param y the integer y for set bounds
     * @param width the integer representing the width for set bounds
     * @param height the integer representing the height for set bounds
     * @return a text panel
     */
    public LabelTextPanel create_text_panel(String text, JPasswordField J, int x, int y, int width, int height){
        LabelTextPanel output = new LabelTextPanel(
                new JLabel(text), J);
        output.setBounds (x,y, width, height);
        return output;
    }

    /**
     * This is the function to generate a JLabel
     * @param text the text we want to show
     * @param x the integer x for set bounds
     * @param y the integer y for set bounds
     * @param width the integer representing the width for set bounds
     * @param height the integer representing the height for set bounds
     * @return a text panel
     */
    public JLabel create_Jlable(String text, int x, int y, int width, int height){
        JLabel output = new JLabel(text);
        output.setBounds(x, y, width, height);
        output.setHorizontalAlignment(JLabel.CENTER);
        return output;
    }

    /**The method generate an Organization Account page and allowed the organization to reset password.
     * It contains a title with organization's username.
     * It allows user to input old and new password to reset password with a button called "Reset Password".
     * There is a button "back" which directed the Organization back to the home page.
     *
     * @param orgUsername the username of the organization.
     */

    public OrgAccountPage(String orgUsername){
        this.orgUsername = orgUsername;

        //Set basic parameters for the page
        this.setLayout(null);
        this.setSize(getConstantX(), getConstantY());
        this.setLocationRelativeTo(null);

        //Set the title
//        JLabel title = new JLabel(this.orgUsername + "'s Account Page");
//        title.setBounds(0, 0, getConstantX(), 50);
//        title.setHorizontalAlignment(JLabel.CENTER);

        //Set the username label
//        JLabel username = new JLabel("Username                      " + this.orgUsername + "                ");
//        username.setBounds(150, 100, 500,30);
//        username.setHorizontalAlignment(JLabel.CENTER);

        //A Text panel to input the old password
//        LabelTextPanel oldPasswordInfo = new LabelTextPanel(
//                new JLabel("Old Password"), oldPassword);
//        oldPasswordInfo.setBounds (150,130, 500, 50);
        // create_text_panel("Old Password", oldPassword, 150, 130, 500, 50);

        //A Test panel to input the new password
//        LabelTextPanel newPasswordInfo = new LabelTextPanel(
//                new JLabel("New Password"), newPassword);
//        newPasswordInfo.setBounds (150,180, 500, 50);

        //A Test panel to re-input the new password
//        LabelTextPanel retypeNewPasswordInfo = new LabelTextPanel(
//                new JLabel("Retype New Password"), retypeNewPassword);
//        retypeNewPasswordInfo.setBounds (150,230, 500, 50);

        //A button to reset password
        JButton resetPassword = new JButton("Reset Password");
        resetPassword.addActionListener(new OrgAccountActionListener(this));

        //Add JButton in a Button
        JPanel button = new JPanel();
        button.add(resetPassword);
        button.setBounds (150,280, 500, 30);

        //A button to go back to the home page
        JButton back = new JButton("Back");
        back.addActionListener(new OrgAccountActionListener(this));
        back.setBounds(0, 100, 150, 30);

        //Add the buttons and text panels to the page
        this.add(create_Jlable(this.orgUsername + "'s Account Page", 0, 0, getConstantX(), 50));
        this.add(back);
        this.add(        create_Jlable("Username                      " + this.orgUsername + "                "
                , 150, 100, 500,30));
        this.add(create_text_panel("Old Password", oldPassword, 150, 130, 500, 50));
        this.add(create_text_panel("New Password",  newPassword, 150, 180, 500, 50));
        this.add(create_text_panel("Retype New Password", retypeNewPassword, 150, 230, 500, 50));
        this.add(button);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    /**This method will be called in OrgAccountEventActionListener.
     * @return it will return a string which is organization's username.
     */
    public String getOrgUsername(){
        //Return the username of organizer
        return orgUsername;
    }
}
