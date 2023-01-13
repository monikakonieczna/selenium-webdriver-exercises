package edu.space.monikakonieczna.the_internet_herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class WindowPage {

    private WebDriver driver = null;
    String url = "http://the-internet.herokuapp.com/windows";
    private final WebDriverWait wait;
    private static final Duration DRIVER_TIMEOUT = Duration.ofSeconds(5);
    private static final Duration POLLING = Duration.ofSeconds(1);

    /*************************** Locators ***********************************/

    By clickHere = By.cssSelector("a[href='/windows/new']");
    By h3 = By.cssSelector("h3");

    /*************************** Constructor ***********************************/

    public WindowPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, DRIVER_TIMEOUT, POLLING);
    }

    /*************************** Methods ***********************************/

    public void navigateTo() {
        driver.get(url);
    }

    public void openNewWindow() {
        //Store the ID of the original window
        String originalWindow = driver.getWindowHandle();

        //Check we don't have other windows open already
        assert driver.getWindowHandles()
                     .size() == 1;

        //Click the link which opens in a new window
        driver.findElement(clickHere)
              .click();

        //Wait for the new window or tab
        wait.until(numberOfWindowsToBe(2));

        //Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo()
                      .window(windowHandle);
                break;
            }
        }

        //Wait for the new tab to finish loading content
        wait.until(visibilityOf(driver.findElement(h3)));
    }

    public String getText() {
        return driver.findElement(h3)
                     .getText();
    }
}
