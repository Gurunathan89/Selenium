Selenium-Cucumber-Java Setup Guide

Features

All scripts written with > Java,Selenium & Cucumber.
Neat folder structures with output in reports folder.
Page Object design pattern implementation.
Extensive hooks implemented for BeforeFeature, AfterScenarios etc.
Screenshots on failure feature scenarios.
To Get Started
Pre-requisites
1.Java Installed

2.Chrome or Firefox browsers installed.

3.Intellij/Eclipse - IDE.

4.IntelliJ IDEA Cucumber for Java plugin/Cucumber Eclipse

5.Maven installed


Setup Scripts
1.Extract the zip contents into a folder
2.Open the project in intellij or eclipse
3.Configure the cucumber plugin for IDE's
4.Right click the TestRunner under 'Runner' package and Run

Writing Features

Scenario Outline: As a guest, i want to place order in takeaway.com website
    Given I open web page as guest
    Then I Search for restaurants using "<pincode>"
    And I Should see list of restaurants available under "<location>"
    Then I click on "<Restaurant>"
    Then I Should See the Restaurant details


Writing Step Definitions
package Steps;

import Pages.CustomerPage;
import cucumber.TestCaseContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;


public class CustomerSteps {
    TestCaseContext testContext;
    CustomerPage customerPage;

    public CustomerSteps(TestCaseContext context) throws IOException {
        testContext = context;
        customerPage = testContext.getPageObjectManager().getCustomerPage();
    }

     @Then("^I Should see list of restaurants available under \"([^\"]*)\"$")
        public void i_Should_see_list_of_restaurants_available_under(String location) {
            customerPage.validateSearchResultsPage(location);
        }

}
Writing Page Objects
import java.util.Properties;


public class CustomerPage extends BasePage {

    WebDriver driver;
    Properties propertyValue = getPropertyValue();

       public By idDropDownSearch = getLocator(propertyValue.getProperty("idDropDownSearch"), BY_TYPE.BY_XPATH);
       public By idGeoLocation = getLocator(propertyValue.getProperty("idGeoLocation"), BY_TYPE.BY_XPATH);
       public By idRestaurantCount = getLocator(propertyValue.getProperty("idRestaurantCount"), BY_TYPE.BY_XPATH);
       public By idRestaurants = getLocator(propertyValue.getProperty("idRestaurants"), BY_TYPE.BY_XPATH);

    }

Cucumber Hooks
Following method takes screenshot on failure of each scenario

 @After
    public void afterScenario(Scenario scenario) {

        try {
            if (scenario.isFailed()) {
                String screenshotName = scenario.getName().replaceAll(" ", "_");

                //This takes a screenshot from the driver at save it to the specified location
                File sourcePath = ((TakesScreenshot) testContext.getBasePage().getDriver()).getScreenshotAs(OutputType.FILE);

                //Building up the destination path for the screenshot to save
                //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
                File destinationPath = new File(  reportPath + "/screenshots/" + screenshotName + "_" + formattedTime + ".png");

                //Copy taken screenshot from source location to destination location
                Files.copy(sourcePath, destinationPath);

                //This attach the specified screenshot to the test
                Reporter.addScreenCaptureFromPath("./screenshots/" + screenshotName + "_" + formattedTime + ".png");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        baseUtils.closeDriver(testContext.getBasePage().getDriver());
    }

HTML Reports
Currently this project has been integrated with Extent-cucumber-reporter, which is generated in the reports folder when you run TestRunner Class.
