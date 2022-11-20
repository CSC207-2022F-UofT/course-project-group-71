package extract_information_use_case;

public interface ExtractInfoInputBoundary {


    ExtractInfoResponseModel<String> extractEventInfo(ExtractInfoRequestModel requestModel);
    ExtractInfoResponseModel<String> extractOrgInfo(ExtractInfoRequestModel requestModel);
    ExtractInfoResponseModel<String> extractParInfo(ExtractInfoRequestModel requestModel);

    ExtractInfoResponseModel<String> extractNotiInfo(ExtractInfoRequestModel requestModel);
    ExtractInfoResponseModel<Integer> extractTimeInfo(ExtractInfoRequestModel requestModel);
}
