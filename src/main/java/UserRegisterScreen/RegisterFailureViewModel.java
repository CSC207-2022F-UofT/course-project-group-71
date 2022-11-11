package UserRegisterScreen;

import javax.swing.*;

public class RegisterFailureViewModel {
    private String message;



    public RegisterFailureViewModel(String message) {
        this.message = message;
    }

    public void GeneratePage(){
        JFrame jf = new JFrame();
        jf.setBounds(400,300,200,200);

        JLabel jLabel = new JLabel(this.message,SwingConstants.CENTER);
        jf.add(jLabel);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

}