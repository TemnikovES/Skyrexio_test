package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.MyPublicBotsPage;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class BaseTest {
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected MyPublicBotsPage myPublicBotsPage;

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.baseUrl = PropertyReader.getProperty("Skyrexio.url");
        Configuration.browserSize = "1920x1080";
        loginPage = new LoginPage();
        homePage = new HomePage();
        myPublicBotsPage = new MyPublicBotsPage();
    }

    @AfterMethod
    public void close() {
        clearBrowserCache();
        closeWebDriver();
    }
}
