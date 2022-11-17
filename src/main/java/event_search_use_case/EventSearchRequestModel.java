package event_search_use_case;

public class EventSearchRequestModel {

    private String query;
    private String parUserName;

    public EventSearchRequestModel(String query, String parUserName) {
        this.query = query;
        this.parUserName= parUserName;
    }

    public String getQuery() {
        return this.query;
    }

    public String getParUserName() {
        return parUserName;
    }

    public void setParUserName(String parUserName) {
        this.parUserName = parUserName;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
