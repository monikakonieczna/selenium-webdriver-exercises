package exercises_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Pattern;

public class Exercise4Page {

    private WebDriver driver = null;
    String url = "https://antycaptcha.amberteam.pl/exercises/exercise4?seed=c29e1428-0e60-4335-95cb-7d683351a14e";
    private final WebDriverWait wait;
    private static final Duration DRIVER_TIMEOUT = Duration.ofSeconds(5);
    private static final Duration POLLING = Duration.ofSeconds(1);


    private By group0 = By.cssSelector("input[name='s0']");
    private By group1 = By.cssSelector("input[name='s1']");
    private By group2 = By.cssSelector("input[name='s2']");
    private By group3 = By.cssSelector("input[name='s3']");
    private By radio70 = By.cssSelector("input[value='v70']");
    private By radio71 = By.cssSelector("input[value='v71']");
    private By radio02 = By.cssSelector("input[value='v02']");
    private By radio03 = By.cssSelector("input[value='v02']");
    private By trailSet = By.className("wrap");
    private Pattern pattern = Pattern.compile(".*[1-9].*");

    public Exercise4Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, DRIVER_TIMEOUT, POLLING);
    }


    public void chooseFromRadioButtons(int position) {
        switch (position) {
            case 70 -> driver
                    .findElement(radio70).click();
            case 71 -> driver
                    .findElement(radio71)
                    .click();
            case 20 -> driver
                    .findElement(radio02)
                    .click();
            case 30 -> driver
                    .findElement(radio03)
                    .click();
        }
        ;
    }

    public String getTextFromTrail() {
        wait.until(ExpectedConditions.textMatches(trailSet, pattern));
        return driver
                .findElement(trailSet)
                .getText();
    }

    public void navigateTo() {
        driver.get(url);
    }
}
