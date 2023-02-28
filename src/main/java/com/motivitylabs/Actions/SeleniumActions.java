package com.motivitylabs.Actions;
import com.motivitylabs.Waits.SeleniumWaits;
import org.openqa.selenium.*;


public class SeleniumActions {
    WebDriver driver;
    SeleniumWaits seleniumWaits;

    public SeleniumActions(WebDriver driver) {
        this.driver = driver;
        seleniumWaits = new SeleniumWaits(driver);

    }
    /**
     * Wait for element using webdriver wait and click on the element
     * @param element - webelement
     * @return boolean value
     */
    public boolean waitAndClickOnElement(WebElement element) {
        try {
            seleniumWaits.waitForElement(element).click();
            return true;
        } catch (Exception e) {
            return false;

        }

    }

    /**
     * Normal Click of WebElement
     * @param element
     * @return
     */

    public boolean clickOnElement(WebElement element) {
        boolean flag = false;
        try {
            element.click();
            flag = true;
        } catch (NoSuchElementException nse) {
            System.out.println(nse.toString());
            flag = false;
        } catch (StaleElementReferenceException see) {
            System.out.println(see.toString());
            flag = false;
        } catch (ElementNotInteractableException eie) {
            System.out.println(eie.toString());
            flag = false;
        }
        return flag;
    }

    /**
     * Sending the value to the WebElement using Sendkeys
     * @param element
     * @param data
     * @return
     */


    public boolean enterValue(WebElement element, String data) {
        boolean flag = false;
        try {
            element.sendKeys(data);
            flag = true;
        } catch (NoSuchElementException nse) {
            System.out.println(nse.toString());
            flag = false;
        } catch (StaleElementReferenceException see) {
            System.out.println(see.toString());
            flag = false;
        } catch (ElementNotInteractableException eie) {
            System.out.println(eie.toString());
            flag = false;
        }
        return flag;
    }

}
