package edu.space.monikakonieczna.the_internet_herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TablePage {
    private WebDriver driver = null;
    String url = "http://the-internet.herokuapp.com/tables";
    private final WebDriverWait wait;
    private static final Duration DRIVER_TIMEOUT = Duration.ofSeconds(5);
    private static final Duration POLLING = Duration.ofSeconds(1);

    /*************************** Locators ***********************************/

    By textInput = By.cssSelector("#target");
    By textResult = By.cssSelector("#result");

    /*************************** Constructor ********************************/

    public TablePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, DRIVER_TIMEOUT, POLLING);
    }

    /*************************** Methods ***********************************/

    public void navigateTo() {
        driver.get(url);
    }
}
