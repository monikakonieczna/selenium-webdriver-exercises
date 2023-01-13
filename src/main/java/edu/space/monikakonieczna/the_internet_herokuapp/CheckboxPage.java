package edu.space.monikakonieczna.the_internet_herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckboxPage {

    private WebDriver driver = null;
    String url = "http://the-internet.herokuapp.com/checkboxes";
    private final WebDriverWait wait;
    private static final Duration DRIVER_TIMEOUT = Duration.ofSeconds(5);
    private static final Duration POLLING = Duration.ofSeconds(1);

    By checkbox1 = By.cssSelector("input[type='checkbox']:nth-child(1)");
    By checkbox2 = By.cssSelector("input[type='checkbox']:nth-child(2)");

    public CheckboxPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, DRIVER_TIMEOUT, POLLING);
    }

    public void selectCheckbox1() {
        boolean isSelected = driver.findElement(checkbox1)
                                   .isSelected();

        if (isSelected) {
            System.out.println("Checkbox 1 was already selected.");
        }
        else {
            driver.findElement(checkbox1)
                  .click();
        }
    }

    public void unselectCheckbox1() {
        boolean isSelected = driver.findElement(checkbox1)
                                   .isSelected();

        if (!isSelected) {
            System.out.println("Checkbox 1 was already unselected.");
        }
        else {
            driver.findElement(checkbox1)
                  .click();
        }
    }

    public void selectCheckbox2() {
        boolean isSelected = driver.findElement(checkbox2)
                                   .isSelected();

        if (isSelected) {
            System.out.println("Checkbox 2 was already selected.");
        }
        else {
            driver.findElement(checkbox2)
                  .click();
        }
    }

    public void unselectCheckbox2() {
        boolean isSelected = driver.findElement(checkbox2)
                                   .isSelected();

        if (!isSelected) {
            System.out.println("Checkbox 2 was already unselected.");
        }
        else {
            driver.findElement(checkbox2)
                  .click();
        }
    }

    public boolean isSelected(int index) {
        return switch (index) {
            case 1 -> driver.findElement(checkbox1)
                            .isSelected();
            case 2 -> driver.findElement(checkbox2)
                            .isSelected();
            default -> throw new IllegalArgumentException("Not correct index number");
        };
    }


    public void navigateTo() {
        driver.get(url);
    }
}
