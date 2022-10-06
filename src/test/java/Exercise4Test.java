import exercises_pages.Exercise3Page;
import exercises_pages.Exercise4Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise4Test {

    WebDriver driver;
    Exercise4Page e4Page;


    @BeforeEach
    public void setup() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void enterTextIntoEditboxAndClickB1Test() {
        //given
        String v80 = "Anti - Establishment Mint";
        String v00 = "Beluga Brown";
        String expectedText = "[7, 7, 0, 0]";
        e4Page = new Exercise4Page(driver);
        //when
        e4Page.navigateTo();
        e4Page.chooseFromRadioButtons(70);
        e4Page.chooseFromRadioButtons(71);
        e4Page.chooseFromRadioButtons(20);
        e4Page.chooseFromRadioButtons(30);
        //then
        assertEquals(expectedText, e4Page.getTextFromTrail());
    }

    @AfterEach
    public void clean() {
        if (null != driver) {
            driver.quit();
        }
    }
}
