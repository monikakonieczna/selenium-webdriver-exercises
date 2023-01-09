package com.amberteam.the_internet_herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BrokenImagesPage {

    private WebDriver driver = null;
    String url = "http://the-internet.herokuapp.com/broken_images";
    private final WebDriverWait wait;
    private static final Duration DRIVER_TIMEOUT = Duration.ofSeconds(5);
    private static final Duration POLLING = Duration.ofSeconds(1);

    By greeting = By.cssSelector("h3 + p");


    public BrokenImagesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, DRIVER_TIMEOUT, POLLING);
    }

    public void navigateTo() {
        driver.get(url);
    }

    public List<WebElement> getImagesList() {
        return driver.findElements(By.tagName("img"));
    }
}
