package par_search_org_use_case;

public interface ParSearchOrgOutputBoundary {
    ParSearchOrgResponseModel prepareSuccessView(ParSearchOrgResponseModel results );
    ParSearchOrgResponseModel prepareFailView(String error);

}
