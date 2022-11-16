package org_search_use_case;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class OrgSearchResponseModel {

    private ArrayList<String> searchResults;
    private String parUserName;

    public OrgSearchResponseModel(ArrayList<String> searchResults, String parUserName) {
        this.searchResults = searchResults;
        this.parUserName = parUserName;

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
