package screens.par_account;

import screens.LabelTextPanel;
import screens.org_account.OrgResetPasswordController;
import user_reset_password_use_case.UserResetPasswordResponseModel;

import static tutorial.HelloWorld.getConstantX;
import static tutorial.HelloWorld.getConstantY;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParAccountPage extends JFrame implements ActionListener {
    private final String parUsername;

    JPasswordField oldPassword = new JPasswordField(15);
    JPasswordField newPassword = new JPasswordField(15);
    JPasswordField retypeNewPassword = new JPasswordField(15);

    ParResetPasswordController parResetPasswordController;
    public ParAccountPage(String parUsername){
        this.parUsername = parUsername;

        this.setLayout(null);

        this.setSize(getConstantX(), getConstantY());

        this.setLocationRelativeTo(null);

        JLabel title = new JLabel(this.parUsername + "'s Account Page");
        title.setBounds(0, 0, getConstantX(), 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        JLabel username = new JLabel(" Username           " + this.parUsername);
        username.setBounds(150, 100, 500,30);

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
        resetPassword.setBounds (150,280, 150, 30);
        resetPassword.addActionListener(this);

        JButton back = new JButton("Back");
        back.addActionListener(new ParAccountActionListener(this));
        back.setBounds(0, 100, 150, 30);

        this.add(title);
        this.add(back);
        this.add(username);
        this.add(oldPasswordInfo);
        this.add(newPasswordInfo);
        this.add(retypeNewPasswordInfo);
        this.add(resetPassword);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    public String getParUsername() {
        return parUsername;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        UserResetPasswordResponseModel responseModel = parResetPasswordController.resetPassword(
                this.parUsername, String.valueOf(oldPassword.getPassword()), String.valueOf(newPassword.getPassword()),
                String.valueOf(retypeNewPassword.getPassword()));
        JOptionPane.showMessageDialog(this, responseModel.getMessage());
    }
}
