package screens.org_follower;

import database.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static tutorial.HelloWorld.getConstantX;
import static tutorial.HelloWorld.getConstantY;

public class OrgFollowerPage extends JFrame {
    private String orgUsername;
    public OrgFollowerPage(String orgUsername){
        this.orgUsername = orgUsername;

        this.setLayout(null);

        this.setSize(getConstantX(), getConstantY());

        this.setLocationRelativeTo(null);

        JLabel title = new JLabel(this.orgUsername + "'s Follower Page");
        title.setBounds(0, 0, getConstantX(), 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        JButton back = new JButton("Back");
        back.addActionListener(new OrgFollowerActionListener(this));
        back.setBounds(0, 100, 150, 30);

        JPanel events = new JPanel();
        events.setBounds(150,100,getConstantX()-170,getConstantY()-150);

        OrgDsGateway orgDsGateway = new OrgFileUser();
        EventDsGateway eventDsGateway = new EventFileUser();
        ParDsGateway parDsGateway = new ParFileUser();

        ArrayList<String> Followers = orgDsGateway.getFollowers(orgUsername);

        int numberOfEvent = Followers.size();

        if (numberOfEvent != 0) {

            events.setLayout(new GridLayout(numberOfEvent, 0, 10, 10));

            int x = 0;
            int y = 0;

            for (String follower : Followers) {

                JButton organization = new JButton(follower);
                organization.addActionListener(new OrgFollowerActionListener(this));
                organization.setBounds(x, y, 250, 30);
                organization.setVisible(true);

//                JButton unFollow = new JButton("UnFollow");
//                unFollow.setActionCommand(follower + "UnFollow");
//                unFollow.addActionListener(new ParFollowedOrgActionListener(this));
//                unFollow.setBounds(x + 250, y + 55, 100, 30);
//                unFollow.setVisible(true);

                events.add(organization);
//                events.add(eventTime);
//                events.add(eventLocation);
//                events.add(notify);
//                events.add(delete);
//                events.add(unFollow);
                y += 100;
            }

            JScrollPane followerscroll = new JScrollPane(events);
            followerscroll.setBounds(150, 100, getConstantX() - 170, getConstantY() - 150);
            followerscroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            followerscroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            followerscroll.setVisible(true);
            this.add(followerscroll);
        }

        this.add(title);
        this.add(back);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    public String getOrgUsername() {
        return orgUsername;
    }
}
