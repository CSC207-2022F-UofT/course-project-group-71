package use_cases.org_edit_event_use_case;

import database.OrgDsGateway;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class OrgEditEventInteractor implements OrgEditEventInputBoundary {

    final OrgDsGateway orgDsGateway;
    final OrgEditEventOutputBoundary orgEditEventOutputBoundary;


    /**Constructor
     *
     * @param orgDsGateway The database gateway of the organizers
     * @param orgEditEventOutputBoundary The OutputBoundary used to show success or not of event editing
     */
    public OrgEditEventInteractor(OrgDsGateway orgDsGateway,
                                  OrgEditEventOutputBoundary orgEditEventOutputBoundary) {
        this.orgDsGateway = orgDsGateway;
        this.orgEditEventOutputBoundary = orgEditEventOutputBoundary;
    }

    /**Use the information contained in the requestModel to edit ana event and return a responseModel.
     * It checks if all entries are non-empty: title, description, year, month, day, hour, minute, location.
     * It checks if all time entries are bound by format: year, month, day, hour, minute.
     * It checks if the time is set in the future.
     * If failed in one of the above process, return a failure response.
     * Otherwise, success response is returned.
     * Note: the edit method resets all event's information excepts for its title.
     *
     * @param requestModel The request model sent to the interactor
     * @return A responseModel representing whether the event editing is successful
     */
    @Override
    public OrgEditEventResponseModel edit(OrgEditEventRequestModel requestModel) throws SQLException, ClassNotFoundException {
        //checks if all entries are non-empty: description, year, month, day, hour, minute, location.
        if (requestModel.getDescription().isEmpty()
                || requestModel.getYear().isEmpty() || requestModel.getMonth().isEmpty()
                || requestModel.getDay().isEmpty() || requestModel.getHour().isEmpty()
                || requestModel.getMinute().isEmpty() || requestModel.getLocation().isEmpty()) {
            return orgEditEventOutputBoundary.prepareFailView("Entries cannot be empty.");
        }

        if (requestModel.getDescription().length() > 200) {
            return orgEditEventOutputBoundary.prepareFailView("Description should be no longer than 200 characters.");
        }

        if (requestModel.getLocation().length() > 50) {
            return orgEditEventOutputBoundary.prepareFailView("Location should be no longer than 50 characters.");
        }

        String year = requestModel.getYear();
        String month = requestModel.getMonth();
        String day = requestModel.getDay();
        String hour = requestModel.getHour();
        String minute = requestModel.getMinute();

        //checks if all time entries can be converted to integer
        if (isStringInt(year) && isStringInt(month) && isStringInt(day) && isStringInt(hour) && isStringInt(minute)) {
            if (year.length() != 4) {
                return orgEditEventOutputBoundary.prepareFailView("Year is not 4 digits.");
            }
            int y = Integer.parseInt(year);

            int m = Integer.parseInt(month);
            if (m > 12 || m <= 0) {
                return orgEditEventOutputBoundary.prepareFailView("Month is not within 1 to 12.");
            }

            int d = Integer.parseInt(day);
            if (d > 31 || d <= 0) {
                return orgEditEventOutputBoundary.prepareFailView("Day is not within 1 to 31.");
            }

            int h = Integer.parseInt(hour);
            if (h > 23 || h < 0) {
                return orgEditEventOutputBoundary.prepareFailView("Hour is not within 0 to 24.");
            }

            int min = Integer.parseInt(minute);
            if (min > 59 || min < 0) {
                return orgEditEventOutputBoundary.prepareFailView("Minute is not within 0 to 60.");
            }

            LocalDateTime now = LocalDateTime.now();
            LocalDateTime time = LocalDateTime.of(y, m, d, h, min);

            //checks if the time is set in the future.
            if (time.isBefore(now)){
                System.out.println("5");
                return orgEditEventOutputBoundary.prepareFailView("Time must be in future.");
            }

            //call orgDsGateway to edit the event, and return the responseModel with the event's title
            else {
                orgDsGateway.editAnEvent(requestModel.getTitle(), requestModel.getDescription(),
                        requestModel.getLocation(), y, m, d, h, min);
                OrgEditEventResponseModel responseModel = new OrgEditEventResponseModel(requestModel.getTitle());
                return orgEditEventOutputBoundary.prepareSuccessView(responseModel);
            }
        }

        else { return orgEditEventOutputBoundary.prepareFailView("Time entry/ies is/are not integer."); }
    }

    /**A method used to check time entries format
     *
     * @param s A string of a time entry.
     * @return A boolean of whether the entry is bound by format.
     */
    public boolean isStringInt(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }
}
