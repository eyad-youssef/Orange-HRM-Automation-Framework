package tests;


import io.cucumber.java.Before;
import org.testng.annotations.BeforeTest;


public class HooksHandler extends BaseTest {

    @BeforeTest
    public void initialize() throws InterruptedException {

        webDriver.navigateTo("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }



}
