package com.epam.tc.hw8.service;

import com.epam.tc.hw8.dto.YandexSpellerDto;
import com.epam.tc.hw8.utils.Parameters;
import com.google.gson.Gson;


public class YandexSpellerService extends CommonService {

    public YandexSpellerDto[] getCorrectWord(String text) {

        return new Gson().fromJson(new CommonService().getWord(text).getBody().asString(), YandexSpellerDto[].class);
    }

    public YandexSpellerDto[] getCorrectWordWithLanguageParam(String text, String paramName) {

        return new Gson().fromJson(
            new CommonService().getWordUsingOtherParams(text, Parameters.PARAM_LANGUAGE, paramName).getBody()
                               .asString(), YandexSpellerDto[].class);
    }

    public YandexSpellerDto[] getCorrectWordWithOptionsParam(String text, String paramName) {
        return new Gson().fromJson(
            new CommonService().getWordUsingOtherParams(text, Parameters.PARAM_OPTIONS, paramName).getBody()
                               .asString(), YandexSpellerDto[].class);
    }
}
