package screens.par_account;

import screens.ScreenConstants;
import screens.UICreatorAssistant;

import javax.swing.*;


public class ParAccountPage extends JFrame {
    private final String parUsername;
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
        this.setSize(ScreenConstants.getConstantX(), ScreenConstants.getConstantY());
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
        this.add(UICreatorAssistant.create_JLabel(this.parUsername + "'s Account Page", 0, 0, ScreenConstants.getConstantX(), 50));
        this.add(back);
        this.add(UICreatorAssistant.create_JLabel("Username                      " + this.parUsername + "                "
                , 150, 100, 500,30));
        this.add(UICreatorAssistant.create_text_panel("Old Password", oldPassword, 150, 130, 500, 50));
        this.add(UICreatorAssistant.create_text_panel("New Password",  newPassword, 150, 180, 500, 50));
        this.add(UICreatorAssistant.create_text_panel("Retype New Password", retypeNewPassword, 150, 230, 500, 50));
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