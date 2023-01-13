package edu.space.monikakonieczna.the_internet_herokuapp;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class NotificationMessageTest extends BaseTest {


    @Test
    public void verifyNotificationMessageTest() {
        //given
        notificationMessagePage = new NotificationMessagePage(driver);
        String expectedMessage = "Action unsuccessful, please try again.";
        String expectedMessage2 = "Action successful";
        //when

        notificationMessagePage.navigateTo();
        notificationMessagePage.clickHere();
        //then
        String actualMessage = notificationMessagePage.getNotificationMessage();
        assertThat(actualMessage, Matchers.either(Matchers.containsString(expectedMessage))
                                          .or(Matchers.containsString(expectedMessage2)));
    }
}
