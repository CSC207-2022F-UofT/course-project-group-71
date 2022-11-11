package LoginTest;

import javax.swing.*;
import java.awt.*;

public class LoginScreen extends JPanel {
    public static void main(String[] args) {
        new LoginScreen(new OrgHomePageController(), new ParHomePageController(), new Logincontroller());
    }
    private OrgHomePageController orgcontroller;
    private ParHomePageController parcontroller;
    private Logincontroller logincontroller;

    public LoginScreen(OrgHomePageController orgcontroller, ParHomePageController parcontroller, Logincontroller logincontroller){
        this.orgcontroller = orgcontroller;
        this.parcontroller = parcontroller;
        this.logincontroller = logincontroller;

        JFrame jf = new JFrame("Login");
        jf.setLayout(new FlowLayout(FlowLayout.LEFT));
        jf.setBounds(460,300,300,200);

        JLabel title = new JLabel("Login A user");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel label_username = new JLabel("Username");
        JTextField text_username = new JTextField("",20);
        JLabel label_password = new JLabel("Password");
        JTextField text_password = new JTextField("",20);

        jf.add(label_username);
        jf.add(text_username);
        jf.add(label_password);
        jf.add(text_password);

        ButtonGroup button_group = new ButtonGroup();
        JToggleButton Org_Button = new JToggleButton("Organizer");
        JToggleButton Par_Button = new JToggleButton("Participant");
        button_group.add(Org_Button);
        button_group.add(Par_Button);
        jf.add(Org_Button);
        jf.add(Par_Button);

        JButton button = new JButton("Login");
        jf.add(button);


//        button.addActionListener(new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String username = text_username.getText();
//                String password = text_password.getText();
//                boolean whether_org = Org_Button.isSelected();
//                logincontroller.login(username, password, whether_org);
//                if (whether_org){
//                    orgcontroller.generateHomepage(username);
//                }else{
//                    parcontroller.generateHomepage(username);
//                }
//
//
//            }
//        });
        jf.setResizable(false);
        button.setSize(40,20);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
