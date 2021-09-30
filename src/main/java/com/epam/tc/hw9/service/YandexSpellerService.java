package com.epam.tc.hw9.service;

import static com.epam.tc.hw9.utils.Parameters.PARAM_TEXT;
import static com.epam.tc.hw9.utils.URI.CHECK_TEXT_URI;
import static org.apache.http.HttpStatus.SC_OK;

import com.epam.tc.hw9.dto.YandexSpellerResponseDto;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import org.hamcrest.Matchers;

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
        getWithParams(CHECK_TEXT_URI, params).then().statusCode(Matchers.is(SC_OK));
        return new Gson().fromJson(new CommonService().getWithParams(CHECK_TEXT_URI, params).getBody().asString(),
            YandexSpellerResponseDto[].class);
    }

    public YandexSpellerResponseDto[] getCheckTextWithLanguageParam(String text, String param, String language) {
        Map<String, Object> params = new HashMap<>();
        params.put(PARAM_TEXT, text);
        params.put(param, language);
        getWithParams(CHECK_TEXT_URI, params).then().statusCode(Matchers.is(SC_OK));
        return new Gson().fromJson(new CommonService().getWithParams(CHECK_TEXT_URI, params).getBody().asString(),
            YandexSpellerResponseDto[].class);
    }

    public YandexSpellerResponseDto[] getCheckTextWithOptionsParam(String text, String param, Integer options) {
        Map<String, Object> params = new HashMap<>();
        params.put(PARAM_TEXT, text);
        params.put(param, options);
        getWithParams(CHECK_TEXT_URI, params).then().statusCode(Matchers.is(SC_OK));
        return new Gson().fromJson(new CommonService().getWithParams(CHECK_TEXT_URI, params).getBody().asString(),
            YandexSpellerResponseDto[].class);
    }
}
