package ParRegisterEventScreens;

import javax.swing.*;

public class ParRegisterEventSuccessfulView {
    private String message;

    public static void main(String[] args) {
        ParRegisterEventSuccessfulView a = new ParRegisterEventSuccessfulView("Congratulation! You registered this event successfully.");
            a.GeneratePage();
        }


    public ParRegisterEventSuccessfulView(String message){
            this.message = message;
        }

    public void GeneratePage(){
        JFrame b = new JFrame("Success");
        b.setBounds(500, 250, 400, 300);

        JLabel label = new JLabel(this.message, SwingConstants.CENTER);
        b.add(label);

        b.setVisible(true);
        b.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
}
