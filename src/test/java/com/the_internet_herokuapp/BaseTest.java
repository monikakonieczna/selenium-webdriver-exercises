package com.the_internet_herokuapp;

import com.amberteam.the_internet_herokuapp.*;
import com.demoqa.DragAndDropPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class BaseTest {

    public WebDriver driver;
    public ButtonPage buttonPage;
    public CheckboxPage checkboxPage;
    public BasicAuthPage basicAuthPage;
    public BrokenImagesPage brokenImagesPage;
    public ContextMenuPage contextMenuPage;
    public DragAndDropPage dragAndDropPage;
    public DropdownPage dropdownPage;
    public HoverPage hoverPage;
    public NotificationMessagePage notificationMessagePage;
    public AlertsPage alertsPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver()
                        .setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(chromeOptions);
        driver.manage()
              .deleteAllCookies();
        driver.manage()
              .window()
              .maximize();
    }

    @AfterEach
    public void clean() {
        if (null != driver) {
            driver.quit();
        }
    }
}
