package cucumber;
import ObjectManager.PageObjectManager;
import ObjectManager.BasePage;

public class TestCaseContext {

    private BasePage basePage;
    private PageObjectManager pageObjectManager;

    public TestCaseContext(){
        basePage = new BasePage();
        pageObjectManager = new PageObjectManager(basePage.getDriver());
    }

    public BasePage getBasePage() {
        return basePage;
    }
    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

}
