package screens.par_search;

import par_search_event_use_case.ParSearchEventOutputBoundary;
import par_search_event_use_case.ParSearchEventResponseModel;
import screens.ShowMessageView;

import java.sql.SQLException;
import java.util.ArrayList;

public class ParSearchEventPresenter implements ParSearchEventOutputBoundary {


    @Override
    public ParSearchEventResponseModel prepareSuccessView(ParSearchEventResponseModel results) throws SQLException, ClassNotFoundException {
        ArrayList<String> eventNames= results.getSearchResults();
        String parUserName= results.getParUserName();
        new ParSearchEventResultsPage(eventNames,parUserName);
        return results;
    }

    @Override
    public ParSearchEventResponseModel prepareFailView(String error) {throw new ShowMessageView(error);
    }
}
