package event_search_use_case;

import java.util.ArrayList;

public class EventSearchResponseModel {

    private ArrayList<String> searchResults;

    public EventSearchResponseModel(ArrayList<String> searchResults) {
        this.searchResults = searchResults;
    }

    public ArrayList<String> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(ArrayList<String> searchResults) {
        this.searchResults = searchResults;
    }
}
