package Utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }

    @Before()
    public void testBeforeScenario() throws Exception {
            Websetup();
    }

    public static void Websetup() throws Exception {
        System.setProperty("https.protocols", "TLSv1.2");
        System.setProperty("webdriver.chrome.driver","tools/chromedriver/chromedriver.exe");
        ChromeOptions chromeCapabilities = new ChromeOptions();

        driver = new ChromeDriver(chromeCapabilities);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://www.demoblaze.com/");
    }

    @After()
    public void After(final Scenario scenario) throws IOException {

        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "embedScreenShot");
        String msg = "End of test case : " + scenario.getName();
        System.out.println(msg);

        getDriver().quit();
    }
}
