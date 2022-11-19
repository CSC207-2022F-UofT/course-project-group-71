package screens.par_account;

import screens.LabelTextPanel;

import javax.swing.*;

import static tutorial.HelloWorld.getConstantX;
import static tutorial.HelloWorld.getConstantY;

public class ParAccountPage extends JFrame {
    private final String parUsername;

    JPasswordField oldPassword = new JPasswordField(15);
    JPasswordField newPassword = new JPasswordField(15);
    JPasswordField retypeNewPassword = new JPasswordField(15);

    ParResetPasswordController parResetPasswordController;

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

        JLabel title = new JLabel(this.parUsername + "'s Account Page");
        title.setBounds(0, 0, getConstantX(), 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        JLabel username = new JLabel("Username                      " + this.parUsername + "                ");
        username.setBounds(150, 100, 500,30);
        username.setHorizontalAlignment(JLabel.CENTER);

        LabelTextPanel oldPasswordInfo = new LabelTextPanel(
                new JLabel("Old Password"), oldPassword);
        oldPasswordInfo.setBounds (150,130, 500, 50);

        LabelTextPanel newPasswordInfo = new LabelTextPanel(
                new JLabel("New Password"), newPassword);
        newPasswordInfo.setBounds (150,180, 500, 50);

        LabelTextPanel retypeNewPasswordInfo = new LabelTextPanel(
                new JLabel("Retype New Password"), retypeNewPassword);
        retypeNewPasswordInfo.setBounds (150,230, 500, 50);

        JButton resetPassword = new JButton("Reset Password");
        resetPassword.addActionListener(new ParAccountActionListener(this));

        JPanel button = new JPanel();
        button.add(resetPassword);
        button.setBounds (150,280, 500, 30);

        JButton back = new JButton("Back");
        back.addActionListener(new ParAccountActionListener(this));
        back.setBounds(0, 100, 150, 30);

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

    public String getParUsername() {
        return parUsername;
    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        UserResetPasswordResponseModel responseModel = null;
//        try {
//            responseModel = parResetPasswordController.resetPassword(
//                    this.parUsername, String.valueOf(oldPassword.getPassword()), String.valueOf(newPassword.getPassword()),
//                    String.valueOf(retypeNewPassword.getPassword()));
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        } catch (ClassNotFoundException ex) {
//            throw new RuntimeException(ex);
//        }
//        JOptionPane.showMessageDialog(this, responseModel.getMessage());
//    }
}
