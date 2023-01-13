package edu.space.monikakonieczna.amazon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchingTest {

    WebDriver driver;

    String expectedTitle = "Amazon.com. Spend less. Smile more.";

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver()
                        .setup();
        driver = new ChromeDriver();
        driver.manage()
              .window()
              .maximize();
    }

    @AfterEach
    public void clean() {
        if (null != driver) {
            driver.quit();
        }
    }

    @Test
    public void iphoneSearchTest() {
        //navigate to homepage
        AHomePage homePage = new AHomePage(driver);
        homePage.navigateTo();
        String title = homePage.getTitle();
        assertEquals(expectedTitle, title);

        //search for iphone
        homePage.enterSearchText("iPhone");
        homePage.submitSearch();


        //verify result page
        ResultsPage resultsPage = new ResultsPage(driver);

        List<WebElement> resultsList = resultsPage.getResults();
        WebElement firstResult = resultsList.get(1);
        String header = firstResult.findElement(By.cssSelector("h2"))
                                   .getText();
        String expectedHeader = "iPhone13";
        assertThat(header, containsString(expectedHeader));
    }
}
