package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Autotests\\chromedriver_win32-1\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // явное ожидание
      //  driver.get("https://google.com");
       // public static void main(String[] args) throws InterruptedException {

            try {
                driver.get("https://crossbrowsertesting.github.io/drag-and-drop");
                Thread.sleep(2000);

                WebElement element = driver.findElement(By.id("draggable"));
                WebElement element2 = driver.findElement(By.id("droppable"));

                Actions actions = new Actions(driver);
                actions.moveToElement(element).clickAndHold().moveToElement(element2).release().build().perform();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                Thread.sleep(20000); // чтобы сработало надо передать в класс - наверх
                driver.quit();

            }











    }
}