package com.epam.tc.hw9.service;

import static com.epam.tc.hw9.utils.URI.BASE_URI;
import static com.epam.tc.hw9.utils.URI.CHECK_TEXT_URI;
import static com.epam.tc.hw9.utils.Parameters.PARAM_TEXT;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.function.Supplier;
import org.hamcrest.Matchers;

public class CommonService {

    Supplier<RequestSpecification> specification = () -> {
        RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .addFilter(new RequestLoggingFilter())
            .addFilter(new ResponseLoggingFilter())
            .build();
        return given(spec);
    };

    public Response getCheckTextWithoutParams(String text) {
        Response response = specification.get()
                                         .request()
                                         .param(PARAM_TEXT, text)
                                         .get(CHECK_TEXT_URI);
        response.then()
                .statusCode(Matchers.is(SC_OK));
        return response;
    }

    public <T> Response getCheckTextUsingParams(String text, String param, T paramName) {
        Response response = specification.get()
                                         .request()
                                         .param(PARAM_TEXT, text)
                                         .param(param, paramName)
                                         .get(CHECK_TEXT_URI);
        response.then()
                .statusCode(Matchers.is(SC_OK));
        return response;
    }
}
