package com.motivitylabs.Waits;

import com.motivitylabs.Constants.WaitTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumWaits {
    WebDriverWait webDriverWait;
    WebDriver driver;
    WaitTime wiatTime;

    public SeleniumWaits(WebDriver driver) {
        this.driver = driver;
        wiatTime = new WaitTime();

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(wiatTime.EXPLICITWAIT));

    }

    public WebElement waitForElement(WebElement element) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(element));

    }
}
