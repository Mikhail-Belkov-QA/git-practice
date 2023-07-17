package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {


/*    public LoginPage switchToIframeMenu() {
        findByXpath("/html/body/iframe[1]", Duration.ofSeconds(10));
                    //Далее входим во фрейм меню
      //  findById("__next" , Duration.ofSeconds(10)).switchTo().frame( iframe );;

      //  userMenu.click();
        //Далее входим во фрейм меню

        driver.switchTo().frame( 0 );
        return this;
    }*/

    public LoginPage setLogin(String login) {
        findById("passp-field-login", Duration.ofSeconds(10)).sendKeys(login);
        return this;
    }

    public LoginPage clickOnSubmitButton() {
        findById("passp:sign-in", Duration.ofSeconds(10)).click();
        return this;
    }

    public LoginPage setPassword(String password) {
        findById("passp-field-passwd", Duration.ofSeconds(10)).sendKeys(password);
        return this;



  /* public LoginPage setLogin(String login) {
        findById("login" , Duration.ofSeconds(10)).sendKeys(login);
        return this;
    }
    public LoginPage setPassword(String password) {
        findById("password", Duration.ofSeconds(10)).sendKeys(password);
        return this;
    }

    public LoginPage clickOnSubmitButton() {
        findByCss(".rui-Button-content", Duration.ofSeconds(10)).click();
        return this;
    }*/


    }
}

