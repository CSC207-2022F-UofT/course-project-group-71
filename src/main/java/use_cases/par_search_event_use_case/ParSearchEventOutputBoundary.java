package use_cases.par_search_event_use_case;

import java.sql.SQLException;

/** Class used to prepare failure or success view.
 */
public interface ParSearchEventOutputBoundary {

    /**A method used to show success view to the user
     *
     * @param results A response model containing information to show success view
     * @return A response model showing failure view
     */
    ParSearchEventResponseModel prepareSuccessView(ParSearchEventResponseModel results );

    /**A method used to show failure view to the user
     *
     * @param error A String containing information about how it failed
     * @return A response model showing success view
     */
    ParSearchEventResponseModel prepareFailView(String error);
}
