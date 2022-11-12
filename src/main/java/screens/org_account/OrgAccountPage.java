package screens.org_account;

import org_delete_event_use_case.OrgDeleteEventResponseModel;
import org_reset_password_use_case.OrgResetPasswordResponseModel;
import screens.LabelTextPanel;
import user_login_use_case.UserLoginResponseModel;

import static tutorial.HelloWorld.getConstantX;
import static tutorial.HelloWorld.getConstantY;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgAccountPage extends JFrame implements ActionListener {
    private String orgUsername;
    JPasswordField newPassword = new JPasswordField(15);
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
        username.setBounds(150, 100, 300,30);

        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Reset Password"), newPassword);
        passwordInfo.setBounds (150,130, 300, 50);

        JButton back = new JButton("Back");
        back.addActionListener(new OrgAccountActionListener(this));
        back.setBounds(0, 100, 150, 30);

        this.add(title);
        this.add(back);
        this.add(username);
        this.add(passwordInfo);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    public String getOrgUsername() {
        return orgUsername;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        OrgResetPasswordResponseModel responseModel = orgResetPasswordController.resetPassword(
                this.orgUsername, String.valueOf(newPassword.getPassword()));
        JOptionPane.showMessageDialog(this, responseModel.getMessage());
    }
}
