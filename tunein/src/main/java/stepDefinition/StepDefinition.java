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
import com.mashape.unirest.http.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.concurrent.TimeUnit;

public class StepDefinition {

    String chromeDriverPath = "/Users/is_2179_dhara/Downloads/chromedriver"; // Download chrome driver and save it in directory. Specify the chrome path here.
    private static final ObjectMapper OM = new ObjectMapper() ;
    private WebDriver webDriver;
    Results results ;

    @Given("^I am a user$")
    public void initiateDriver() {
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        results = new Results();
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
        String endPoint = "http://localhost:9200/";
        String slide =null;

        for(int i=0;i<5;i++) {
            for(int j=1;j<=3;j++) {
                heroCarouselTextContainer = "heroCarouselTextContainer"+i;
                line= "line"+j;
                expression = "[data-testid='"+heroCarouselTextContainer+"']>[data-testid='heroTextElement']>[data-testid='"+line+"']";
                element = webDriver.findElement(By.cssSelector(expression));
                 if(j==1)
                {
                    results.setText1(element.getAttribute("innerHTML"));
                    results.setText1HREF( element.getAttribute("href"));
                    System.out.println("element.getText() = " + element.getAttribute("innerHTML"));
                    System.out.println("Element Href = " + element.getAttribute("href"));
                }
               else if(j==2)
                {
                    results.setText2(element.getAttribute("innerHTML"));
                    results.setText2HREF( element.getAttribute("href"));
                    System.out.println("element.getText() = " + element.getAttribute("innerHTML"));
                    System.out.println("Element Href = " + element.getAttribute("href"));
                }
                else if(j==3)
                {
                    results.setText3(element.getAttribute("innerHTML"));
                    results.setText3HREF( element.getAttribute("href"));
                    System.out.println("element.getText() = " + element.getAttribute("innerHTML"));
                    System.out.println("Element Href = " + element.getAttribute("href"));
                }
            }

            heroCarouselTextContainer= "homeCarouselElement-"+i;
            expression = "[data-testid='"+heroCarouselTextContainer+"']";
            element = webDriver.findElement(By.cssSelector(expression));
            System.out.println(" Image Href = " + element.getAttribute("href"));
                results.setImageHREF(element.getAttribute("href"));

                slide = "slide"+i;
            try {
                Unirest.post(endPoint+slide+"/results")
                        .header("Content-Type", "application/json")
                        .body(OM.writeValueAsString(results)).asJson();
                Thread.sleep(2000);
                System.out.println("Write to Document in elastic success \n ");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            }

    }


    @And("^I should Exit$")
    public void iExitBrowser()throws Exception {
        Thread.sleep(1000);
        webDriver.quit();
    }
}
