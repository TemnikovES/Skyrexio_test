package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MyPublicBotsPage {
    protected static final SelenideElement NEW_PUBLIC_BOT_BTN = $x("//*[contains(text(), 'Опубликовать нового бота')]");
    protected static final SelenideElement COMBOBOX = $x("//*[contains(text(), 'Выберите Выберите ботов')]");
    protected static final SelenideElement PUBLIC_BOT = $x("//*[contains(text(), 'Mypublicbot')]");
    protected static final SelenideElement ERROR_BOT_MSG = $x("//*[contains(text(), 'Ещё рано публиковать')]");

    public MyPublicBotsPage openPage() {
        open("trading-bots/my-public-bots");
        return this;
    }

    public void  newPublicBot() {
        NEW_PUBLIC_BOT_BTN.should(Condition.exist)
                .shouldBe(Condition.visible)
                .click();
    }

    public void comboboxClick() {
        COMBOBOX.should(Condition.exist)
                .shouldBe(Condition.visible)
                .click();
    }

    public void publicBotClick() {
        PUBLIC_BOT.should(Condition.exist)
                .shouldBe(Condition.visible)
                .click();
    }

    public static boolean checkErrorMsg() {
        return ERROR_BOT_MSG.shouldBe(Condition.visible)
                .isDisplayed();
    }
}
