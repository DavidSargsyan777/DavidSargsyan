package com.epam.tc.hw9.service;

import com.epam.tc.hw9.dto.YandexSpellerDto;
import com.epam.tc.hw9.utils.Parameters;
import com.google.gson.Gson;


public class YandexSpellerService extends CommonService {

    public YandexSpellerDto[] getCorrectWord(String text) {

        return new Gson().fromJson(new CommonService().getWord(text).getBody().asString(), YandexSpellerDto[].class);
    }

    public YandexSpellerDto[] getCorrectWordWithLanguageParam(String text, String language) {

        return new Gson().fromJson(
            new CommonService().getWordUsingLangParams(text, Parameters.PARAM_LANGUAGE, language).getBody()
                               .asString(), YandexSpellerDto[].class);
    }

    public YandexSpellerDto[] getCorrectWordWithOptionsParam(String text, Integer options) {
        return new Gson().fromJson(
            new CommonService().getWordUsingOptionParams(text, Parameters.PARAM_OPTIONS, options).getBody()
                               .asString(), YandexSpellerDto[].class);
    }
}
