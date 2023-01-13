package edu.space.monikakonieczna.github;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    String url = "https://github.com/";
    By signInLink = By.cssSelector("a[href='/login']");
    By header = By.cssSelector("h1");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateTo() {
        driver.get(url);
    }

    public void clickSignInLink() {
        WebElement e = driver.findElement(signInLink);
        e.click();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
