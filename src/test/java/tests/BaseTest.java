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
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    MyPublicBotsPage myPublicBotsPage = new MyPublicBotsPage();

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.baseUrl = PropertyReader.getProperty("Skyrexio.url");
        Configuration.browserSize = "1920x1080";
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @AfterMethod
    public void close() {
        clearBrowserCache();
        closeWebDriver();
    }
}
