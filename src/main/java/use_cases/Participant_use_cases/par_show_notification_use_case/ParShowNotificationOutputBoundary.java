package use_cases.par_show_notification_use_case;

public interface ParShowNotificationOutputBoundary {
    ParShowNotificationResponseModel prepareSuccessView(ParShowNotificationResponseModel responseModel);
    ParShowNotificationResponseModel prepareFailView(String message);
}