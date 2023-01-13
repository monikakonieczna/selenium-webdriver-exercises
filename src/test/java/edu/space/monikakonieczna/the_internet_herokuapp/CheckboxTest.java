package edu.space.monikakonieczna.the_internet_herokuapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CheckboxTest extends BaseTest {

    @Test
    public void select1Checkbox() {
        //given
        checkboxPage = new CheckboxPage(driver);

        //when
        checkboxPage.selectCheckbox1();

        //then
        assertTrue(checkboxPage.isSelected(1));

    }
}
