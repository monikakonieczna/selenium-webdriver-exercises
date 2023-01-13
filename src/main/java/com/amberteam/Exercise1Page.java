package com.amberteam;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Exercise1Page {

    private WebDriver driver = null;
    String url = "https://antycaptcha.amberteam.pl/exercises/exercise1?seed=3f99e07e-f915-4973-b82b-844522730303";
    private final WebDriverWait wait;
    private static final Duration DRIVER_TIMEOUT = Duration.ofSeconds(5);
    private static final Duration POLLING = Duration.ofSeconds(1);

    By buttonB2 =By.name("btnButton2");
    By trailSet = By.className("wrap");

    public Exercise1Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, DRIVER_TIMEOUT, POLLING);
    }

    public void ClickButton2(){
        driver.findElement(buttonB2).sendKeys(Keys.RETURN);
    }

    public String getTextFromTrail(){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(trailSet));
        return element.getText();
    }

    public void navigateTo(){
        driver.get(url);
    }
}
