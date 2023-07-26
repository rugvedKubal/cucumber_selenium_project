package apis;

import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ApiRequest extends SpecBuilder {

    public static Response post(String endPoint, Headers headers, HashMap<String, Object> formParameters, Cookies cookies) {
        return given()
                    .spec(getRequestSpecification())
                    .headers(headers)
                    .formParams(formParameters)
                    .cookies(cookies)
                .when()
                    .post(endPoint)
                .then()
                    .spec(getResponseSpecification())
                    .extract()
                    .response();
    }

    public static Response get(String endPoint, Cookies cookies) {
        return given()
                    .spec(getRequestSpecification())
                    .cookies(cookies)
                .when()
                    .get(endPoint)
                .then()
                    .spec(getResponseSpecification())
                    .extract()
                    .response();
    }
}
