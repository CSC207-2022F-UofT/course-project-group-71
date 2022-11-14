package screens.org_unpublished_event;

import org_publish_event_use_case.OrgPublishEventPresenter;
import org_publish_event_use_case.OrgPublishEventResponseModel;
import screens.ShowMessageView;

public class OrgPublishEventResponseFormatter implements OrgPublishEventPresenter {
//    @Override
//    public OrgDeleteEventResponseModel prepareSuccessView(OrgDeleteEventResponseModel response) {
//        response.setMessage("Event" + response.getEventName() + "is deleted");
//        throw new ShowMessageView(response.getMessage());
//    }

    @Override
    public OrgPublishEventResponseModel prepareSuccessView(OrgPublishEventResponseModel response) {
        response.setMessage("Event" + response.getEventName() + "is published");
        throw new ShowMessageView(response.getMessage());
    }

}
