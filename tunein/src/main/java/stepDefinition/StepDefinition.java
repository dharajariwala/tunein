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
 import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.mashape.unirest.http.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.testng.*;

public class StepDefinition {

    private final Logger logger = Logger.getLogger(String.valueOf(StepDefinition.class));

    String chromeDriverPath = "/Users/is_2179_dhara/Downloads/chromedriver"; // Download chrome driver and save it in directory. Specify the chrome path here.
    private static final ObjectMapper OM = new ObjectMapper() ;
    private WebDriver webDriver;
    Results results ;
    String endPoint = "http://localhost:9200/";
    String slide0_data[] = new String[7];
    String slide1_data[] = new String[7];
    String slide2_data[] = new String[7];
    String slide3_data[] = new String[7];
    String slide4_data[] = new String[7];

    
    @Given("^I open my browser$")
    public void initiateDriver() {
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        results = new Results();
        HttpResponse<com.mashape.unirest.http.JsonNode> response;
        String slide=null;

        for(int i=0;i<5;i++) {
            slide = "slide"+i;
            try {
                response = Unirest.post(endPoint + slide +"/_search")
                        .header("Content-Type", "application/json")
                        .body("{\n" +
                                "  \"query\": {\n" +
                                "    \"match_all\": {}\n" +
                                "  },\n" +
                                "  \"size\": 1,\n" +
                                "  \"sort\": [\n" +
                                "    {\n" +
                                "      \"timeStamp\": {\n" +
                                "        \"order\": \"desc\"\n" +
                                "      }\n" +
                                "    }\n" +
                                "  ]\n" +
                                "}").asJson();

                switch(i)
                {
                    case 0:
                        slide0_data[0] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text1")).toString();
                        slide0_data[1] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text1href")).toString();
                        slide0_data[2] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text2")).toString();
                        slide0_data[3] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text2href")).toString();
                        slide0_data[4] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text3")).toString();
                        slide0_data[5] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text3href")).toString();
                        slide0_data[6] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("imagehref")).toString();
                        break;

                    case 1:
                        slide1_data[0] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text1")).toString();
                        slide1_data[1] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text1href")).toString();
                        slide1_data[2] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text2")).toString();
                        slide1_data[3] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text2href")).toString();
                        slide1_data[4] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text3")).toString();
                        slide1_data[5] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text3href")).toString();
                        slide1_data[6] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("imagehref")).toString();
                        break;

                    case 2:
                        slide2_data[0] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text1")).toString();
                        slide2_data[1] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text1href")).toString();
                        slide2_data[2] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text2")).toString();
                        slide2_data[3] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text2href")).toString();
                        slide2_data[4] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text3")).toString();
                        slide2_data[5] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text3href")).toString();
                        slide2_data[6] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("imagehref")).toString();
                        break;

                    case 3:
                        slide3_data[0] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text1")).toString();
                        slide3_data[1] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text1href")).toString();
                        slide3_data[2] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text2")).toString();
                        slide3_data[3] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text2href")).toString();
                        slide3_data[4] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text3")).toString();
                        slide3_data[5] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text3href")).toString();
                        slide3_data[6] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("imagehref")).toString();
                        break;

                    case 4:
                        slide4_data[0] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text1")).toString();
                        slide4_data[1] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text1href")).toString();
                        slide4_data[2] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text2")).toString();
                        slide4_data[3] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text2href")).toString();
                        slide4_data[4] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text3")).toString();
                        slide4_data[5] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("text3href")).toString();
                        slide4_data[6] = (response.getBody().getObject().getJSONObject("hits").getJSONArray("hits").getJSONObject(0).getJSONObject("_source").get("imagehref")).toString();
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

 }

    @When("^I Navigate to TuneIn url$")
    public void iNavigateToTuneInUrl() {
        webDriver = new ChromeDriver();
         webDriver.get(Constants.TuneIn_url);
         webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
       }

    @Then("^I should see TuneIn Landing Page with slides Text Href and Images are changed from Last Automation Run$")
    public void verifyTextHrefImageHrefChanged() {
        WebDriverWait wait = new WebDriverWait(webDriver,60);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='heroCarouselTextContainer0']>[data-testid='heroTextElement']>[data-testid='line1']")));
        WebElement element ;
        String expression;
        String heroCarouselTextContainer;
        String line;
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

                    switch(i) {
                        case 0:
                            Assert.assertEquals(slide0_data[0], element.getAttribute("innerHTML"));
                            logger.info(" Slide Number = " +i+ " Line Number = "+j+ " Oldvalue from Elastic = "+slide0_data[0]+ " New value on UI = "+element.getAttribute("innerHTML"));
                            Assert.assertEquals(slide0_data[1], element.getAttribute("href"));
                            logger.info(" Slide Number = " +i+ " Line Number ="+j+ " oldHref from Elastic = "+slide0_data[1]+ " New href on UI = "+element.getAttribute("href"));
                            break;
                        case 1:
                            Assert.assertEquals(slide1_data[0], element.getAttribute("innerHTML"));
                            logger.info(" Slide Number = " +i+ " Line Number = "+j+ " Oldvalue from Elastic = "+slide1_data[0]+ " New value on UI = "+element.getAttribute("innerHTML"));
                            Assert.assertEquals(slide1_data[1], element.getAttribute("href"));
                            logger.info(" Slide Number = " +i+ " Line Number ="+j+ " oldHref from Elastic = "+slide1_data[1]+ " New href on UI = "+element.getAttribute("href"));
                            break;
                        case 2:
                            Assert.assertEquals(slide2_data[0], element.getAttribute("innerHTML"));
                            logger.info(" Slide Number = " +i+ " Line Number = "+j+ " Oldvalue from Elastic = "+slide2_data[0]+ " New value on UI = "+element.getAttribute("innerHTML"));
                            Assert.assertEquals(slide2_data[1], element.getAttribute("href"));
                            logger.info(" Slide Number = " +i+ " Line Number ="+j+ " oldHref from Elastic = "+slide2_data[1]+ " New href on UI = "+element.getAttribute("href"));

                            break;
                        case 3:
                            Assert.assertEquals(slide3_data[0], element.getAttribute("innerHTML"));
                            logger.info(" Slide Number = " +i+ " Line Number = "+j+ " Oldvalue from Elastic = "+slide3_data[0]+ " New value on UI = "+element.getAttribute("innerHTML"));
                            Assert.assertEquals(slide3_data[1], element.getAttribute("href"));
                            logger.info(" Slide Number = " +i+ " Line Number ="+j+ " oldHref from Elastic = "+slide3_data[1]+ " New href on UI = "+element.getAttribute("href"));

                            break;
                        case 4:
                            Assert.assertEquals(slide4_data[0], element.getAttribute("innerHTML"));
                            logger.info(" Slide Number = " +i+ " Line Number = "+j+ " Oldvalue from Elastic = "+slide4_data[0]+ " New value on UI = "+element.getAttribute("innerHTML"));
                            Assert.assertEquals(slide4_data[1], element.getAttribute("href"));
                            logger.info(" Slide Number = " +i+ " Line Number ="+j+ " oldHref from Elastic = "+slide4_data[1]+ " New href on UI = "+element.getAttribute("href"));
                            break;
                    }

                }
               else if(j==2)
                {
                    results.setText2(element.getAttribute("innerHTML"));
                    results.setText2HREF( element.getAttribute("href"));

                    switch(i) {
                        case 0:
                            Assert.assertEquals(slide0_data[2], element.getAttribute("innerHTML"));
                            logger.info(" Slide Number = " +i+ " Line Number = "+j+ " Oldvalue from Elastic = "+slide0_data[2]+ " New value on UI = "+element.getAttribute("innerHTML"));
                            Assert.assertEquals(slide0_data[3], element.getAttribute("href"));
                            logger.info(" Slide Number = " +i+ " Line Number ="+j+ " oldHref from Elastic = "+slide0_data[3]+ " New href on UI = "+element.getAttribute("href"));

                            break;
                        case 1:
                            Assert.assertEquals(slide1_data[2], element.getAttribute("innerHTML"));
                            logger.info(" Slide Number = " +i+ " Line Number = "+j+ " Oldvalue from Elastic = "+slide1_data[2]+ " New value on UI = "+element.getAttribute("innerHTML"));
                            Assert.assertEquals(slide1_data[3], element.getAttribute("href"));
                            logger.info(" Slide Number = " +i+ " Line Number ="+j+ " oldHref from Elastic = "+slide1_data[3]+ " New href on UI = "+element.getAttribute("href"));

                            break;
                        case 2:
                            Assert.assertEquals(slide2_data[2], element.getAttribute("innerHTML"));
                            logger.info(" Slide Number = " +i+ " Line Number = "+j+ " Oldvalue from Elastic = "+slide2_data[2]+ " New value on UI = "+element.getAttribute("innerHTML"));
                            Assert.assertEquals(slide2_data[3], element.getAttribute("href"));
                            logger.info(" Slide Number = " +i+ " Line Number ="+j+ " oldHref from Elastic = "+slide2_data[3]+ " New href on UI = "+element.getAttribute("href"));

                            break;
                        case 3:
                            Assert.assertEquals(slide3_data[2], element.getAttribute("innerHTML"));
                            logger.info(" Slide Number = " +i+ " Line Number = "+j+ " Oldvalue from Elastic = "+slide3_data[2]+ " New value on UI = "+element.getAttribute("innerHTML"));
                            Assert.assertEquals(slide3_data[3], element.getAttribute("href"));
                            logger.info(" Slide Number = " +i+ " Line Number ="+j+ " oldHref from Elastic = "+slide3_data[3]+ " New href on UI = "+element.getAttribute("href"));

                            break;
                        case 4:
                            Assert.assertEquals(slide4_data[2], element.getAttribute("innerHTML"));
                            logger.info(" Slide Number = " +i+ " Line Number = "+j+ " Oldvalue from Elastic = "+slide4_data[2]+ " New value on UI = "+element.getAttribute("innerHTML"));
                            Assert.assertEquals(slide4_data[3], element.getAttribute("href"));
                            logger.info(" Slide Number = " +i+ " Line Number ="+j+ " oldHref from Elastic = "+slide4_data[3]+ " New href on UI = "+element.getAttribute("href"));

                            break;
                    }

                  }
                else if(j==3)
                {
                    results.setText3(element.getAttribute("innerHTML"));
                    results.setText3HREF( element.getAttribute("href"));

                    switch(i) {
                        case 0:
                            Assert.assertEquals(slide0_data[4], element.getAttribute("innerHTML"));
                            logger.info(" Slide Number = " +i+ " Line Number = "+j+ " Oldvalue from Elastic = "+slide0_data[4]+ " New value on UI = "+element.getAttribute("innerHTML"));
                            Assert.assertEquals(slide0_data[5], element.getAttribute("href"));
                            logger.info(" Slide Number = " +i+ " Line Number ="+j+ " oldHref from Elastic = "+slide0_data[5]+ " New href on UI = "+element.getAttribute("href"));

                            break;
                        case 1:
                            Assert.assertEquals(slide1_data[4], element.getAttribute("innerHTML"));
                            logger.info(" Slide Number = " +i+ " Line Number = "+j+ " Oldvalue from Elastic = "+slide1_data[4]+ " New value on UI = "+element.getAttribute("innerHTML"));
                            Assert.assertEquals(slide1_data[5], element.getAttribute("href"));
                            logger.info(" Slide Number = " +i+ " Line Number ="+j+ " oldHref from Elastic = "+slide1_data[5]+ " New href on UI = "+element.getAttribute("href"));

                            break;
                        case 2:
                            Assert.assertEquals(slide2_data[4], element.getAttribute("innerHTML"));
                            logger.info(" Slide Number = " +i+ " Line Number = "+j+ " Oldvalue from Elastic = "+slide2_data[4]+ " New value on UI = "+element.getAttribute("innerHTML"));
                            Assert.assertEquals(slide2_data[5], element.getAttribute("href"));
                            logger.info(" Slide Number = " +i+ " Line Number ="+j+ " oldHref from Elastic = "+slide2_data[5]+ " New href on UI = "+element.getAttribute("href"));

                            break;
                        case 3:
                            Assert.assertEquals(slide3_data[4], element.getAttribute("innerHTML"));
                            logger.info(" Slide Number = " +i+ " Line Number = "+j+ " Oldvalue from Elastic = "+slide3_data[4]+ " New value on UI = "+element.getAttribute("innerHTML"));
                            Assert.assertEquals(slide3_data[5], element.getAttribute("href"));
                            logger.info(" Slide Number = " +i+ " Line Number ="+j+ " oldHref from Elastic = "+slide3_data[5]+ " New href on UI = "+element.getAttribute("href"));
                            break;
                        case 4:
                            Assert.assertEquals(slide4_data[4], element.getAttribute("innerHTML"));
                            logger.info(" Slide Number = " +i+ " Line Number = "+j+ " Oldvalue from Elastic = "+slide4_data[4]+ " New value on UI = "+element.getAttribute("innerHTML"));
                            Assert.assertEquals(slide4_data[5], element.getAttribute("href"));
                            logger.info(" Slide Number = " +i+ " Line Number ="+j+ " oldHref from Elastic = "+slide4_data[5]+ " New href on UI = "+element.getAttribute("href"));

                            break;
                    }

                   }
            }
            heroCarouselTextContainer= "homeCarouselElement-"+i;
            expression = "[data-testid='"+heroCarouselTextContainer+"']";
            element = webDriver.findElement(By.cssSelector(expression));
          //  System.out.println(" Image Href = " + element.getAttribute("href"));
                results.setImageHREF(element.getAttribute("href"));


            switch(i) {
                case 0:
                    Assert.assertEquals(slide0_data[6], element.getAttribute("href"));
                    logger.info(" Slide Number = " +i+ "Image oldHref from Elastic = "+slide0_data[6]+ " New href on UI = "+element.getAttribute("href"));

                    break;
                case 1:
                    Assert.assertEquals(slide1_data[6], element.getAttribute("href"));
                    logger.info(" Slide Number = " +i+ "Image oldHref from Elastic = "+slide1_data[6]+ " New href on UI = "+element.getAttribute("href"));

                    break;
                case 2:
                    Assert.assertEquals(slide2_data[6], element.getAttribute("href"));
                    logger.info(" Slide Number = " +i+ "Image oldHref from Elastic = "+slide2_data[6]+ " New href on UI = "+element.getAttribute("href"));

                    break;
                case 3:
                    Assert.assertEquals(slide3_data[6], element.getAttribute("href"));
                    logger.info(" Slide Number = " +i+ "Image oldHref from Elastic = "+slide3_data[6]+ " New href on UI = "+element.getAttribute("href"));

                    break;
                case 4:
                    Assert.assertEquals(slide4_data[6], element.getAttribute("href"));
                    logger.info(" Slide Number = " +i+ "Image oldHref from Elastic = "+slide4_data[6]+ " New href on UI = "+element.getAttribute("href"));

                    break;
            }


                results.setTimeStamp(System.currentTimeMillis());
                slide = "slide"+i;
                try {
                Unirest.post(endPoint+slide+"/results")
                        .header("Content-Type", "application/json")
                        .body(OM.writeValueAsString(results)).asJson();
                Thread.sleep(2000);
                    logger.info("Write to Elastic success");
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
