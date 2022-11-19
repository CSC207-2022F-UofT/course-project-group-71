package org_create_event_use_case;

import database.EventDsGateway;
import database.OrgDsGateway;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class OrgCreateEventInteractor implements OrgCreateEventInputBoundary {

    EventDsGateway eventDsGateway;
    OrgDsGateway orgDsGateway;
    OrgCreateEventPresenter orgCreateEventPresenter;


    /**This is the construct method of OrgCreateEventInteractor.
     * It takes DsGateways and OutputBoundary as input to store as instances.
     *
     * @param eventDsGateway The database gateway of events
     * @param orgDsGateway The database gateway of organizers
     * @param orgCreateEventPresenter The OutputBoundary used to show success or not of event creation
     */
    public OrgCreateEventInteractor(EventDsGateway eventDsGateway,
                                    OrgDsGateway orgDsGateway,
                                    OrgCreateEventPresenter orgCreateEventPresenter) {
        this.eventDsGateway = eventDsGateway;
        this.orgDsGateway = orgDsGateway;
        this.orgCreateEventPresenter = orgCreateEventPresenter;
    }

    /**Use the information contained in the requestmodel to create a new event and respond a responsemodel.
     * It checks if all entries are non-empty: title, description, year, month, day, hour, minute, location.
     * It checks if title already exists.
     * It checks if all time entries are bound by format: year, month, day, hour, minute.
     * It checks if the time is set in the future.
     * If failed in one of the above process, return a failure response.
     * Otherwise, success response is returned.
     *
     * @param requestModel The request model sent to the interactor
     * @return A responsemodel representing whether the event creation is successful
     */
    @Override
    public OrgCreateEventResponseModel create(OrgCreateEventRequestModel requestModel) throws SQLException, ClassNotFoundException {
        if (requestModel.getTitle().isEmpty() || requestModel.getDescription().isEmpty()
                || requestModel.getYear().isEmpty() || requestModel.getMonth().isEmpty()
                || requestModel.getDay().isEmpty() || requestModel.getHour().isEmpty()
                || requestModel.getMinute().isEmpty() || requestModel.getLocation().isEmpty()) {
            return orgCreateEventPresenter.prepareFailView("Entries cannot be empty.");
        }

        if (eventDsGateway.checkIfEventNameExist(requestModel.getTitle())) {
            return orgCreateEventPresenter.prepareFailView("Title already exists.");
        }

        String year = requestModel.getYear();
        String month = requestModel.getMonth();
        String day = requestModel.getDay();
        String hour = requestModel.getHour();
        String minute = requestModel.getMinute();

        if (isStringInt(year) && isStringInt(month) && isStringInt(day) && isStringInt(hour) && isStringInt(minute)) {

            if (year.length() != 4) {
                return orgCreateEventPresenter.prepareFailView("Year is not 4 digits.");
            }
            int y = Integer.parseInt(year);

            int m = Integer.parseInt(month);
            if (m > 12 || m <= 0) {
                return orgCreateEventPresenter.prepareFailView("Month is not within 1 to 12.");
            }

            int d = Integer.parseInt(day);
            if (d > 31 || d <= 0) {
                return orgCreateEventPresenter.prepareFailView("Day is not within 1 to 31.");
            }

            int h = Integer.parseInt(hour);
            if (h > 23 || h < 0) {
                return orgCreateEventPresenter.prepareFailView("Day is not within 0 to 24.");
            }

            int min = Integer.parseInt(minute);
            if (min > 59 || min < 0) {
                return orgCreateEventPresenter.prepareFailView("Minute is not within 0 to 60.");
            }

            LocalDateTime now = LocalDateTime.now();
            LocalDateTime time = LocalDateTime.of(y, m, d, h, min);
            if (time.isBefore(now)){
                return orgCreateEventPresenter.prepareFailView("Time must be in future.");
            }

            else {
                orgDsGateway.createAnEvent(requestModel.getOrgUsername(), requestModel.getTitle(), 0,
                        requestModel.getDescription(), requestModel.getLocation(), y, m, d, h, min);
                OrgCreateEventResponseModel responseModel = new OrgCreateEventResponseModel(requestModel.getTitle());
                return orgCreateEventPresenter.prepareSuccessView(responseModel);
            }
        }

        else { return orgCreateEventPresenter.prepareFailView("Time entry/ies is/are not integer."); }
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
