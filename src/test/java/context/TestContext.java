package context;

import domainobjects.AppCookies;
import io.restassured.http.Cookies;
import org.openqa.selenium.WebDriver;

public class TestContext {
    private WebDriver driver;
    private AppCookies appCookies;

    public TestContext() {
        appCookies = new AppCookies();
        appCookies.setCookies(new Cookies());
    }

    public void setWebDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public AppCookies getAppCookies() {
        return appCookies;
    }

    public void setAppCookies(Cookies cookies) {
        appCookies.setCookies(cookies);
    }
}
