package ui_tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class YandexRamblerTest extends BaseTest {

    @Test
    @DisplayName("Проверка входа в систему")
    public void checkIncorrectPasswordMsg() {

        new LoginPage().goToStartPage()
                .clickOnEnterButton()
              //  .switchToIframeMenu()
                .setLogin("mgaro1d@yandex.ru")
              //  .setLogin("belkov-86@rambler.ru")
              .clickOnSubmitButton()
               .setPassword("13579qwertY")

                .clickOnSubmitButton();
    }
}
