package org_create_event_use_case;

import database.EventDsGateway;
import database.OrgDsGateway;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class OrgCreateEventInteractor implements OrgCreateEventInputBoundary {

    EventDsGateway eventDsGateway;
    OrgDsGateway orgDsGateway;
    OrgCreateEventPresenter orgCreateEventPresenter;


    public OrgCreateEventInteractor(EventDsGateway eventDsGateway,
                                    OrgDsGateway orgDsGateway,
                                    OrgCreateEventPresenter orgCreateEventPresenter) {
        this.eventDsGateway = eventDsGateway;
        this.orgDsGateway = orgDsGateway;
        this.orgCreateEventPresenter = orgCreateEventPresenter;
    }

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
