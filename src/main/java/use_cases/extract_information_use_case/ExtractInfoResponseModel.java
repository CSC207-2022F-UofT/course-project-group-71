package use_cases.extract_information_use_case;

import java.util.ArrayList;

public class ExtractInfoResponseModel<T> {

    private String str;
    private ArrayList<T> al;

    /**Constructs an ExtractInfoResponseModel where the information found is a string
     *
     * @param str A string of information obtained from a database
     */
    public ExtractInfoResponseModel(String str){
        this.str = str;
    }

    /**Constructs an ExtractInfoResponseModel where multiple pieces of information are
     * required to be returned
     *
     * @param al An array list of information obtained from a database
     */
    public ExtractInfoResponseModel(ArrayList<T> al){
        this.al = al;
    }

    /**A getter for the attribute str
     *
     * @return Returns str
     */
    public String getStr() {
        return this.str;
    }

    /**A getter for the attribute al
     *
     * @return Returns al
     */
    public ArrayList<T> getAl() {
        return this.al;
    }
}
