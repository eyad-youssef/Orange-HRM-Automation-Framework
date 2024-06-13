package tests;


import driver.WebDriverSingleton;
import platform.OrangeHRM;

//import waits.Waits;

public class BaseTest {
    protected static WebDriverSingleton webDriver;
    protected static OrangeHRM orangeHRM = new OrangeHRM();



    public BaseTest(){
        webDriver = WebDriverSingleton.getDriverSingleton();
       }

}
