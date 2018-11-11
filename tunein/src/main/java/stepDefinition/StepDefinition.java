package stepDefinition;

import constants.Constants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StepDefinition {

    String chromeDriverPath = "/Users/is_2179_dhara/Downloads/chromedriver"; // Download chrome driver and save it in directory. Specify the chrome path here.

    private WebDriver webDriver;

    @Given("^I am a user$")
    public void initiateDriver() {
        System.out.println("Given called ");
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
 }

    @When("^I Navigate to TuneIn url$")
    public void iNavigateToTuneInUrl() {
        webDriver = new ChromeDriver();
         webDriver.get(Constants.TuneIn_url);
       }

    @Then("^I should see TuneIn Landing Page$")
    public void verifySomething() {
        // To- Do
    }

    @And("^I should Exit$")
    public void iExitBrowser()throws Exception {
        Thread.sleep(10000);
        webDriver.quit();
    }
}
