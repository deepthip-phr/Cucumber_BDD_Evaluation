package steps;

import com.motivitylabs.Automation.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void initializeBrowser() {
        BasePage.launchBrowser();
    }

    @After
    public void closeBrowser() {
        BasePage.killSession();
    }
}
