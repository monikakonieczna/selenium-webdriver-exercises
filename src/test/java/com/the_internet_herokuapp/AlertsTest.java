package com.the_internet_herokuapp;

import com.the_internet_herokuapp.utils.AlertType;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;


public class AlertsTest extends BaseTest {

    @Test
    public void alertTest() {
        //given
        alertsPage = new AlertsPage(driver);
        String expectedResult = "You successfully clicked an alert";
        String expectedMessage = "I am a JS Alert";

        //when
        alertsPage.navigateTo();
        alertsPage.clickAlertButton(AlertType.ALERT);
        String alertMessage = alertsPage.acceptAlert();

        //then
        String result = alertsPage.getResultText();
        assertAll(
                () -> assertThat(expectedResult, equalTo(result)),
                () -> assertThat(expectedMessage, equalTo(alertMessage))
        );
    }

    @Test
    public void acceptConfirmTest() {
        //given
        alertsPage = new AlertsPage(driver);
        String expectedResult = "You clicked: Ok";
        String expectedMessage = "I am a JS Confirm";

        //when
        alertsPage.navigateTo();
        alertsPage.clickAlertButton(AlertType.CONFIRM);
        String alertMessage = alertsPage.acceptAlert();

        //then
        String result = alertsPage.getResultText();
        assertAll(
                () -> assertThat(result, equalTo(expectedResult)),
                () -> assertThat(alertMessage, equalTo(expectedMessage))
        );

    }

    @Test
    public void cancelConfirmTest() {
        //given
        alertsPage = new AlertsPage(driver);
        String expectedResult = "You clicked: Cancel";
        String expectedMessage = "I am a JS Confirm";

        //when
        alertsPage.navigateTo();
        alertsPage.clickAlertButton(AlertType.CONFIRM);
        String alertMessage = alertsPage.cancelAlert();

        //then
        String result = alertsPage.getResultText();
        assertAll(
                () -> assertThat(result, equalTo(expectedResult)),
                () -> assertThat(alertMessage, equalTo(expectedMessage))
        );

    }

    @Test
    public void emptyPromptAcceptTest() {
        //given
        alertsPage = new AlertsPage(driver);
        String expectedResult = "You entered:";
        String expectedMessage = "I am a JS prompt";

        //when
        alertsPage.navigateTo();
        alertsPage.clickAlertButton(AlertType.PROMPT);
        String alertMessage = alertsPage.acceptAlert();

        //then
        String result = alertsPage.getResultText();
        assertAll(
                () -> assertThat(result, equalTo(expectedResult)),
                () -> assertThat(alertMessage, equalTo(expectedMessage))
        );
    }

    @Test
    public void emptyPromptCancelTest() {
        //given
        alertsPage = new AlertsPage(driver);
        String expectedResult = "You entered: Hello";
        String expectedMessage = "I am a JS prompt";

        //when
        alertsPage.navigateTo();
        alertsPage.clickAlertButton(AlertType.PROMPT);
        String alertMessage = alertsPage.cancelAlert();

        //then
        String result = alertsPage.getResultText();
        assertAll(
                () -> assertThat(result, equalTo(expectedResult)),
                () -> assertThat(alertMessage, equalTo(expectedMessage))
        );

    }

    @Test
    public void fillPromptAcceptTest() {
        //given
        alertsPage = new AlertsPage(driver);
        String text = "Hello";
        String expectedResult = "You entered: " + text;
        String expectedMessage = "I am a JS prompt";


        //when
        alertsPage.navigateTo();
        alertsPage.clickAlertButton(AlertType.PROMPT);
        alertsPage.sendTextToAlert(text);
        String alertMessage = alertsPage.acceptAlert();

        //then
        String result = alertsPage.getResultText();
        assertAll(
                () -> assertThat(result, equalTo(expectedResult)),
                () -> assertThat(alertMessage, equalTo(expectedMessage))
        );
    }

}
