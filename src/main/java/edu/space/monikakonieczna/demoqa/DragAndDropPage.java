package edu.space.monikakonieczna.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DragAndDropPage {

    private WebDriver driver = null;
    String url = "https://demoqa.com/droppable/";
    private final WebDriverWait wait;
    private static final Duration DRIVER_TIMEOUT = Duration.ofSeconds(5);
    private static final Duration POLLING = Duration.ofSeconds(1);

    By draggable = By.id("draggable");
    By droppable = By.id("droppable");

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, DRIVER_TIMEOUT, POLLING);
    }

    public void navigateTo() {
        driver.get(url);
    }

    public void dragAndDrop() {
        WebElement from = driver.findElement(draggable);
        WebElement to = driver.findElement(droppable);
        Actions a = new Actions(driver);
        a.dragAndDrop(from, to)
         .build()
         .perform();
    }

    public String getText() {
        return driver.findElement(droppable)
                     .getText();
    }


}
