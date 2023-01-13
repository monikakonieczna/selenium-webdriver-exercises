package com.amberteam;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Pattern;

public class Exercise3Page {

    private WebDriver driver = null;
    String url = "https://antycaptcha.amberteam.pl/exercises/exercise3?seed=aa23298a-ba23-4e22-978a-82ee9cec1226";
    private final WebDriverWait wait;
    private static final Duration DRIVER_TIMEOUT = Duration.ofSeconds(5);
    private static final Duration POLLING = Duration.ofSeconds(1);


    By dropdown =By.id("s13");
    By trailSet = By.className("wrap");
    Pattern pattern = Pattern.compile("s13:.*");

    public Exercise3Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, DRIVER_TIMEOUT, POLLING);
    }

    public void chooseFromDropdown(String text){
        WebElement selectElement = driver.findElement(dropdown);
        Select select = new Select(selectElement);
        select.selectByVisibleText(text);
    }

    public String getTextFromTrail(){
        boolean yes = wait.until(ExpectedConditions.textMatches(trailSet, pattern));
        return driver.findElement(trailSet).getText();
    }

    public void navigateTo(){
        driver.get(url);
    }
}
