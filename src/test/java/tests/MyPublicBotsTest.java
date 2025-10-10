package tests;

import org.testng.annotations.Test;
import pages.MyPublicBotsPage;
import utils.PropertyReader;

import static org.testng.Assert.assertTrue;

public class MyPublicBotsTest extends BaseTest {

    @Test(description = "Публикация бота без необходимого KPI")
    public void addPublicBot() {
        loginPage.openPage();
        loginPage.login(PropertyReader.getProperty("Skyrexio.email"),
                PropertyReader.getProperty("Skyrexio.password"));
        homePage.waitPageLoaded();
        myPublicBotsPage.openPage()
                .newPublicBot()
                .comboboxClick()
                .publicBotClick();
        assertTrue(MyPublicBotsPage.checkErrorMsg());
    }
}
