package par_search_org_use_case;

public class ParSearchOrgRequestModel {

    private String query;
    private String parUserName;

    public ParSearchOrgRequestModel(String query, String parUserName) {
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
