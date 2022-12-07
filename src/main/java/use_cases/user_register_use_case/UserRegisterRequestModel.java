package use_cases.user_register_use_case;

/** The request model of user registration.
 *  Contains whether organizer or participant, username, password and second-input password.
 */
public class UserRegisterRequestModel {

    final String isParticipant;
    final String isOrganization;
    final String username;
    final String password;
    final String re_password;

    /**A request model sent the interactor to create a user.
     *
     * @param isParticipant String showing the user choose to create a participant
     * @param isOrganization String showing the user choose to create an organization
     * @param username The username of the user registration
     * @param password The password of the user registration
     * @param re_password The second input password of the user registration
     */
    public UserRegisterRequestModel(String isParticipant, String isOrganization, String username, String password, String re_password){
        this.isParticipant = isParticipant;
        this.isOrganization = isOrganization;
        this.username = username;
        this.password = password;
        this.re_password = re_password;
    }

    /**A method to get the username of the participant from teh request model.
     *
     * @return Name of the participant currently registering
     */
    public String getUsername() {
        return username;
    }

    /**A method to get the password (First one inputted) of the participant from teh request model.
     *
     * @return Password of the participant currently registering
     */
    public String getPassword() {
        return password;
    }

    /**A method to get the password (Second one inputted) of the participant from the request model.
     *
     * @return Password of the participant currently registering
     */
    public String getRe_password() {
        return re_password;
    }

    /**A method used to get the type of the participant from the request model.
     *
     * @return The user type the participant choose to become
     */
    public String getUserType() {
        if (isParticipant.equals("P")) { return isParticipant; }
        else if (isOrganization.equals("O")) { return isOrganization; }
        else { return "N/A"; }
    }
}
