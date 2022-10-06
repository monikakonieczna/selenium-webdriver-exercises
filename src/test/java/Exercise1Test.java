import dev.failsafe.internal.util.Assert;
import exercises_pages.Exercise1Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise1Test {

    WebDriver driver;
    Exercise1Page e1Page;


    @BeforeEach
    public void setup() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void tripleClickButtonTest() {
        //given
        String expectedText = "b2b2b2";
        e1Page = new Exercise1Page(driver);
        //when
        e1Page.navigateTo();
        e1Page.ClickButton2();
        e1Page.ClickButton2();
        e1Page.ClickButton2();
        //then
        assertEquals(expectedText, e1Page.getTextFromTrail());
    }

    @AfterEach
    public void clean() {
        if (null != driver) {
            driver.quit();
        }
    }

}
