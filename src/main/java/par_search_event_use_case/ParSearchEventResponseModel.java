package par_search_event_use_case;

import java.util.ArrayList;

public class ParSearchEventResponseModel {

    private ArrayList<String> searchResults;
    private String parUserName;

    public ParSearchEventResponseModel(ArrayList<String> searchResults, String parUserName) {
        this.searchResults = searchResults;
        this.parUserName=parUserName;
    }

    public ArrayList<String> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(ArrayList<String> searchResults) {
        this.searchResults = searchResults;
    }

    public String getParUserName() {
        return parUserName;
    }

    public void setParUserName(String parUserName) {
        this.parUserName = parUserName;
    }
}
