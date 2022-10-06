package exercises_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Pattern;

public class Exercise2Page {

    private WebDriver driver = null;
    String url = "https://antycaptcha.amberteam.pl/exercises/exercise2?seed=cbe17f1d-e5f6-494c-8f02-0201f0470e32";
    private final WebDriverWait wait;
    private static final Duration DRIVER_TIMEOUT = Duration.ofSeconds(5);
    private static final Duration POLLING = Duration.ofSeconds(1);

    By editbox =By.id("t14");
    By buttonB1 =By.name("btnButton1");
    By trailSet = By.className("wrap");
    Pattern pattern = Pattern.compile("t14:.*");

    public Exercise2Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, DRIVER_TIMEOUT, POLLING);
    }

    public void clickButton2(){
        driver.findElement(buttonB1).sendKeys(Keys.RETURN);
    }

    public void enterTextIntoEditbox(String text){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(editbox));
        element.clear();
        element.sendKeys(text);
    }

    public String getTextFromTrail(){
        boolean yes = wait.until(ExpectedConditions.textMatches(trailSet, pattern));
        return driver.findElement(trailSet).getText();
    }

    public void navigateTo(){
        driver.get(url);
    }
}
