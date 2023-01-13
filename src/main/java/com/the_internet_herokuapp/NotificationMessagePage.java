package com.the_internet_herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NotificationMessagePage {

    private WebDriver driver = null;
    String url = "http://the-internet.herokuapp.com/notification_message_rendered";
    private final WebDriverWait wait;
    private static final Duration DRIVER_TIMEOUT = Duration.ofSeconds(5);
    private static final Duration POLLING = Duration.ofSeconds(1);

    /*************************** Locators ***********************************/

    By link = By.cssSelector("a[href*='notification_message']");
    By notificationMessage = By.cssSelector("div[id='flash']");


    /*************************** Constructor ***********************************/

    public NotificationMessagePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, DRIVER_TIMEOUT, POLLING);
    }

    /*************************** Methods ***********************************/

    public void navigateTo() {
        driver.get(url);
    }

    public void clickHere() {
        driver.findElement(link)
              .click();
    }

    public String getNotificationMessage() {
        return driver.findElement(notificationMessage)
                     .getText();
    }
}
