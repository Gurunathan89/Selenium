package Steps;

import ObjectManager.BasePage;

import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.TestCaseContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.common.io.Files;
import utils.PropertyUtils;

public class Hook {
    TestCaseContext testContext;
    BasePage baseUtils = new BasePage();

    public Hook(TestCaseContext context) {
        testContext = context;
    }

    final SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String formattedTime = timeFormat.format(new Date()).replace(":", "_");
    String reportPath = System.getProperty("user.dir") + "/reports";


    @Before
    public void BeforeSteps(Scenario scenario) {
        System.out.println("Execution Of Scenario - \"" + scenario.getName() + "\" - Started..");
        System.out.println("----------------------------------------------------------------------------");

    }

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
}
