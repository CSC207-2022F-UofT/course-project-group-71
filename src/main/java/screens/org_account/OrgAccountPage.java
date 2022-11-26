package screens.org_account;

import screens.LabelTextPanel;

import javax.swing.*;

import static tutorial.HelloWorld.getConstantX;
import static tutorial.HelloWorld.getConstantY;

public class OrgAccountPage extends JFrame {
    private final String orgUsername;
    JPasswordField oldPassword = new JPasswordField(15);
    JPasswordField newPassword = new JPasswordField(15);
    JPasswordField retypeNewPassword = new JPasswordField(15);

    /**The method generate a Organization Account page and allowed the organization to reset password.
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
        JLabel title = new JLabel(this.orgUsername + "'s Account Page");
        title.setBounds(0, 0, getConstantX(), 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        //Set the username label
        JLabel username = new JLabel("Username                      " + this.orgUsername + "                ");
        username.setBounds(150, 100, 500,30);
        username.setHorizontalAlignment(JLabel.CENTER);

        //A Text panel to input the old password
        LabelTextPanel oldPasswordInfo = new LabelTextPanel(
                new JLabel("Old Password"), oldPassword);
        oldPasswordInfo.setBounds (150,130, 500, 50);

        //A Test panel to input the new pasword
        LabelTextPanel newPasswordInfo = new LabelTextPanel(
                new JLabel("New Password"), newPassword);
        newPasswordInfo.setBounds (150,180, 500, 50);

        //A Test panel to re-input the new password
        LabelTextPanel retypeNewPasswordInfo = new LabelTextPanel(
                new JLabel("Retype New Password"), retypeNewPassword);
        retypeNewPasswordInfo.setBounds (150,230, 500, 50);

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

        //Add the buttons to the page
        this.add(title);
        this.add(back);
        this.add(username);
        this.add(oldPasswordInfo);
        this.add(newPasswordInfo);
        this.add(retypeNewPasswordInfo);
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
