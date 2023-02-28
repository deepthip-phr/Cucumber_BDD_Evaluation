package com.motivitylabs.Pages;
import com.motivitylabs.Actions.SeleniumActions;
import com.motivitylabs.Waits.SeleniumWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
    WebDriver driver;
    SeleniumActions seleniumActions;
    SeleniumWaits seleniumWaits;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        seleniumActions = new SeleniumActions(driver);
        seleniumWaits = new SeleniumWaits(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[class$='TextBoxContainer-mandatory']>input[name='name']")
    WebElement nameInputBox;
    @FindBy(css = "div[class$='TextBoxContainer-mandatory']>input[name='email']")
    WebElement emailInputBox;
    @FindBy(css = "div[class$='MessageArea-mandatory']>textarea[name='message']")
    WebElement messageInputBox;
    @FindBy(css = ".CheckBox")
    WebElement checkBox;
    @FindBy(css = "#sendiconDiv")
    WebElement submit;
    @FindBy(css = ".SuccessMessage")
    WebElement sucessMessage;

    @FindBy(xpath="//div[@class='thumbCellSplit']/iframe")
    WebElement mainFrame;

    public void formFilling(String name, String emalil, String message) throws InterruptedException {

        //driver.switchTo().frame(0);
        driver.switchTo().frame(mainFrame);
        seleniumWaits.waitForElement(nameInputBox);
        seleniumActions.enterValue(nameInputBox, name);
        seleniumActions.enterValue(emailInputBox, emalil);
        seleniumActions.enterValue(messageInputBox, message);
        seleniumActions.clickOnElement(checkBox);
        seleniumActions.clickOnElement(submit);

    }

    public String gettingMessage() {
        seleniumWaits.waitForElement(sucessMessage);
        String expectedMessage = sucessMessage.getText();
        return expectedMessage;

    }

}
