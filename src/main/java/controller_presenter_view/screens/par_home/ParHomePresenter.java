package controller_presenter_view.screens.par_home;

import use_cases.user_login_use_case.ParHomeOutputBoundary;
import use_cases.user_login_use_case.UserLoginResponseModel;

public class ParHomePresenter implements ParHomeOutputBoundary {
    /**The method prepare the home page view for the participant.
     *
     * @param participant The response model containing information to show sent from interactor
     * @return The exact response model, it will be sent out
     */
    public UserLoginResponseModel prepareHomePageView(UserLoginResponseModel participant){
        return participant;
    }
}
