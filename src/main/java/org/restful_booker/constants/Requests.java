package org.restful_booker.constants;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Requests extends Endpoints {
    public RequestSpecification baseRequest() {
        return new RequestSpecBuilder()
                .setBaseUri(APP_URL)
                .setContentType(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .setRelaxedHTTPSValidation()
                .build();
    }

    public ValidatableResponse doPostRequest(String endpoint, Object body) {
        RequestSpecification request = given(baseRequest());
        request
                .body(body);
        return request.post(endpoint).then();
    }

    public ValidatableResponse doGetRequest(String endpoint) {
        RequestSpecification request = given(baseRequest());
        return request.get(endpoint).then();
    }

    public ValidatableResponse doGetRequest(String endpoint, int id) {
        RequestSpecification request = given(baseRequest());
        return request.get(endpoint + "/" + id).then();
    }


}
