package edu.space.monikakonieczna.github;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(2));
    By header = By.cssSelector("div h1");
    By usernameInput = By.cssSelector("#login_field");
    By passwordInput = By.cssSelector("#password");
    By signInButton = By.cssSelector("input[data-signin-label='Sign in']");
    By alert = By.cssSelector("div[role='alert']");

    public void enterCredentials(String username, String password) {
        WebElement usernameElement = driver.findElement(usernameInput);
        usernameElement.clear();
        usernameElement.sendKeys(username);
        WebElement passwordElement = driver.findElement(passwordInput);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void submitCredentials() {
        driver.findElement(signInButton)
              .click();
    }

    public String getHeaderText() {
        wait2.until(ExpectedConditions.visibilityOfElementLocated(signInButton));
        return driver.findElement(header)
                     .getText();
    }

    public String getErrorMessage() {
        wait2.until(ExpectedConditions.visibilityOfElementLocated(alert));
        WebElement alertElement = driver.findElement(alert);
        return alertElement.getText();
    }
}
