package pages;

import java.time.Duration;

public class StartPage extends BasePage {

    public LoginPage clickOnEnterButton() {
   //  findByCss(".rc__KWXsu", Duration.ofSeconds(10)).click();
     findById("passp:sign-in", Duration.ofSeconds(10));
        return new LoginPage();
    }
}
