package org_search_use_case;

import java.util.ArrayList;

public class OrgSearchRequestModel {

    private ArrayList<String> query;

    public OrgSearchRequestModel(ArrayList<String> query) {
        this.query = query;
    }

    public ArrayList<String> getQuery() {
        return this.query;
    }

    public void setQuery(ArrayList<String> query) {
        this.query = query;
    }
}
