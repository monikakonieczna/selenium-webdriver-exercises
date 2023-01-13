package edu.space.monikakonieczna.amberteam;

import edu.space.monikakonieczna.amberteam.Exercise3Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise3Test {

    WebDriver driver;
    Exercise3Page e3Page;


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
        String text = "Pink Kong";
        String expectedText = "s13:v5";
        e3Page = new Exercise3Page(driver);
        //when
        e3Page.navigateTo();
        e3Page.chooseFromDropdown(text);
        //then
        assertEquals(expectedText, e3Page.getTextFromTrail());
    }

    @AfterEach
    public void clean() {
        if (null != driver) {
            driver.quit();
        }
    }
}
