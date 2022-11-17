package user_reset_password_use_case.viewModel;

import javax.swing.*;

public class NewPasswordNotMatch {

    private final String message;

    public static void main(String[] args) {
        OldPasswordNotCorrect b = new OldPasswordNotCorrect("New Passwords do not match.");
        b.GeneratePage();
    }
    public NewPasswordNotMatch(String message) {
        this.message = message;
    }

    public void GeneratePage() {
        JFrame jf = new JFrame("");
        jf.setBounds(500, 250, 400, 300);

        JLabel jLabel = new JLabel(this.message, SwingConstants.CENTER);
        jf.add(jLabel);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
