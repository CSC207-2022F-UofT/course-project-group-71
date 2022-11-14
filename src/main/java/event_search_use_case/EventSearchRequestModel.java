package event_search_use_case;

public class EventSearchRequestModel {

    private String query;

    public EventSearchRequestModel(String query) {
        this.query = query;
    }

    public String getQuery() {
        return this.query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
