package Pages;

import ObjectManager.BasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;


public class CustomerPage extends BasePage {
    WebDriver driver;

    Properties propertyValue = getPropertyValue();
    Faker faker = new Faker();
    String FIRST_NAME = faker.name().firstName();
    String EMAIL = faker.internet().emailAddress();
    String PHONE = faker.phoneNumber().cellPhone();

    public CustomerPage(WebDriver driver) throws IOException {
        this.driver = driver;
    }

    public By idSearchIcon = getLocator(propertyValue.getProperty("idSearchIcon"), BasePage.BY_TYPE.BY_XPATH);
    public By idEnterSearchLocation = getLocator(propertyValue.getProperty("idEnterSearchLocation"), BasePage.BY_TYPE.BY_XPATH);



    public void searchDestination(String country) {
        addExplicitWait(driver, idSearchIcon, "visibility", 5);
        click(driver, idSearchIcon);
        addExplicitWait(driver, idEnterSearchLocation, "visibility", 5);
        click(driver, idEnterSearchLocation);
        type(driver, idEnterSearchLocation, country, "Search box in homepage");
        addExplicitWait(driver, idEnterSearchLocation, "presence", 5);

    }
}
