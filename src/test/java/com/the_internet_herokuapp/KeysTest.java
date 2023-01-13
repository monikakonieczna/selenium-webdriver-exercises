package com.the_internet_herokuapp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class KeysTest extends BaseTest {

    public KeysPage keysPage;

    @Test
    public void enterInsert(){
        //given
        keysPage = new KeysPage(driver);
        String expectedText = "You entered: INSERT";

        //when
        keysPage.navigateTo();
        keysPage.pressKey(Keys.INSERT);

        //then
        String text = keysPage.getText();
        assertThat(text, equalTo(expectedText));
    }
}
