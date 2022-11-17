package screens;

public class ShowMessageView extends RuntimeException {
    /**This class extends RunTimeException, so it would show a message by using an java default method.
     * It's not showing message by JPanel.
     *
     * @param message The message that need to be shown to the user
     */
    public ShowMessageView(String message) {
        super(message);
    }
}