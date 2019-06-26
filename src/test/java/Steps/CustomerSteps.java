package Steps;

import Pages.CustomerPage;
import cucumber.TestCaseContext;
import cucumber.api.java.en.Then;


import java.io.IOException;


public class CustomerSteps {
    TestCaseContext testContext;
    CustomerPage customerPage;

    public CustomerSteps(TestCaseContext context) throws IOException {
        testContext = context;
        customerPage = testContext.getPageObjectManager().getCustomerPage();
    }
    @Then("^I Search for destination using \"([^\"]*)\"$")
    public void i_Search_for_restaurants_using(String country) {
        customerPage.searchDestination(country);
    }

}
