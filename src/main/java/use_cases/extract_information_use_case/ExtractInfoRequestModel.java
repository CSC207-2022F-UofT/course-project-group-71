package use_cases.extract_information_use_case;




public class ExtractInfoRequestModel {

    String keyword, para;

    public ExtractInfoRequestModel(String keyword,String para){
        this.keyword = keyword;
        this.para = para;
    }

    public ExtractInfoRequestModel(String para){
        this.para = para;
    }

    public String getPara() {
        return para;
    }

    public String getKeyword() {
        return keyword;
    }
}
