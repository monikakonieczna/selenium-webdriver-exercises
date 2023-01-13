package edu.space.monikakonieczna.demoqa;

import edu.space.monikakonieczna.the_internet_herokuapp.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DragAndDropTest extends BaseTest {

    @Test
    public void dragAndDropTest() throws InterruptedException {
        //given
        String expectedText = "Dropped!";
        dragAndDropPage = new DragAndDropPage(driver);
        //when
        dragAndDropPage.navigateTo();
        dragAndDropPage.dragAndDrop();
        //then
        String actualText = dragAndDropPage.getText();
        assertEquals(expectedText, actualText);
    }
}
