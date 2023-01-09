package com.the_internet_herokuapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DragAndDropTest extends BaseTest {

    //todo - Not working properly
    @Test
    public void dragAndDropTest(){
        //given
        String expectedText = "B";
        dragAndDropPage = new DragAndDropPage(driver);
        //when
        dragAndDropPage.navigateTo();
        dragAndDropPage.dragAndDrop();
        //then
        String actualText = dragAndDropPage.getHeaderText("a");
        assertEquals(expectedText, actualText);
    }
}
