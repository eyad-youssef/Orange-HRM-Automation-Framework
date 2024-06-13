package tests;


import io.cucumber.testng.*;
import io.cucumber.testng.CucumberOptions;
//import org.testng.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/tests/scenario",
        glue = "src/test/java/tests/scenario",
        tags= "@HRM" ,
//        plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
        monochrome = true
)


public class TestRunner {
}
