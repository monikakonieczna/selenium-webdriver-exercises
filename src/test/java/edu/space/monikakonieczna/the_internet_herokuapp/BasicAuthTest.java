package edu.space.monikakonieczna.the_internet_herokuapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BasicAuthTest extends BaseTest {

    @Test
    public void basicAuthTest() {
        //given
        basicAuthPage = new BasicAuthPage(driver);
        String expectedGreeting = "Congratulations! You must have the proper credentials.";
        String username = "admin";
        String password = "admin";

        //when
        basicAuthPage.navigateTo();
        //basicAuthPage.signIn("admin", "admin");
        String actualGreeting = basicAuthPage.getGreetingsText();
        assertEquals(expectedGreeting, actualGreeting);
    }

}
