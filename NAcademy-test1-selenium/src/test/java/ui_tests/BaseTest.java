package ui_tests;

import driver_manager.DriverManager;
import org.testng.annotations.AfterTest;
import pages.LoginPage;

public class BaseTest {

    @AfterTest
    public void kill() {
       // LoginPage.entryMenu();
        DriverManager.closeDriver();
    }

}