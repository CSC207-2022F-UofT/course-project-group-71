package screens.search_screens;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static tutorial.HelloWorld.getConstantX;
import static tutorial.HelloWorld.getConstantY;

public class EventResultsPage extends JFrame {

    private ArrayList<String> eventNames;
    private String parUsername;

    public EventResultsPage( ArrayList<String> eventNames, String parUserName){

        this.eventNames=eventNames;
        this.parUsername= parUserName;

        this.setLayout(null);

        this.setSize(getConstantX(), getConstantY());

        this.setLocationRelativeTo(null);

        JLabel title = new JLabel("Event Search Results");
        title.setBounds(0, 0, getConstantX(), 50);
        title.setHorizontalAlignment(JLabel.CENTER);


        JButton back = new JButton("Back");
        back.addActionListener(new EventResultsPageActionListener(this));
        back.setBounds(0, 100, 150, 30);

        JPanel events = new JPanel();
        events.setBounds(150, 100, getConstantX() - 170, getConstantY() - 150);

        int numberEvents= this.eventNames.size();
        if (numberEvents != 0) {

            events.setLayout(new GridLayout(numberEvents, 0, 10, 10));

            int x = 0;
            int y = 0;

            for (String nextEvent : this.eventNames ) {

                JButton orgName = new JButton(nextEvent);
//                eventNames.addActionListener(new ParUpcomingEventActionListener(this));
                orgName.setBounds(x, y, 250, 30);
                orgName.setVisible(true);


                JButton join = new JButton("Join");
//              join.addActionListener(new OrganizerResultsPageActionListener(this));
                join.setBounds(x, y, 250, 30);
                join.setVisible(true);


                JButton leave = new JButton("Leave");
//                leave.addActionListener(new OrganizerResultsPageActionListener(this));
                leave.setBounds(x + 250, y + 15, 100, 30);
                leave.setVisible(true);


                events.add(orgName);
                events.add(join);
                events.add(leave);


                y += 100;
            }

            JScrollPane eventScroll = new JScrollPane(events);
            eventScroll.setBounds(150, 100, getConstantX() - 170, getConstantY() - 150);
            eventScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            eventScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            eventScroll.setVisible(true);
            this.add(eventScroll);
        }


        this.add(title);
        this.add(back);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }


    public String getParUsername() {
        return parUsername;
    }

}





