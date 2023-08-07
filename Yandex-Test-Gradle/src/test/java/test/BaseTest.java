package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProfilePage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class BaseTest {
    protected static LoginPage loginPage;
    protected static ProfilePage profilePage;
    protected static WebDriver driver;
    /**
     * осуществление первоначальной настройки
     */
    @BeforeAll
    @Step("Запуск страницы")
    public static void setup() {
        //определение пути до драйвера и его настройка
        //   System.setProperty("webdriver.chrome.driver", test.ConfProperties.getProperty("chromedriver"));
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebDriverManager.chromedriver().setup();
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        step ("Открываем стартовую страницу", () ->
        {     driver.get(ConfProperties.getProperty("loginpage"));});

          //Нажатие на кнопку Email
        step ("Нажимаем на кнопку Email", () ->
        { BaseTest.loginPage.inputLoginEmailBtn();});

        }

    /**
     * осуществление выхода из аккаунта с последующим закрытием окна браузера
     */
    @AfterAll
    @Step ("Выход из аккаунта")
    public static void tearDown() {
        step ("Заходим в iFrame menu", () ->
        {     profilePage.entryMenu();});

        step ("Получаем отображаемый логин и сравниваем его с логином из файлов настройки", () ->
        {   String user = BaseTest.profilePage.getUserId();
            Assert.assertEquals(test.ConfProperties.getProperty("login"), user); });

        step ("Нажимаем на кнопку Выход", () ->
        {     profilePage.userLogout();});
        driver.quit();
    }


    }




