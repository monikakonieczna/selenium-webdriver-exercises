package edu.space.monikakonieczna.the_internet_herokuapp;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContextMenuPage {

    private WebDriver driver = null;
    String url = "http://the-internet.herokuapp.com/context_menu";
    private final WebDriverWait wait;
    private static final Duration DRIVER_TIMEOUT = Duration.ofSeconds(5);
    private static final Duration POLLING = Duration.ofSeconds(1);

    By hotspot = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, DRIVER_TIMEOUT, POLLING);
    }

    public void navigateTo() {
        driver.get(url);
    }

    public void performRightClickOnContextMenu() {
        Actions actions = new Actions(driver);
        WebElement e = driver.findElement(hotspot);
        actions.contextClick(e)
               .perform();
    }

    public void handleAlert() {
        Alert alert = driver.switchTo()
                            .alert();

        String text = alert.getText();
        System.out.println(text);
        alert.accept();
    }

    public String getTextFromAlert() {
        Alert alert = driver.switchTo()
                            .alert();


        return alert.getText();
    }
}

