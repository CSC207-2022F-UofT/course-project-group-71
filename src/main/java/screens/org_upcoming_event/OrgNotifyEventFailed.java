package screens.org_upcoming_event;

public class OrgNotifyEventFailed extends RuntimeException {
    public OrgNotifyEventFailed(String error) {
        super(error);
    }
}
