package domainobjects;

import io.restassured.http.Cookies;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import utils.CookieUtils;

import java.util.List;

public class AppCookies {

    private Cookies cookies;

    public void setCookies(Cookies cookies) {
        this.cookies = cookies;
    }

    public Cookies getCookies() {
        return cookies;
    }

    public void injectCookiesToBrowser(WebDriver driver) {
        List<Cookie> seleniumCookieList = new CookieUtils().convertRestAssuredCookiesToSeleniumCookies(cookies);
        seleniumCookieList.forEach(c -> driver.manage().addCookie(c));
        driver.navigate().refresh();
    }
}
