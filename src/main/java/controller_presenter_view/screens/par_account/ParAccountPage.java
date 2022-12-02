package controller_presenter_view.screens.par_account;

import controller_presenter_view.screens.LabelTextPanel;

import javax.swing.*;

import static controller_presenter_view.screens.screen_constants.getConstantX;
import static controller_presenter_view.screens.screen_constants.getConstantY;



public class ParAccountPage extends JFrame {
    final String parUsername;
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
        this.add(create_Jlable(this.parUsername + "'s Account Page", 0, 0, getConstantX(), 50));
        this.add(back);
        this.add(create_Jlable("Username                      " + this.parUsername + "                "
                , 150, 100, 500,30));
        this.add(create_text_panel("Old Password", oldPassword, 150, 130, 500, 50));
        this.add(create_text_panel("New Password",  newPassword, 150, 180, 500, 50));
        this.add(create_text_panel("Retype New Password", retypeNewPassword, 150, 230, 500, 50));
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