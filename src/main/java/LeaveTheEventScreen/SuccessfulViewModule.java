package LeaveTheEventScreen;

import javax.swing.*;

public class SuccessfulViewModule {
    public static void main(String[] args) {
        JFrame jf = new JFrame(" ");
        jf.setBounds(500, 250, 400, 300);

        JLabel jLabel = new JLabel("You did not succeed in leaving this event", SwingConstants.CENTER);
        jf.add(jLabel);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
