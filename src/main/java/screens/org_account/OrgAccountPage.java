package screens.org_account;

import user_reset_password_use_case.UserResetPasswordResponseModel;
import screens.LabelTextPanel;

import static tutorial.HelloWorld.getConstantX;
import static tutorial.HelloWorld.getConstantY;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgAccountPage extends JFrame implements ActionListener {
    private String orgUsername;
    JPasswordField oldPassword = new JPasswordField(15);
    JPasswordField newPassword = new JPasswordField(15);
    JPasswordField retypeNewPassword = new JPasswordField(15);
    OrgResetPasswordController orgResetPasswordController;
    public OrgAccountPage(String orgUsername){
        this.orgUsername = orgUsername;

        this.setLayout(null);

        this.setSize(getConstantX(), getConstantY());

        this.setLocationRelativeTo(null);

        JLabel title = new JLabel(this.orgUsername + "'s Account Page");
        title.setBounds(0, 0, getConstantX(), 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        JLabel username = new JLabel(" Username           " + this.orgUsername);
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
        back.addActionListener(new OrgAccountActionListener(this));
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

    public String getOrgUsername() {
        return orgUsername;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UserResetPasswordResponseModel responseModel = orgResetPasswordController.resetPassword(
                this.orgUsername, String.valueOf(oldPassword.getPassword()), String.valueOf(newPassword.getPassword()),
                String.valueOf(retypeNewPassword.getPassword()));
        JOptionPane.showMessageDialog(this, responseModel.getMessage());
    }
}
