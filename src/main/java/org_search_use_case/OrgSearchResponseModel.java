package org_search_use_case;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class OrgSearchResponseModel {

    private ArrayList<String> searchResults;

    public OrgSearchResponseModel(ArrayList<String> searchResults) {
        this.searchResults = searchResults;
    }

    public ArrayList<String> getSearchResults() {
        return this.searchResults;
    }

    public void setSearchResults(ArrayList<String> searchResults) {
        this.searchResults = searchResults;
    }
}
