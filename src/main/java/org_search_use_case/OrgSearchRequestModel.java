package org_search_use_case;

public class OrgSearchRequestModel {

    private String query;
    private String parUserName;

    public OrgSearchRequestModel(String query,String parUserName) {
        this.query = query;
        this.parUserName= parUserName;
    }

    public String getQuery() {
        return this.query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getParUserName() {
        return parUserName;
    }

    public void setParUserName(String parUserName) {
        this.parUserName = parUserName;
    }
}
