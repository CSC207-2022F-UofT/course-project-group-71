package screens;

import org_search_use_case.OrgSearchInputBoundary;
import org_search_use_case.OrgSearchRequestModel;
import org_search_use_case.OrgSearchResponseModel;

import java.util.ArrayList;

public class OrgSearchController {

    final OrgSearchInputBoundary userInput;

    public OrgSearchController(OrgSearchInputBoundary userInput) {
        this.userInput = userInput;
    }

    OrgSearchResponseModel orgSearch(String query) {
        OrgSearchRequestModel requestModel = new OrgSearchRequestModel(separateWords(query));
        return userInput.orgSearch(requestModel);
    }

    private ArrayList<String> separateWords(String query) {
        ArrayList<String> separateWordQuery = new ArrayList<>();
        String word = "";
        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) != ' ') {
                word = word + query.charAt(i);
            } else {
                separateWordQuery.add(word);
                word = "";
            }
        }
        if (!(word.isBlank())) {
            separateWordQuery.add(word);
        }
        return separateWordQuery;
    }
}
