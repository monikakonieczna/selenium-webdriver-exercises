package edu.space.monikakonieczna.github;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {

    WebDriver driver;
    Faker faker = new Faker();

    @BeforeEach
    public void set_up() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage()
              .window()
              .maximize();
    }


    @Test
    public void negative_user_login_with_wrong_password_expect_error_message() {
        //navigate to homePage
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();
        String expectedTitle = "GitHub: Let’s build from here · GitHub";
        String title = homePage.getTitle();
        assertEquals(expectedTitle, title);

        //navigate to login page
        homePage.clickSignInLink();
        LoginPage loginPage = new LoginPage(driver);
        String expectedHeaderText = "Sign in to GitHub";
        String actualHeaderMessage = loginPage.getHeaderText();
        assertEquals(expectedHeaderText, actualHeaderMessage);

        //try to log in with incorrect credentials
        String expectedErrorAlert = "Incorrect username or password.";
        String username = faker.funnyName()
                               .name();
        System.out.println(username);
        String password = faker.witcher()
                               .monster();
        System.out.println(password);
        loginPage.enterCredentials(username, password);
        loginPage.submitCredentials();

        //then
        String actualAlertMessage = loginPage.getErrorMessage();
        assertEquals(expectedErrorAlert, actualAlertMessage);
    }

    @AfterEach
    public void clean() {
        if (null != driver) {
            driver.quit();
        }
    }


}
