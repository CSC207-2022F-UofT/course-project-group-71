package screens.par_follow_org_screens;

import javax.swing.*;

public class SuccessViewModel {

    private String orgName;

    public SuccessViewModel(String orgName){
        this.orgName=orgName;
        JFrame frame= new JFrame();
        JPanel panelMain= new JPanel();
        panelMain.add(new JLabel("You Are Following Organizer:"+ this.orgName, SwingConstants.CENTER));
        frame.setContentPane(panelMain);
        frame.setBounds(600,300,250,200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }



}

