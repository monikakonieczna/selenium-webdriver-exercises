package com.amberteam.the_internet_herokuapp;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasicAuthPage {

    private WebDriver driver = null;
    String url = "http://admin:admin@the-internet.herokuapp.com/basic_auth";
    private final WebDriverWait wait;
    private static final Duration DRIVER_TIMEOUT = Duration.ofSeconds(5);
    private static final Duration POLLING = Duration.ofSeconds(1);

    By greeting = By.cssSelector("h3 + p");

    public BasicAuthPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, DRIVER_TIMEOUT, POLLING);
    }

    public void navigateTo() {
        driver.get(url);
    }

    public void signIn(String username, String password) {
        Alert authAlert = driver.switchTo()
                                .alert();
        String alertText = authAlert.getText();
        System.out.println("Alert text: " + alertText);
        authAlert.sendKeys(username);
        authAlert.sendKeys(password);
        authAlert.accept();
    }

    public String getGreetingsText() {
        WebElement e = wait.until(ExpectedConditions.presenceOfElementLocated(greeting));
        return e.getText();
    }
}
