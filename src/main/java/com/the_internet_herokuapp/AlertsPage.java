package com.the_internet_herokuapp;

import com.the_internet_herokuapp.utils.AlertType;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

import static com.the_internet_herokuapp.utils.AlertType.*;

public class AlertsPage {
    private WebDriver driver = null;
    String url = "http://the-internet.herokuapp.com/javascript_alerts";
    private final WebDriverWait wait;
    private static final Duration DRIVER_TIMEOUT = Duration.ofSeconds(5);
    private static final Duration POLLING = Duration.ofSeconds(1);

    /*************************** Locators ***********************************/

    By jsAlertButton = By.cssSelector("button[onclick='jsAlert()']");
    By jsConfirmButton = By.cssSelector("button[onclick='jsConfirm()']");
    By jsPromptButton = By.cssSelector("button[onclick='jsPrompt()']");
    By result = By.cssSelector("#result");


    /*************************** Constructor ***********************************/

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, DRIVER_TIMEOUT, POLLING);
    }

    /*************************** Methods ***********************************/

    public void navigateTo() {
        driver.get(url);
    }

    public void clickAlertButton(AlertType alertType) {
        Map<AlertType, By> map = Map.of(ALERT, jsAlertButton, CONFIRM, jsConfirmButton, PROMPT, jsPromptButton);
        WebElement e = driver.findElement(map.get(alertType));
        e.click();
    }

    public String getResultText() {
        return driver.findElement(result)
                     .getText();
    }

    public String acceptAlert() {
        Alert alert = driver.switchTo()
                            .alert();
        String text = alert.getText();
        alert.accept();
        return text;
    }

    public String cancelAlert() {
        Alert alert = driver.switchTo()
                            .alert();
        String text = alert.getText();
        alert.dismiss();
        return text;
    }

    public void sendTextToAlert(String text) {
        Alert alert = driver.switchTo()
                            .alert();
        alert.sendKeys(text);
    }
}
