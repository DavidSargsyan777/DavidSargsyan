package com.epam.tc.hw8.service;

import static io.restassured.RestAssured.given;

import com.epam.tc.hw8.utils.Parameters;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommonService {
    private RequestSpecification requestSpecification;

    public CommonService() {
        requestSpecification =
            new RequestSpecBuilder()
                .setBaseUri("https://speller.yandex.net/services/spellservice.json/checkText")
                .build();
    }

    public Response getWord(String text) {
        RequestSpecification specification = given(requestSpecification);

        return specification
            .param(Parameters.PARAM_TEXT, text)
            .get();
    }

    public Response getWordUsingOtherParams(String text, String param, String paramName) {
        RequestSpecification specification = given(requestSpecification);

        return specification
            .param(Parameters.PARAM_TEXT, text)
            .param(param, paramName)
            .get();
    }
}
