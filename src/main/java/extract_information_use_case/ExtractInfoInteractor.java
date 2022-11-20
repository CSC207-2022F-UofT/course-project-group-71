package extract_information_use_case;


import database.*;

import java.sql.SQLException;

public class ExtractInfoInteractor implements ExtractInfoInputBoundary {


    EventDsGateway e;
    OrgDsGateway o;
    ParDsGateway p;

    public ExtractInfoInteractor(EventDsGateway e) {this.e = e;}

    public ExtractInfoInteractor(OrgDsGateway o){
        this.o=o;
    }

    public ExtractInfoInteractor(ParDsGateway p){
        this.p=p;
    }


    @Override
    public ExtractInfoResponseModel<String> extractEventInfo(ExtractInfoRequestModel requestModel) {

        String eventTitle = requestModel.getPara1();
        String keyword = requestModel.getKeyword();
        try{
        switch (keyword) {
            case "getStatus":
                return new ExtractInfoResponseModel<>(e.getStatus(eventTitle));
            case "getDescription":
                return new ExtractInfoResponseModel<>(e.getDescription(eventTitle));
            case "getLocation":
                return new ExtractInfoResponseModel<>(e.getLocation(eventTitle));
            case "getParticipants":
                return new ExtractInfoResponseModel<>(e.getParticipants(eventTitle));
            case "getOrganization":
                return new ExtractInfoResponseModel<>(e.getOrganization(eventTitle));
            case "eventSearch":
                return new ExtractInfoResponseModel<>(e.eventSearch(eventTitle));
            case "checkIfEventNameExist":
                return new ExtractInfoResponseModel<>(e.checkIfEventNameExist(eventTitle));

        }}catch (SQLException | ClassNotFoundException ex){
            throw new RuntimeException(ex);
        }
        return null;
    }

    @Override
    public ExtractInfoResponseModel<String> extractOrgInfo(ExtractInfoRequestModel requestModel) {
        String orgName = requestModel.getPara1();
        String keyword = requestModel.getKeyword();
        try {
            switch (keyword) {
                case "getPassword":
                    return new ExtractInfoResponseModel<>(o.getPassword(orgName));
                case "getUnpublishedEvents":
                    return new ExtractInfoResponseModel<>(o.getUnpublishedEvents(orgName));
                case "getPastEvents":
                    return new ExtractInfoResponseModel<>(o.getPastEvents(orgName));
                case "getUpcomingEvents":
                    return new ExtractInfoResponseModel<>(o.getUpcomingEvents(orgName));
                case "getFollowers":
                    return new ExtractInfoResponseModel<>(o.getFollowers(orgName));
                case "checkIfUsernameExist":
                    return new ExtractInfoResponseModel<>(o.checkIfUsernameExist(orgName));
                case "organizerSearch":
                    return new ExtractInfoResponseModel<>(o.organizerSearch(orgName));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }


        return null;

    }

    @Override
    public ExtractInfoResponseModel<String> extractParInfo(ExtractInfoRequestModel requestModel) {
        String parName = requestModel.getPara1();
        String keyword = requestModel.getKeyword();
        try {
            switch (keyword) {
                case "getPassword":
                    return new ExtractInfoResponseModel<>(p.getPassword(parName));
                case "getNotifications":
                    return new ExtractInfoResponseModel<>(p.getNotifications(parName));
                case "getUpcomingEvents":
                    return new ExtractInfoResponseModel<>(p.getUpcomingEvents(parName));
                case "getPastEvents":
                    return new ExtractInfoResponseModel<>(p.getPastEvents(parName));
                case "getFollowedOrg":
                    return new ExtractInfoResponseModel<>(p.getFollowedOrg(parName));
                case "checkIfUsernameExist":
                    return new ExtractInfoResponseModel<>(p.checkIfUsernameExist(parName));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    @Override
    public ExtractInfoResponseModel<String> extractNotiInfo(ExtractInfoRequestModel requestModel) {
        String parName= requestModel.getKeyword();
        String newNoti= requestModel.getPara1();

        try {
            return new ExtractInfoResponseModel<>(p.addNotification(parName,newNoti));
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public ExtractInfoResponseModel<Integer> extractTimeInfo(ExtractInfoRequestModel requestModel) {
        String eventName= requestModel.getPara1();

        try {
            return new ExtractInfoResponseModel<>(e.getTime(eventName));
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}
