package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgHomePage extends JFrame {

    public OrgHomePage(){
        this.setLayout(null);

        this.setSize(500,500);

        this.setLocationRelativeTo(null);
        JLabel title = new JLabel("Org Home Page");
        title.setBounds (0,0, 500, 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        this.add(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

}
