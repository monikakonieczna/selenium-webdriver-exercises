package com.the_internet_herokuapp;

import com.amberteam.the_internet_herokuapp.ButtonPage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ButtonTest extends BaseTest {

    @Test
    public void add1Element_1ButtonAppears_Test() {
        //given
        String expectedText = "Delete";
        buttonPage = new ButtonPage(driver);
        //when
        buttonPage.navigateTo();
        buttonPage.clickAddButton();
        //then
        String actualText = buttonPage.getTextFromDeleteButton();
        assertEquals(expectedText, actualText);
    }

    @Test
    public void addDeleteElement_Test() {

        //given
        String expectedText = "Delete";
        buttonPage = new ButtonPage(driver);
        //when
        buttonPage.navigateTo();
        buttonPage.clickAddButton();
        //then
        String actualText = buttonPage.getTextFromDeleteButton();
        assertEquals(expectedText, actualText);
        //delete button
        buttonPage.clickDeleteButton();
        assertFalse(buttonPage.deleteButtonIsPresent());


    }

}
