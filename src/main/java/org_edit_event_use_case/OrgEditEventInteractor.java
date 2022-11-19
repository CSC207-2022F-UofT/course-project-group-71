package org_edit_event_use_case;

import database.EventDsGateway;
import database.OrgDsGateway;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class OrgEditEventInteractor implements OrgEditEventInputBoundary {

    EventDsGateway eventDsGateway;
    OrgDsGateway orgDsGateway;
    OrgEditEventOutputBoundary orgEditEventOutputBoundary;


    public OrgEditEventInteractor(EventDsGateway eventDsGateway,
                                  OrgDsGateway orgDsGateway,
                                  OrgEditEventOutputBoundary orgEditEventOutputBoundary) {
        this.eventDsGateway = eventDsGateway;
        this.orgDsGateway = orgDsGateway;
        this.orgEditEventOutputBoundary = orgEditEventOutputBoundary;
    }

    @Override
    public OrgEditEventResponseModel edit(OrgEditEventRequestModel requestModel) throws SQLException, ClassNotFoundException {
        if (requestModel.getTitle().isEmpty() || requestModel.getDescription().isEmpty()
                || requestModel.getYear().isEmpty() || requestModel.getMonth().isEmpty()
                || requestModel.getDay().isEmpty() || requestModel.getHour().isEmpty()
                || requestModel.getMinute().isEmpty() || requestModel.getLocation().isEmpty()) {
            return orgEditEventOutputBoundary.prepareFailView("Entries cannot be empty.");
        }

        String year = requestModel.getYear();
        String month = requestModel.getMonth();
        String day = requestModel.getDay();
        String hour = requestModel.getHour();
        String minute = requestModel.getMinute();

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
                return orgEditEventOutputBoundary.prepareFailView("Day is not within 0 to 24.");
            }

            int min = Integer.parseInt(minute);
            if (min > 59 || min < 0) {
                return orgEditEventOutputBoundary.prepareFailView("Minute is not within 0 to 60.");
            }

            LocalDateTime now = LocalDateTime.now();
            LocalDateTime time = LocalDateTime.of(y, m, d, h, min);
            if (time.isBefore(now)){
                return orgEditEventOutputBoundary.prepareFailView("Time must be in future.");
            }

            else {
                orgDsGateway.editAnEvent(requestModel.getTitle(), requestModel.getDescription(),
                        requestModel.getLocation(), y, m, d, h, min);
                OrgEditEventResponseModel responseModel = new OrgEditEventResponseModel(requestModel.getTitle());
                return orgEditEventOutputBoundary.prepareSuccessView(responseModel);
            }
        }

        else { return orgEditEventOutputBoundary.prepareFailView("Time entry/ies is/are not integer."); }
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
