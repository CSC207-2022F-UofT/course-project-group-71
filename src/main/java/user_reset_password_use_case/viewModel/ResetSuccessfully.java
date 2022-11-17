package user_reset_password_use_case.viewModel;

import javax.swing.*;

public class ResetSuccessfully {

    private final String message;

    public static void main(String[] args) {
        OldPasswordNotCorrect b = new OldPasswordNotCorrect("Password reset successfully!");
        b.GeneratePage();
    }
    public ResetSuccessfully(String message) {
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
