package com.epam.tc.hw9.service;

import static com.epam.tc.hw9.utils.URI.BASE_URI;
import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;
import java.util.function.Supplier;

public class CommonService {
    Supplier<RequestSpecification> specification = () -> {
        RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .addFilter(new RequestLoggingFilter())
            .addFilter(new ResponseLoggingFilter())
            .build();
        return given(spec);
    };

    public Response getWithParams(String uri, Map<String, Object> params) {
        RequestSpecification specific = specification.get();

        for (Map.Entry<String, Object> param : params.entrySet()) {
            specific.param(param.getKey(), param.getValue());
        }

        return specific.get(uri);
    }
}
