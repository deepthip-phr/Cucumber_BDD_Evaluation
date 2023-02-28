package com.motivitylabs.Automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BasePage {

    public static WebDriver driver;

    public static void launchBrowser() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://compendiumdev.co.uk/");
        driver.manage().window().maximize();
    }

    public static void killSession() {
        driver.quit();
    }
}
