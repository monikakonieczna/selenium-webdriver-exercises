package com.the_internet_herokuapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DropdownTest extends BaseTest {

    @Test
    public void selectOption1(){
        //given
        dropdownPage = new DropdownPage(driver);
        dropdownPage.navigateTo();

        //when
        String expectedText = "Please select an option";
        String actualText = dropdownPage.checkSelected();
        assertEquals(expectedText,actualText);

        //then
        dropdownPage.selectByIndex(1);
        String expectedText2 = "Option 1";
        String actualText2 = dropdownPage.checkSelected();
        assertEquals(expectedText2,actualText2);

    }
}
