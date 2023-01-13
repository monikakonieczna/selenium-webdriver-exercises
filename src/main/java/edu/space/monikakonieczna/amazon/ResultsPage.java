package edu.space.monikakonieczna.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultsPage extends ABasePage {
    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

    By results = By.cssSelector("div[data-component-type='s-search-result']");

    public List<WebElement> getResults() {
        return driver.findElements(results);
    }
}
