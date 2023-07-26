package hooks;

import context.TestContext;
import factory.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class InitHooks {
    private final TestContext context;

    public InitHooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setup() {
        WebDriver driver = WebDriverFactory.getDriver(System.getProperty("browser", "chrome"));
        context.setWebDriver(driver);
    }

    @After
    public void cleanup() {
        context.getWebDriver().quit();
    }
}
