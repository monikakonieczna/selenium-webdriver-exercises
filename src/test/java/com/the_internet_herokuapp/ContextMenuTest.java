package com.the_internet_herokuapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContextMenuTest extends BaseTest {


    @Test
    public void contextMenuTest() {
        //given
        contextMenuPage = new ContextMenuPage(driver);
        String expectedText = "You selected a context menu";

        //when
        contextMenuPage.navigateTo();
        contextMenuPage.performRightClickOnContextMenu();

        //then
        String actualText = contextMenuPage.getTextFromAlert();
        contextMenuPage.handleAlert();
        assertEquals(expectedText, actualText);
    }
}
