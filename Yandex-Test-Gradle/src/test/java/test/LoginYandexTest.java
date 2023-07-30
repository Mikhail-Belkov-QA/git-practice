package test;


import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.jupiter.api.*;


import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class LoginYandexTest extends BaseTest {

    /**
     * тестовый метод для осуществления аутентификации
     */
    @Test
   @Step ("Ввод логина")

    public void loginTest() {
        //получение доступа к методам класса LoginPage для взаимодействия с элементами страницы
        //значение login/password берутся из файла настроек по аналогии с chromedriver
        //и loginpage
        //вводим логин
        step ("Задать логин", () ->
     { BaseTest.loginPage.inputLogin(ConfProperties.getProperty("login"));});
          //нажимаем кнопку входа
        step ("Нажать на кнопку", () ->
        {  BaseTest.loginPage.clickLoginBtn();});
          //вводим пароль
        step ("Задать пароль", () ->
        {  BaseTest.loginPage.inputPasswd(ConfProperties.getProperty("password"));});


        //нажимаем кнопку входа
        step ("Нажать на кнопку", () ->
        {   BaseTest.loginPage.clickLoginBtn();});

        //получаем отображаемый логин
       /* step ("Получаем отображаемый логин", () ->
        {    });*/
       /* String user = BaseTest.profilePage.getUserName();
        Assert.assertEquals(test.ConfProperties.getProperty("login"), user);*/
        //и сравниваем его с логином из файла настроек
      /*  String user2 = BaseTest.profilePage.getUserId();
         Assert.assertEquals(test.ConfProperties.getProperty("login"), user2);*/
    }
    }

