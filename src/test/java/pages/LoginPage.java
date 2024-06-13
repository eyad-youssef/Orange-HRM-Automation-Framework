package pages;

import org.openqa.selenium.By;
import pages.subPages.AdminPage;


public class LoginPage extends BasePage {

    private final By userName = By.name("username");
    private final By passWord = By.name("password");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By adminTab = By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");



    public void enterUsername(String username) {
        waitUntilElementIsPresent(userName).sendKeys(username);

    }

    public void enterPassword(String password) {
        waitUntilElementIsPresent(passWord).sendKeys(password);

    }



    public void clickOnLoginButton() {

        waitUntilElementIsPresent(loginButton).click();

    }
//    public Boolean getMessage(){
//       return  waitUntilElementIsPresent(statusMessage).isDisplayed();
//
//    }
//
    public  void clickOnAdminTab(){
        waitUntilElementIsPresent(adminTab).click();
    }



    public AdminPage goToAdminPage(){
        return new AdminPage();
 }
//
// public AccountOverviewPage openAccountOverviewPage( ){return new AccountOverviewPage();}
//    public NewAccountPage openNewAccountPage(){
//        return new NewAccountPage();
//    }
}
