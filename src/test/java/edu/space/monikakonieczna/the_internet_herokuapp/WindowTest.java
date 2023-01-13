package edu.space.monikakonieczna.the_internet_herokuapp;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class WindowTest extends BaseTest {

    public WindowPage windowPage;

    @Test
    public void newWindowTest() {
        //given
        windowPage = new WindowPage(driver);
        String expectedText = "New Window";

        //when
        windowPage.navigateTo();
        windowPage.openNewWindow();

        //then
        String text = windowPage.getText();
        assertThat(text, equalTo(expectedText));
    }
}
