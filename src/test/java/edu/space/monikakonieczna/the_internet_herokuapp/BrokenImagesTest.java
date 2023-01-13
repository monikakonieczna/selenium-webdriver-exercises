package edu.space.monikakonieczna.the_internet_herokuapp;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpResponse;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrokenImagesTest extends BaseTest {
    public static String status = "passed";

    @Test
    public void broken_images_test() {
        //given
        brokenImagesPage = new BrokenImagesPage(driver);
        int iBrokenImageCount = 0;

        //when
        brokenImagesPage.navigateTo();

        try {
            List<WebElement> image_list = brokenImagesPage.getImagesList();
            System.out.println("The page has " + image_list.size() + " images");
            for (WebElement img : image_list) {
                if (img != null) {
                    HttpClient client = HttpClientBuilder.create()
                                                         .build();
                    HttpGet request = new HttpGet(img.getAttribute("src"));
                    HttpResponse response = client.execute(request);
                    if (response.getCode() != 200) {
                        System.out.println(img.getAttribute("outerHTML") + " is broken.");
                        iBrokenImageCount++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            status = "failed";
            System.out.println(e.getMessage());
        }
        status = "passed";
        System.out.println("The page has " + iBrokenImageCount + " broken images");
    }
}
