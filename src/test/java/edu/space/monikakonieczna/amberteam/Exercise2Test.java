package edu.space.monikakonieczna.amberteam;

import edu.space.monikakonieczna.amberteam.Exercise2Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise2Test {

    WebDriver driver;
    Exercise2Page e2Page;
    String text = "Team man.";


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
        String expectedText = "t14:Team man.b1";
        e2Page = new Exercise2Page(driver);
        //when
        e2Page.navigateTo();
        e2Page.enterTextIntoEditbox(text);
        e2Page.clickButton2();
        //then
        assertEquals(expectedText, e2Page.getTextFromTrail());
    }

    @AfterEach
    public void clean() {
        if (null != driver) {
            driver.quit();
        }
    }
}
