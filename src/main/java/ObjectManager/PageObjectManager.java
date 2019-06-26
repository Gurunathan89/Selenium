package ObjectManager;

import Pages.CustomerPage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class PageObjectManager {


    private CustomerPage customerPage;
    private WebDriver driver;


    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }


    public CustomerPage getCustomerPage() throws IOException {
        return (customerPage == null) ? customerPage = new CustomerPage(driver) : customerPage;

    }


}
