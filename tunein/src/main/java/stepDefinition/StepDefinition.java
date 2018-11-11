package stepDefinition;

import constants.Constants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class StepDefinition {

    String chromeDriverPath = "/Users/is_2179_dhara/Downloads/chromedriver"; // Download chrome driver and save it in directory. Specify the chrome path here.

    private WebDriver webDriver;

    @Given("^I am a user$")
    public void initiateDriver() {
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
 }

    @When("^I Navigate to TuneIn url$")
    public void iNavigateToTuneInUrl() {
        webDriver = new ChromeDriver();
         webDriver.get(Constants.TuneIn_url);
         webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);


       }

    @Then("^I should see TuneIn Landing Page$")
    public void verifySomething() {
        WebDriverWait wait = new WebDriverWait(webDriver,60);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='heroCarouselTextContainer0']>[data-testid='heroTextElement']>[data-testid='line1']")));
        WebElement element ;
        String expression;
        String heroCarouselTextContainer;
        String line;

        for(int i=0;i<5;i++) {
            for(int j=1;j<=3;j++) {
                heroCarouselTextContainer = "heroCarouselTextContainer"+i;
                line= "line"+j;
                expression = "[data-testid='"+heroCarouselTextContainer+"']>[data-testid='heroTextElement']>[data-testid='"+line+"']";
                element = webDriver.findElement(By.cssSelector(expression));
                System.out.println("element.getText() = " + element.getAttribute("innerHTML"));
            }
            System.out.println("Slide Number = " +i);
        }

    }

    @And("^I should Exit$")
    public void iExitBrowser()throws Exception {
        Thread.sleep(1000);
        webDriver.quit();
    }
}
