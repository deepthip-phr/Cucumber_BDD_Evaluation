package steps;
import com.motivitylabs.Automation.BasePage;
import com.motivitylabs.DataManager.ReadingDatafromJson;
import com.motivitylabs.Pages.ContactPage;
import com.motivitylabs.Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.io.FileNotFoundException;

public class HomeStep extends BasePage {
    HomePage homePage;
    ContactPage contactPage;
    ReadingDatafromJson reader;
    @Given("I am on the HomePage")
    public void i_am_on_the_home_page() {

    }
    @Then("I click on contact form")
    public void i_click_on_contact_form() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.clickOnContact();
    }
    @Then("I fill the form and submit")
    public void i_fill_the_form_and_submit() throws InterruptedException, FileNotFoundException {
        reader= new ReadingDatafromJson();
        contactPage = new ContactPage(driver);
        contactPage.formFilling(reader.ReadingData("name"),reader.ReadingData("email"),reader.ReadingData("message"));

    }

    /**
     * Verifying the Success Message
     * @throws FileNotFoundException
     */
    @Then("I verify successfull submissiom")
    public void i_verify_successfull_submissiom() throws FileNotFoundException {
        String actualMessage = contactPage.gettingMessage();
        String expectedMessage = reader.ReadingData("expectedMessage");
        Assert.assertEquals(actualMessage,expectedMessage);

    }

}
