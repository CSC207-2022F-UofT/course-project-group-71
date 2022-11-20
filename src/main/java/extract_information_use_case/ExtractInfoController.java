package extract_information_use_case;

public class ExtractInfoController {

    ExtractInfoInputBoundary input;

    public ExtractInfoController(ExtractInfoInputBoundary input) {
        this.input=input;
        }


    public ExtractInfoResponseModel<String> extractOrg(String keyword, String para1){
        ExtractInfoRequestModel requestModel= new ExtractInfoRequestModel(keyword,para1);
        return input.extractOrgInfo(requestModel);
    }

    public ExtractInfoResponseModel<String> extractPar(String keyword, String para1){
        ExtractInfoRequestModel requestModel= new ExtractInfoRequestModel(keyword,para1);
        return input.extractParInfo(requestModel);
    }

    public ExtractInfoResponseModel<String> extractParNoti(String para1, String para2){
        ExtractInfoRequestModel requestModel= new ExtractInfoRequestModel(para1,para2);
        return input.extractNotiInfo(requestModel);
    }

    public ExtractInfoResponseModel<Integer> extractEventTime(String para1){
        ExtractInfoRequestModel requestModel= new ExtractInfoRequestModel(para1);
        return input.extractTimeInfo(requestModel);
    }

    public ExtractInfoResponseModel<String> extractEvent(String keyword, String para1){
        ExtractInfoRequestModel requestModel= new ExtractInfoRequestModel(keyword, para1);
        return input.extractEventInfo(requestModel);
    }



}
