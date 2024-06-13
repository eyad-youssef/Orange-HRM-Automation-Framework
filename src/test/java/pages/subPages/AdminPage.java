package pages.subPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminPage extends BasePage {

    private final By recordsCount = By.xpath("//span[@class = 'oxd-text oxd-text--span']");
    private final By addButton = By.xpath("//*[@class='oxd-icon bi-plus oxd-button-icon']");
    private final By userRoleArrow = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]");
    private final By statusArrow = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]/i");
    private final By usernameTextField = By.xpath("(//input[@class= 'oxd-input oxd-input--active'])[2]");
    private final By passwordTextField = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
    private final By confirmedPasswordTextField = By.xpath("(//input[@type='password'])[2]");
    private final By saveButton = By.xpath("//button[@type= 'submit']");
    private final By employeeNameTextField = By.xpath("//input[@placeholder='Type for hints...']");
    private final By userNameSearchField = By.xpath("//input[@class='oxd-input oxd-input--active']");
    private final By searchButton = By.xpath("//button[@type='submit']");
    private final By deleteButton = By.xpath("//button[@class='oxd-icon-button oxd-table-cell-action-space']");
    private final By confirmDeleteButton = By.xpath("//button[contains(.,' Yes, Delete ')]");


    public String getRecordsCount() {
        String count = waitUntilElementIsPresent(recordsCount).getText();
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(count);
        String number = null;
        if (matcher.find()) {
            number = matcher.group(1);
            System.out.println("Extracted number: " + number);

        } else {
            System.out.println("No number found in the text");
        }

        return number;
    }


    public void clickOnAddButton() {

        waitUntilElementIsPresent(addButton).click();
    }

    public void selectUserRole(String userRole) {
        int indexOfSelectedUserRole;
        waitUntilElementIsClickable(userRoleArrow).click();
        if (userRole.equalsIgnoreCase("ESS")) {
            indexOfSelectedUserRole = 3;
        } else if (userRole.equalsIgnoreCase("Admin")) {
            indexOfSelectedUserRole = 2;
        } else {
            indexOfSelectedUserRole = 1;
        }
        driver.findElement(By.xpath("(//div[@role='listbox']//child::div)[" + indexOfSelectedUserRole + "]")).click();

    }

    public void selectStatus(String status) {
        int indexOfSelectedStatus;
        waitUntilElementIsClickable(statusArrow).click();
        if (status.equalsIgnoreCase("Disabled")) {
            indexOfSelectedStatus = 3;
        } else if (status.equalsIgnoreCase("Enabled")) {
            indexOfSelectedStatus = 2;
        } else {
            indexOfSelectedStatus = 1;
        }
        driver.findElement(By.xpath("(//div[@role='listbox']//child::div)[" + indexOfSelectedStatus + "]")).click();

    }

    public void enterEmployeeName(String employeeName) throws InterruptedException {

        waitUntilElementIsPresent(employeeNameTextField);
        driver.findElement(employeeNameTextField).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(driver.findElement(employeeNameTextField), employeeName).perform();
        Thread.sleep(2000);
        actions.sendKeys(driver.findElement(employeeNameTextField), Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        actions.sendKeys(driver.findElement(employeeNameTextField), Keys.ENTER).perform();

    }

    public void enterUsername(String username) {
        waitUntilElementIsPresent(usernameTextField);
        driver.findElement(usernameTextField).sendKeys(username);

    }

    public void enterPassword(String password) {
        waitUntilElementIsPresent(passwordTextField);
        driver.findElement(passwordTextField).sendKeys(password);

    }

    public void enterConfirmedPassword(String confirmedPassword) throws InterruptedException {
        waitUntilElementIsPresent(confirmedPasswordTextField);
        driver.findElement(confirmedPasswordTextField).sendKeys(confirmedPassword);


    }

    public void clickOnSaveButton() {
        waitUntilElementIsPresent(saveButton);
        driver.findElement(saveButton).click();

    }




    public void searchForUser(String username){
        waitUntilElementIsPresent(userNameSearchField).sendKeys(username);
        waitUntilElementIsClickable(searchButton).click();

    }
    public void deleteNewUser() throws InterruptedException {
        waitUntilElementIsClickable(deleteButton).click();
        Thread.sleep(8000);
        waitUntilElementIsClickable(confirmDeleteButton).click();
    }

}
