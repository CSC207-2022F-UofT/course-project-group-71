package extract_information_use_case;




public class ExtractInfoRequestModel {


    private String keyword;
    private String para1,para2;



    public ExtractInfoRequestModel(String keyword,String para1){

        this.keyword=keyword;
        this.para1=para1;
    }

    public ExtractInfoRequestModel(String keyword, String para1, String para2){
        this.keyword=keyword;
        this.para1=para1;
        this.para2=para2;
    }

    public ExtractInfoRequestModel(String para1){
        this.para1=para1;
    }


    public String getPara1() {
        return para1;
    }

    public void setPara1(String para1) {
        this.para1 = para1;
    }

    public String getPara2() {
        return para2;
    }

    public void setPara2(String para2) {
        this.para2 = para2;
    }



    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
