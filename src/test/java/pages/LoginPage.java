package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private static final String EMAIL = "//*[@placeholder='Email']";
    private static final String PASSWORD = "//*[@type='password']";
    private static final String SUBMIT_BTN = "//*[@type='submit']";
    private static final String ERROR_MSG = "//*[text()='Неверный email или пароль']";

    public void openPage() {
        open("login");
    }

    public void login(String email, String password) {
        inputEmail(email);
        inputPassword(password);
        $x(SUBMIT_BTN).submit();
    }

    public void inputEmail(String email){
        $x(EMAIL).setValue(email);
    }

    public void inputPassword(String password){
        $x(PASSWORD).setValue(password);
    }

    public boolean waitErrorMessage() {
        return $x(ERROR_MSG).shouldBe(Condition.visible).isDisplayed();
    }
}
