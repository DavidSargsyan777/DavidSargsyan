package com.epam.tc.hw9.service;

import static com.epam.tc.hw9.utils.Parameters.PARAM_TEXT;
import static com.epam.tc.hw9.utils.URI.CHECK_TEXT_URI;

import com.epam.tc.hw9.dto.YandexSpellerResponseDto;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

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
        Map<String, Object> params = new HashMap<>();
        params.put(PARAM_TEXT, text);
        return new Gson().fromJson(getWithParams(CHECK_TEXT_URI, params).getBody().asString(),
            YandexSpellerResponseDto[].class);
    }

    public YandexSpellerResponseDto[] getCheckTextWithLanguageParam(String text, String param, String language) {
        Map<String, Object> params = new HashMap<>();
        params.put(PARAM_TEXT, text);
        params.put(param, language);
        return new Gson().fromJson(getWithParams(CHECK_TEXT_URI, params).getBody().asString(),
            YandexSpellerResponseDto[].class);
    }

    public YandexSpellerResponseDto[] getCheckTextWithOptionsParam(String text, String param, Integer options) {
        Map<String, Object> params = new HashMap<>();
        params.put(PARAM_TEXT, text);
        params.put(param, options);
        return new Gson().fromJson(getWithParams(CHECK_TEXT_URI, params).getBody().asString(),
            YandexSpellerResponseDto[].class);
    }
}
