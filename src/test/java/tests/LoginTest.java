package tests;

import org.testng.annotations.Test;
import utils.PropertyReader;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(description = "Логин с корректными данными")
    public void loginWithCorrectCredentials() {
        loginPage.openPage();
        loginPage.login(PropertyReader.getProperty("Skyrexio.email"),
                PropertyReader.getProperty("Skyrexio.password"));
        homePage.waitPageLoaded();
        assertEquals(url(), baseUrl + "home");
    }

    @Test(description = "Логин с некорректными данными")
    public void loginWithIncorrectCredentials() {
        loginPage.openPage();
        loginPage.login(PropertyReader.getProperty("Skyrexio.wrong.email"),
                PropertyReader.getProperty("Skyrexio.wrong.password"));
        assertTrue(loginPage.waitErrorMessage());
    }


}
