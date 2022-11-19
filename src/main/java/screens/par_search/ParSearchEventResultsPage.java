package screens.par_search;

import database.ParDsGateway;
import database.ParFileUser;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

import static tutorial.HelloWorld.getConstantX;
import static tutorial.HelloWorld.getConstantY;

public class ParSearchEventResultsPage extends JFrame {

    private ArrayList<String> eventNames;
    private String parUsername;

    ParDsGateway par = new ParFileUser();

    public ArrayList<String> getEventNames() {
        return eventNames;
    }

    public ParSearchEventResultsPage(ArrayList<String> eventNames, String parUserName) throws SQLException, ClassNotFoundException {

        this.eventNames = eventNames;
        this.parUsername = parUserName;
        ArrayList<String> eventFollowed = par.getUpcomingEvents(parUserName);

        this.setLayout(null);

        this.setSize(getConstantX(), getConstantY());

        this.setLocationRelativeTo(null);

        JLabel title = new JLabel("Event Search Results");
        title.setBounds(0, 0, getConstantX(), 50);
        title.setHorizontalAlignment(JLabel.CENTER);


        JButton back = new JButton("Back");
        back.addActionListener(new ParSearchEventResultsPageActionListener(this,"none"));
        back.setBounds(0, 100, 150, 30);

        JPanel events = new JPanel();
        events.setBounds(150, 100, getConstantX() - 170, getConstantY() - 150);

        int numberEvents = this.eventNames.size();
        if (numberEvents != 0) {

            events.setLayout(new GridLayout(numberEvents, 0, 10, 10));

            int x = 0;
            int y = 0;

            for (String nextEvent : this.eventNames) {

                JButton eventName = new JButton(nextEvent);
                eventName.addActionListener(new ParSearchEventResultsPageActionListener(this,nextEvent));
                eventName.setBounds(x, y, 250, 30);
                events.add(eventName);
                eventName.setVisible(true);


                if (eventFollowed.contains(nextEvent)) {
                    JButton join = new JButton("Leave");
                    join.setActionCommand("Leave "+nextEvent);
                    join.addActionListener(new ParSearchEventResultsPageActionListener(this,nextEvent));
                    join.setBounds(x, y, 250, 30);
                    events.add(join);
                    join.setVisible(true);
                } else {
                    JButton leave = new JButton("Join");
                    leave.setActionCommand("Join "+nextEvent);
                    leave.addActionListener(new ParSearchEventResultsPageActionListener(this,nextEvent));
                    leave.setBounds(x, y, 250, 30);
                    events.add(leave);
                    leave.setVisible(true);
                }


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





