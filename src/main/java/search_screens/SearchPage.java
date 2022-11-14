package search_screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPage extends JFrame implements ActionListener {

    JLabel title;
    JTextField searchBox;
    JRadioButton org, eve;
    JButton search, home;
    ButtonGroup group;
    JPanel buttons1, buttons2, panelMain;


    public SearchPage() {

        this.title = new JLabel("Search Screen");
        this.title.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchBox = new JTextField(20);
        org = new JRadioButton("Organizer");
        eve = new JRadioButton("Event");


        //Turning on any button in the button group turns off all other buttons
        group = new ButtonGroup();
        group.add(org);
        group.add(eve);

        home = new JButton("Home");
        search = new JButton("Search");


        buttons1 = new JPanel();
        buttons1.add(org);
        buttons1.add(eve);

        buttons2 = new JPanel();
        buttons2.add(search);
        buttons2.add(home);

        panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.add(title);
        panelMain.add(searchBox);
        panelMain.add(buttons1);
        panelMain.add(buttons2);

        search.addActionListener(this);
        home.addActionListener(this);


        this.setContentPane(panelMain);
        this.setBounds(400, 300, 250, 180);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Search")) {
            if (org.isSelected()) {
                dispose();
                //c
            } else {
                dispose();
            }
        } else {
            dispose();
            //go back to home page
        }
    }


    public static void main(String[] args) {
        SearchPage p = new SearchPage();
    }
}
