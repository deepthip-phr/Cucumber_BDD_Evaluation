package com.motivitylabs.Pages;

import com.motivitylabs.Actions.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    SeleniumActions seleniumActions;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        seleniumActions = new SeleniumActions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@class='rootdropdownmenuitem']/a[text()='Contact']")
    WebElement contactOption;

    public void clickOnContact() throws InterruptedException {
        seleniumActions.waitAndClickOnElement(contactOption);

    }
}
