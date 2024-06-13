package tests.scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import tests.BaseTest;

public class NewUserStepDefinition extends BaseTest {

    int oldCount;
    int updatedCount ;

    @Given("Admin login with {string} and {string} to OrangeHRM login page")
    public void adminLoginWithAndToOrangeHRMLoginPage(String adminUsername, String adminPassword) throws InterruptedException {
        orangeHRM.login.enterUsername(adminUsername);
        orangeHRM.login.enterPassword(adminPassword);
        orangeHRM.login.clickOnLoginButton();

    }


    @And("Click on Admin")
    public void clickOnAdmin() throws InterruptedException {
        Thread.sleep(2000);
        orangeHRM.login.clickOnAdminTab();
        orangeHRM.adminPage=orangeHRM.login.goToAdminPage();

    }

    @And("Count Users Records")
    public void countOldUsersRecords() {
        oldCount = Integer.parseInt(orangeHRM.adminPage.getRecordsCount());
    }



    @And("Click on Add button")
    public void clickOnAddButton() {
        orangeHRM.adminPage.clickOnAddButton();
    }

    @And("Select User Role with {string}")
    public void selectUserRoleWith(String userRole) {
        orangeHRM.adminPage.selectUserRole(userRole);
    }

    @And("Enter employee name with {string}")
    public void enterEmployeeNameWith(String employeeName) throws InterruptedException {
        orangeHRM.adminPage.enterEmployeeName(employeeName);
    }

    @And("Select Status with {string}")
    public void selectStatusWith(String status) {
        orangeHRM.adminPage.selectStatus(status);
    }

    @And("Enter Username with{string}")
    public void enterUsernameWith(String username) throws InterruptedException {
        Thread.sleep(2000);
        orangeHRM.adminPage.enterUsername(username);
    }

    @And("Enter Password with{string}")
    public void enterPasswordWith(String password) throws InterruptedException {
        Thread.sleep(2000);
        orangeHRM.adminPage.enterPassword(password);

    }

    @And("Enter Confirmed Password with{string}")
    public void enterConfirmedPasswordWith(String confirmedPassword) throws InterruptedException {
        Thread.sleep(2000);
        orangeHRM.adminPage.enterConfirmedPassword(confirmedPassword);

    }

    @Then("Click on Save Button")
    public void clickOnSaveButton() throws InterruptedException {
        Thread.sleep(2000);
        orangeHRM.adminPage.clickOnSaveButton();

        Assert.assertEquals(orangeHRM.adminPage.getRecordsCount(),orangeHRM.adminPage.getRecordsCount()+1);
    }


    @And("Count Users Records after adding new user")
    public void countUpdatedUsersRecords() {

        updatedCount =  Integer.parseInt(orangeHRM.adminPage.getRecordsCount());
        Assert.assertEquals(updatedCount,oldCount+1);

    }

    @Then("Click on Search Button")
    public void clickOnSearchButton(String username) throws InterruptedException {
        Thread.sleep(10000);
        orangeHRM.adminPage.searchForUser(username);

    }

    @And("Click on delete icon")
    public void clickOnDeleteIcon() throws InterruptedException {
        orangeHRM.adminPage.deleteNewUser();
    }

    @Then("Get new users count")
    public void getNewUsersCountAfterDeletion() throws InterruptedException {
        orangeHRM.adminPage.deleteNewUser();
        Assert.assertEquals(updatedCount, updatedCount-1);
    }


}