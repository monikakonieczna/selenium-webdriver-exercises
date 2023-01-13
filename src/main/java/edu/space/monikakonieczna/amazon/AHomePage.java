package edu.space.monikakonieczna.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AHomePage extends ABasePage {

    public AHomePage(WebDriver driver) {
        super(driver);
    }

    String url = "https://www.amazon.com/";
    WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(2));

    By searchInput = By.cssSelector("input[name='field-keywords']");
    By searchButton = By.cssSelector("#nav-search-submit-button");

    public void navigateTo() {
        driver.get(url);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void enterSearchText(String text) {
        wait3.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        WebElement e = driver.findElement(searchInput);
        e.clear();
        e.sendKeys(text);
    }

    public void submitSearch() {
        wait3.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
        driver.findElement(searchButton)
              .click();
    }
}
