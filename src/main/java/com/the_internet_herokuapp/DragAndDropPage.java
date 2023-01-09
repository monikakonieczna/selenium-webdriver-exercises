package com.the_internet_herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DragAndDropPage {

    private WebDriver driver = null;
    String url = "http://the-internet.herokuapp.com/drag_and_drop";
    private final WebDriverWait wait;
    private static final Duration DRIVER_TIMEOUT = Duration.ofSeconds(5);
    private static final Duration POLLING = Duration.ofSeconds(1);

    By columnA = By.id("column-a");
    By headerColumnA = By.cssSelector("div[id='column-a'] header");
    By columnB = By.id("column-b");
    By headerColumnB = By.cssSelector("div[id='column-b'] header");

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, DRIVER_TIMEOUT, POLLING);
    }

    public void navigateTo() {
        driver.get(url);
    }

    public void dragAndDrop() {
        WebElement sourceLocator = driver.findElement(columnA);
        WebElement destinationLocator = driver.findElement(columnB);
        Actions a = new Actions(driver);
        a.dragAndDrop(sourceLocator, destinationLocator)
         .build()
         .perform();
    }

    public String getHeaderText(String column) {
        switch (column) {
            case "a" -> {
                return driver.findElement(headerColumnA)
                             .getText();
            }
            case "b" -> {
                return driver.findElement(headerColumnB)
                             .getText();
            }
            default -> throw new IllegalArgumentException("Not correct column sign");
        }
    }

}
