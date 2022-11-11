package UserRegisterScreen;

import UserRegister.UserRegisterController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RegisterScreen extends JPanel {
    private UserRegisterController registercontroller;

    public RegisterScreen(UserRegisterController controller){
        this.registercontroller = controller;

        JFrame jf = new JFrame("Register");
        jf.setLayout(new FlowLayout(FlowLayout.LEFT));
        jf.setBounds(460,300,300,200);

        JLabel title = new JLabel("Register A user");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel label_username = new JLabel("Username");
        JTextField text_username = new JTextField("",20);
        JLabel label_password = new JLabel("Password");
        JTextField text_password = new JTextField("",20);
        JLabel label_re_password = new JLabel("Re_password");
        JTextField text_re_password = new JTextField("",20);

        jf.add(label_username);
        jf.add(text_username);
        jf.add(label_password);
        jf.add(text_password);
        jf.add(label_re_password);
        jf.add(text_re_password);

        ButtonGroup button_group = new ButtonGroup();
        JToggleButton Org_Button = new JToggleButton("Organizer");
        JToggleButton Par_Button = new JToggleButton("Participant");
        button_group.add(Org_Button);
        button_group.add(Par_Button);
        jf.add(Org_Button);
        jf.add(Par_Button);

        JButton button = new JButton("Register");
        jf.add(button);


        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = text_username.getText();
                System.out.println(username);
                String password = text_password.getText();
                String re_password = text_re_password.getText();
                boolean whether_org = Org_Button.isSelected();
                registercontroller.create(username, password, re_password, whether_org);

            }
        });
        jf.setResizable(false);
        button.setSize(40,20);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
