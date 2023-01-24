package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.TGBasePage;
import pages.TGFrontendTestingHomePage;
import pages.TGLoginFormPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TGBase {
    WebDriver driver;
    TGBasePage tgBasePage;
    TGFrontendTestingHomePage tgFrontendTestingHomePage;
    TGLoginFormPage tgLoginFormPage;

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("appURL"));
        tgBasePage = new TGBasePage();
    }
    @AfterMethod
    public void teardown() {
        Driver.quitDriver();
    }
}


