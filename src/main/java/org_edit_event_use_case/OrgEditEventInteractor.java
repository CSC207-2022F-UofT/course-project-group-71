package org_edit_event_use_case;

import database.EventDsGateway;
import database.OrgDsGateway;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class OrgEditEventInteractor implements OrgEditEventInputBoundary {

    EventDsGateway eventDsGateway;
    OrgDsGateway orgDsGateway;
    OrgEditEventPresenter orgEditEventPresenter;


    /**This is the construct method of OrgEditEventInteractor.
     * It takes DsGateways and Presenter as input to store as instances.
     *
     * @param eventDsGateway The database gateway of the events
     * @param orgDsGateway The database gateway of the organizers
     * @param orgEditEventPresenter The presenter used to show success or not of event editing
     */
    public OrgEditEventInteractor(EventDsGateway eventDsGateway,
                                  OrgDsGateway orgDsGateway,
                                  OrgEditEventPresenter orgEditEventPresenter) {
        this.eventDsGateway = eventDsGateway;
        this.orgDsGateway = orgDsGateway;
        this.orgEditEventPresenter = orgEditEventPresenter;
    }

    /**Use the information contained in the requestmodel to edit ana event and respond a responsemodel.
     * It checks if all entries are non-empty: title, description, year, month, day, hour, minute, location.
     * It checks if title already exists.
     * It checks if all time entries are bound by format: year, month, day, hour, minute.
     * It checks if the time is set in the future.
     * If failed in one of the above process, return a failure response.
     * Otherwise, success response is returned.
     *
     * @param requestModel The request model sent to the interactor
     * @return A responsemodel representing whether the event editing is successful
     */
    @Override
    public OrgEditEventResponseModel edit(OrgEditEventRequestModel requestModel) throws SQLException, ClassNotFoundException {
        if (requestModel.getTitle().isEmpty() || requestModel.getDescription().isEmpty()
                || requestModel.getYear().isEmpty() || requestModel.getMonth().isEmpty()
                || requestModel.getDay().isEmpty() || requestModel.getHour().isEmpty()
                || requestModel.getMinute().isEmpty() || requestModel.getLocation().isEmpty()) {
            return orgEditEventPresenter.prepareFailView("Entries cannot be empty.");
        }

        String year = requestModel.getYear();
        String month = requestModel.getMonth();
        String day = requestModel.getDay();
        String hour = requestModel.getHour();
        String minute = requestModel.getMinute();

        if (isStringInt(year) && isStringInt(month) && isStringInt(day) && isStringInt(hour) && isStringInt(minute)) {

            if (year.length() != 4) {
                return orgEditEventPresenter.prepareFailView("Year is not 4 digits.");
            }
            int y = Integer.parseInt(year);

            int m = Integer.parseInt(month);
            if (m > 12 || m <= 0) {
                return orgEditEventPresenter.prepareFailView("Month is not within 1 to 12.");
            }

            int d = Integer.parseInt(day);
            if (d > 31 || d <= 0) {
                return orgEditEventPresenter.prepareFailView("Day is not within 1 to 31.");
            }

            int h = Integer.parseInt(hour);
            if (h > 23 || h < 0) {
                return orgEditEventPresenter.prepareFailView("Day is not within 0 to 24.");
            }

            int min = Integer.parseInt(minute);
            if (min > 59 || min < 0) {
                return orgEditEventPresenter.prepareFailView("Minute is not within 0 to 60.");
            }

            LocalDateTime now = LocalDateTime.now();
            LocalDateTime time = LocalDateTime.of(y, m, d, h, min);
            if (time.isBefore(now)){
                return orgEditEventPresenter.prepareFailView("Time must be in future.");
            }

            else {
                orgDsGateway.editAnEvent(requestModel.getTitle(), requestModel.getDescription(),
                        requestModel.getLocation(), y, m, d, h, min);
                OrgEditEventResponseModel responseModel = new OrgEditEventResponseModel(requestModel.getTitle());
                return orgEditEventPresenter.prepareSuccessView(responseModel);
            }
        }

        else { return orgEditEventPresenter.prepareFailView("Time entry/ies is/are not integer."); }
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
