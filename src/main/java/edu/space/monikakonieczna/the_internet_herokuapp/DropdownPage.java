package edu.space.monikakonieczna.the_internet_herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropdownPage {

    private WebDriver driver = null;
    By dropdown = By.id("dropdown");
    By selectedOption = By.cssSelector("option[selected='selected']");
    String url = "http://the-internet.herokuapp.com/dropdown";
    private final WebDriverWait wait;
    private static final Duration DRIVER_TIMEOUT = Duration.ofSeconds(5);
    private static final Duration POLLING = Duration.ofSeconds(1);

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, DRIVER_TIMEOUT, POLLING);
    }

    public void navigateTo() {
        driver.get(url);
    }

    public void selectByText(String text) {
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByVisibleText(text);
    }

    public void selectByIndex(int index) {
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByIndex(index);
    }

    public String checkSelected() {
        return driver.findElement(selectedOption)
                     .getText();
    }
}
