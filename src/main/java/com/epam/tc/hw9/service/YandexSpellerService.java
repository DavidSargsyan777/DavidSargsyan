package com.epam.tc.hw9.service;

import static com.epam.tc.hw9.utils.Parameters.PARAM_LANGUAGE;
import static com.epam.tc.hw9.utils.Parameters.PARAM_OPTIONS;

import com.epam.tc.hw9.dto.YandexSpellerResponseDto;
import com.google.gson.Gson;

public class YandexSpellerService extends CommonService {
    private static YandexSpellerService instance;

    private YandexSpellerService() {

    }

    public static YandexSpellerService getInstance() {
        if (instance == null) {
            instance = new YandexSpellerService();
        }
        return instance;
    }

    public YandexSpellerResponseDto[] getCheckText(String text) {
        return new Gson().fromJson(new CommonService().getCheckTextWithoutParams(text).getBody().asString(),
            YandexSpellerResponseDto[].class);
    }

    public YandexSpellerResponseDto[] getCheckTextWithLanguageParam(String text, String language) {
        return new Gson().fromJson(
            new CommonService().getCheckTextUsingParams(text, PARAM_LANGUAGE, language).getBody()
                               .asString(), YandexSpellerResponseDto[].class);
    }

    public YandexSpellerResponseDto[] getCheckTextWithOptionsParam(String text, Integer options) {
        return new Gson().fromJson(
            new CommonService().getCheckTextUsingParams(text, PARAM_OPTIONS, options).getBody()
                               .asString(), YandexSpellerResponseDto[].class);
    }
}
