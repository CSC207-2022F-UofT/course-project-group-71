package extract_information_use_case;

import java.util.ArrayList;

public class ExtractInfoResponseModel <T> {

    private String str;
    private Boolean bool;
    private ArrayList<T> al;



    public ExtractInfoResponseModel(String str){
        this.str=str;
    }
    public ExtractInfoResponseModel(ArrayList<T> al){
        this.al= al;
    }

    public ExtractInfoResponseModel(Boolean bool){
        this.bool= bool;
    }

    public String getStr() {
        return this.str;
    }

    public Boolean getBool() {
        return this.bool;
    }

    public ArrayList<T> getAl() {
        return this.al;
    }
}
