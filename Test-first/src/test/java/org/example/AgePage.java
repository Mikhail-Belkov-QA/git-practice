package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class AgePage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public AgePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    /**
     * определение локатора метки с вопросом о возрасте пользователя
     */
    @FindBy(xpath = "//*[contains(@class, 'form_auth_style')]")
    private WebElement formClass;

    // !!! добавил -----------------------------------
    /**
     * метод для получения web-элемента формы - к ней привязан php-скрипт, который по кнопке submit выполнится
     */
    public WebElement getFormClass()
    {
        return formClass;
    }
    /**
     * определение локатора кнопки входа в аккаунт
     */
    public WebElement getSendButton()
    {
        return getFormClass().findElement(By.xpath("//input[@type='submit']"));
    }
    @FindBy(xpath = "//*[contains(@type, 'submit')]")
    private WebElement loginBtn;
    //-------------------------------------------------
    /**
     * метод для получения вопроса о возрасте пользователя
     */
    public String getFormClassAction() {
        String actionStr = formClass.getAttribute("action");
        return actionStr; }
}
