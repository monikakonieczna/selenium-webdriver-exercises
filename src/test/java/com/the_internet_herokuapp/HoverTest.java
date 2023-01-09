package com.the_internet_herokuapp;


import com.amberteam.the_internet_herokuapp.HoverPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HoverTest extends BaseTest {

    @Test
    public void hoverUser1() {
        //given
        hoverPage = new HoverPage(driver);
        hoverPage.navigateTo();
        String expectedText = "name: user1";

        //when
        hoverPage.hoverUser(1);

        //then
        assertEquals(expectedText, hoverPage.getH5Text(1));
        System.out.println(hoverPage.getH5Text(1));
    }

}
