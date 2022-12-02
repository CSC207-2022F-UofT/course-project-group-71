package controller_presenter_view.screens.org_account;

import controller_presenter_view.screens.CommonMethod;
import javax.swing.*;
import static controller_presenter_view.screens.ScreenConstants.getConstantX;
import static controller_presenter_view.screens.ScreenConstants.getConstantY;


public class OrgAccountPage extends JFrame {
    final String orgUsername;
    final JPasswordField oldPassword = new JPasswordField(15);
    final JPasswordField newPassword = new JPasswordField(15);
    final JPasswordField retypeNewPassword = new JPasswordField(15);

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
        this.add(CommonMethod.create_JLabel(this.orgUsername + "'s Account Page", 0, 0, getConstantX(), 50));
        this.add(back);
        this.add(CommonMethod.create_JLabel("Username                      " + this.orgUsername + "                ",
                150, 100, 500,30));
        this.add(CommonMethod.create_text_panel("Old Password", oldPassword, 150, 130, 500, 50));
        this.add(CommonMethod.create_text_panel("New Password", newPassword, 150, 180, 500, 50));
        this.add(CommonMethod.create_text_panel("Retype New Password", retypeNewPassword, 150, 230, 500, 50));
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
