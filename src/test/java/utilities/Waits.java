package utilities;


import driver.WebDriverSingleton;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Waits {

    final static int waitTime = 100 ;

    public WebElement waitUntilElementIsPresent(By by){
        return new WebDriverWait(WebDriverSingleton.getWebDriver(),
                Duration.ofSeconds(waitTime)).until(ExpectedConditions.presenceOfElementLocated(by));
    }




//    public WebElement waitUntilElementIsPresent(List<By> by){
//        return new WebDriverWait(WebDriverSingleton.getWebDriver(),
//                Duration.ofSeconds(waitTime)).until(ExpectedConditions.presenceOfNestedElementsLocatedBy(by,));
//    }
//
//
    public WebElement waitUntilElementIsClickable(By by){
        return new WebDriverWait(WebDriverSingleton.getWebDriver(),
                Duration.ofSeconds(waitTime)).until(ExpectedConditions.elementToBeClickable(by));
    }

    public Alert waitUntilAlertIsPresent(){
        return new WebDriverWait(WebDriverSingleton.getWebDriver(),
                Duration.ofSeconds(waitTime)).until(ExpectedConditions.alertIsPresent());
    }


}
