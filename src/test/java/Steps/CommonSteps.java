package Steps;

import ObjectManager.BasePage;
import cucumber.TestCaseContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.util.prefs.Preferences;


public class CommonSteps extends BasePage {
    TestCaseContext testContext;


    public CommonSteps(TestCaseContext context) {
        testContext = context;
    }


    @Given("^I open web page as guest")
    public void i_open_web_page() {
        launchBrowser(testContext.getBasePage().getDriver());
        validateTitle();
    }

    @Then("^I close the browser$")
    public void i_close_the_browser() {
        closeDriver(testContext.getBasePage().getDriver());
    }


    public void validateTitle() {
        String titleValue = getPageTitle(testContext.getBasePage().getDriver());
        System.out.println("Title is:"+titleValue);
        Assert.assertTrue(titleValue.equals("trivago Magazine"));
    }

}
