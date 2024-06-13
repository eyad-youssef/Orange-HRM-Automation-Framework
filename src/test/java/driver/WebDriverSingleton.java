package driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class WebDriverSingleton {
    private static WebDriver webDriver;
    private static WebDriverSingleton webDriverSingleton = null;

    private WebDriverSingleton() {
        setDriverCapabilities();
    }

    public static WebDriverSingleton getDriverSingleton() {
        if (webDriverSingleton == null)
            webDriverSingleton = new WebDriverSingleton();
        return webDriverSingleton;
    }

    private void setDriverCapabilities() {

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        webDriver = new EdgeDriver(options);
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public void navigateTo(String link) throws InterruptedException {
        webDriver.navigate().to(link);


    }

    public void refreshCurrentUrl() {
        webDriver.navigate().refresh();
    }

    public void resetCache() {
        webDriver.manage().deleteAllCookies();
    }

    public static void close() {
        webDriver.quit();
    }
}
