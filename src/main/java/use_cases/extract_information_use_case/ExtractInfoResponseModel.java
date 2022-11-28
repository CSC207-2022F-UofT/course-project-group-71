package use_cases.extract_information_use_case;

import java.util.ArrayList;

public class ExtractInfoResponseModel <T> {

    private String str;
    private ArrayList<T> al;

    public ExtractInfoResponseModel(String str){
        this.str=str;
    }

    public ExtractInfoResponseModel(ArrayList<T> al){
        this.al= al;
    }

    public String getStr() {
        return this.str;
    }

    public ArrayList<T> getAl() {
        return this.al;
    }
}
