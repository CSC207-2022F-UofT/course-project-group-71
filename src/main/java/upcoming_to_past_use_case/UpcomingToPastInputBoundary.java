package upcoming_to_past_use_case;

public interface UpcomingToPastInputBoundary {
    UpcomingToPastResponseModel convertToPast(UpcomingToPastRequestModel requestModel);
}
