package pages;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import utilities.Waits;

public class BasePage extends Waits {
protected  WebDriver driver = WebDriverSingleton.getWebDriver();
}
