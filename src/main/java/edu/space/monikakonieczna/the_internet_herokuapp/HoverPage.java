package edu.space.monikakonieczna.the_internet_herokuapp;

import edu.space.monikakonieczna.the_internet_herokuapp.utils.UserType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

import static edu.space.monikakonieczna.the_internet_herokuapp.utils.UserType.*;

public class HoverPage {

    private WebDriver driver = null;
    String url = "http://the-internet.herokuapp.com/hovers";
    private final WebDriverWait wait;
    private static final Duration DRIVER_TIMEOUT = Duration.ofSeconds(5);
    private static final Duration POLLING = Duration.ofSeconds(1);

    /*************************** Locators ***********************************/

    By user1 = By.cssSelector(".figure:first-of-type img[alt='User Avatar']");
    By user2 = By.cssSelector(".figure:nth-of-type(2) img[alt='User Avatar']");
    By user3 = By.cssSelector(".figure:nth-of-type(3) img[alt='User Avatar']");
    By h5User1 = By.cssSelector(".figure:first-of-type h5");
    By h5User2 = By.cssSelector(".figure:nth-of-type(2) h5");
    By h5User3 = By.cssSelector(".figure:nth-of-type(3) h5");

    /*************************** Constructor ***********************************/

    public HoverPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, DRIVER_TIMEOUT, POLLING);
    }

    /*************************** Methods ***********************************/

    public void navigateTo() {
        driver.get(url);
    }

    public void hoverUser(UserType userType) {
        Map<UserType, By> map = Map.of(USER1, user1, USER2, user2, USER3, user3);
        Actions action = new Actions(driver);
        WebElement e = driver.findElement(map.get(userType));
        action.moveToElement(e)
              .perform();
    }

    public String getH5Text(int userIndex) {
        Map<Integer, By> map = Map.of(1, h5User1, 2, h5User2, 3, h5User3);
        return driver.findElement(map.get(userIndex))
                     .getText();
    }


}
