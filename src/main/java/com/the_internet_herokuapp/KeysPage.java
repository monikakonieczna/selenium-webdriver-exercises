package com.the_internet_herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KeysPage {

    private WebDriver driver = null;
    String url = "http://the-internet.herokuapp.com/key_presses";
    private final WebDriverWait wait;
    private static final Duration DRIVER_TIMEOUT = Duration.ofSeconds(5);
    private static final Duration POLLING = Duration.ofSeconds(1);

    /*************************** Locators ***********************************/

    By textInput = By.cssSelector("#target");
    By textResult = By.cssSelector("#result");

    /*************************** Constructor ***********************************/

    public KeysPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, DRIVER_TIMEOUT, POLLING);
    }

    /*************************** Methods ***********************************/

    public void navigateTo() {
        driver.get(url);
    }

    public void pressKey(Keys key) {

        WebElement textField = driver.findElement(textInput);
        new Actions(driver).sendKeys(textField, key)
                           .perform();
    }

    public String getText() {
        return driver.findElement(textResult)
                     .getText();
    }
}
