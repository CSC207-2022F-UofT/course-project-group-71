package controller_presenter_view.screens.par_account;

import controller_presenter_view.screens.CommonMethod;

import javax.swing.*;

import static controller_presenter_view.screens.ScreenConstants.getConstantX;
import static controller_presenter_view.screens.ScreenConstants.getConstantY;



public class ParAccountPage extends JFrame {
    final String parUsername;
    final JPasswordField oldPassword = new JPasswordField(15);
    final JPasswordField newPassword = new JPasswordField(15);
    final JPasswordField retypeNewPassword = new JPasswordField(15);

    /**The username of the participant, the page use this name to find relevant information from the database.
     * And generating the page.
     *
     * @param parUsername The participant username
     */
    public ParAccountPage(String parUsername){
        this.parUsername = parUsername;
        this.setLayout(null);
        this.setSize(getConstantX(), getConstantY());
        this.setLocationRelativeTo(null);

        JButton resetPassword = new JButton("Reset Password");
        resetPassword.addActionListener(new ParAccountActionListener(this));

        JPanel button = new JPanel();
        button.add(resetPassword);
        button.setBounds (150,280, 500, 30);

        JButton back = new JButton("Back");
        back.addActionListener(new ParAccountActionListener(this));
        back.setBounds(0, 100, 150, 30);

        //Add the buttons and text panels to the page
        this.add(CommonMethod.create_JLabel(this.parUsername + "'s Account Page", 0, 0, getConstantX(), 50));
        this.add(back);
        this.add(CommonMethod.create_JLabel("Username                      " + this.parUsername + "                "
                , 150, 100, 500,30));
        this.add(CommonMethod.create_text_panel("Old Password", oldPassword, 150, 130, 500, 50));
        this.add(CommonMethod.create_text_panel("New Password",  newPassword, 150, 180, 500, 50));
        this.add(CommonMethod.create_text_panel("Retype New Password", retypeNewPassword, 150, 230, 500, 50));
        this.add(button);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    /**This method will be called in ParAccountActionListener.
     * @return it will return a string which is participant's username.
     */
    public String getParUsername() {
        return parUsername;
    }
}