package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgHomePage extends JFrame {

    private String orgUsername;
    public OrgHomePage(String orgUsername){

        this.setLayout(null);

        this.setSize(500,500);

        this.setLocationRelativeTo(null);


        JLabel title = new JLabel(orgUsername + "'s Home Page");
        title.setBounds (0,0, 500, 50);
        title.setHorizontalAlignment(JLabel.CENTER);

        JButton account = new JButton("Account");
        account.addActionListener(new OrgHomeActionListener(this));
        account.setBounds (0,100, 150, 30);

        JButton unpublishedEvent = new JButton("Unpublished Event");
        unpublishedEvent.addActionListener(new OrgHomeActionListener(this));
        unpublishedEvent.setBounds (0,150, 150, 30);

        JButton upcomingEvent = new JButton("Upcoming Event");
        upcomingEvent.addActionListener(new OrgHomeActionListener(this));
        upcomingEvent.setBounds (0,180, 150, 30);

        JButton pastEvent = new JButton("Past Event");
        pastEvent.addActionListener(new OrgHomeActionListener(this));
        pastEvent.setBounds (0,210, 150, 30);

        JButton follower = new JButton("Follower");
        follower.addActionListener(new OrgHomeActionListener(this));
        follower.setBounds (0,240, 150, 30);

        this.add(title);
        this.add(account);
        this.add(unpublishedEvent);
        this.add(upcomingEvent);
        this.add(pastEvent);
        this.add(follower);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }
/*
    public class OrgHomePage extends JPanel implements ActionListener {

        private String orgUsername;
        OrgPageController orgPageController;

        /**
         * A window with a title and a JButton.

        public OrgHomePage(String orgUsername, OrgPageController orgPageController) {

            this.orgUsername = orgUsername;
            this.orgPageController = orgPageController;
            //this.orgDsGateway = orgDsGateway;
            //  this.eventDsGateway = eventDsGateway;
            //  this.orgNotifyEventController = orgNotifyEventController;

            JLabel title = new JLabel(orgUsername + "'s Home Page");
            title.setAlignmentX(Component.CENTER_ALIGNMENT);

            JPanel menu = new JPanel();
            menu.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            JButton account = new JButton("Account");
            account.setAlignmentX(Component.CENTER_ALIGNMENT);
            account.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    //跳转到AccountPage
                }
            });

            JButton unpublishedEvent = new JButton("Unpublished Event");
            unpublishedEvent.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    //跳转到OrgUnpublishedEventPage
                }
            });

            JButton upcomingEvent = new JButton("Upcoming Event");
            upcomingEvent.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    this.setVisible(false);
                    OrgUpcomingEventPage orgUpcomingEventPage = new OrgUpcomingEventPage(orgUsername, orgPageController);
                    orgPageController.jump(orgUsername,"Upcoming Event");
                    orgUpcomingEventPage.setVisible(true);
                }

                private void setVisible(boolean b) {
                }
            });

            JButton pastEvent = new JButton("Past Event");
            pastEvent.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    //跳转到OrgUpcomingEventPage
                }
            });

            JButton follower = new JButton("Follower");
            follower.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    //跳转到OrgUpcomingEventPage
                }
            });

            menu.add(account);
            menu.add(unpublishedEvent);
            menu.add(upcomingEvent);
            menu.add(pastEvent);
            menu.add(follower);

            JPanel undecided = new JPanel();

            this.setLayout(new BorderLayout());
            this.add(title, BorderLayout.NORTH);
            this.add(menu, BorderLayout.WEST);
            this.add(undecided, BorderLayout.CENTER);

        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
*/
}
