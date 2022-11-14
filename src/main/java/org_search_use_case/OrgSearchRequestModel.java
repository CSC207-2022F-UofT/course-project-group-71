package org_search_use_case;

public class OrgSearchRequestModel {

    private String query;

    public OrgSearchRequestModel(String query) {
        this.query = query;
    }

    public String getQuery() {
        return this.query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
