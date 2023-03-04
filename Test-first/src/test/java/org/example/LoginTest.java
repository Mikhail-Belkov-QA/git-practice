package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
public class LoginTest {
    public static LoginPage loginPage;
    public static AgePage agePage;
    public static WebDriver driver;

    /**
     * осуществление первоначальной настройки
     */
    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        agePage = new AgePage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage")); }
    /**
     * тестовый метод для осуществления аутентификации
     */
    @Test
    public void loginTest() {
        //получение доступа к методам класса LoginPage для взаимодействия с элементами страницы
        //значение login/password берутся из файла настроек по аналогии с chromedriver
        //и loginpage
        //вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //получаем путь к скрипту на следующей странице
        String formClassAction = agePage.getFormClassAction();
        //и сравниваем его с вопросом из файла настроек
        Assert.assertTrue(formClassAction.contains(ConfProperties.getProperty("action")));

        //!!! добавил: проверяем наличие в свойствах пути к нужному php-скрипту ---------------------
        if (formClassAction.contains(ConfProperties.getProperty("action")))
        {
            /// если true, жмем кнопку, которая submit - по умолчанию она (вроде) запускает приписанный к форме php-скрипт
            agePage.getSendButton().click();
        }
        //--------------------------------------------------------------------------------------------
    }
    /**
     * закрытие окна браузера - НЕОБЯЗАТЕЛЬНО, можно закомментировать
     */
    @AfterClass
    public static void tearDown() {
        //driver.quit();
    }
}