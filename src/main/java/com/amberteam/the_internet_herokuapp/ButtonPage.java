package com.amberteam.the_internet_herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ButtonPage {
    private WebDriver driver = null;
    String url = "http://the-internet.herokuapp.com/add_remove_elements/";
    private final WebDriverWait wait;
    private static final Duration DRIVER_TIMEOUT = Duration.ofSeconds(5);
    private static final Duration POLLING = Duration.ofSeconds(1);

    By addButton = By.cssSelector("button[onclick='addElement()']");
    By deleteButton = By.cssSelector("button[onclick='deleteElement()'");

    public ButtonPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, DRIVER_TIMEOUT, POLLING);
    }

    public void clickAddButton() {
        driver.findElement(addButton)
              .sendKeys(Keys.RETURN);
    }

    public void clickDeleteButton() {
        driver.findElement(deleteButton)
              .sendKeys(Keys.RETURN);
    }

    public boolean deleteButtonIsPresent() {
        int size = driver.findElements(deleteButton)
                         .size();
        return (size >= 1);
    }

    public String getTextFromDeleteButton() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(deleteButton));
        return element.getText();
    }

    public void navigateTo() {
        driver.get(url);
    }


}
