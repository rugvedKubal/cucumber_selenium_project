package utils;

import io.restassured.http.Cookies;
import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookieUtils {

    public List<Cookie> convertRestAssuredCookiesToSeleniumCookies(Cookies cookies) {
        List<io.restassured.http.Cookie> restAssuredCookieList = cookies.asList();
        List<Cookie> seleniumCookieList = new ArrayList<>();

        for(io.restassured.http.Cookie restAssuredCookie : restAssuredCookieList) {
            seleniumCookieList.add(new Cookie(
                    restAssuredCookie.getName(),
                    restAssuredCookie.getValue(),
                    restAssuredCookie.getDomain(),
                    restAssuredCookie.getPath(),
                    restAssuredCookie.getExpiryDate(),
                    restAssuredCookie.isSecured(),
                    restAssuredCookie.isHttpOnly(),
                    restAssuredCookie.getSameSite()
            ));
        }

        return seleniumCookieList;
    }

}
