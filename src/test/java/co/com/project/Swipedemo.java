package co.com.project;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;


public class Swipedemo extends BaseTest{

    @Test
    public void swipeDemoTest() throws MalformedURLException, URISyntaxException, InterruptedException {


        //Actual Automation
        // Xpath, id, accessiibilityId, classname, androidUiAutomator
        //tagname[@atribute='value'] -- xpath
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        WebElement firstimage = driver.findElement(AppiumBy.xpath("//android.widget.Gallery[@resource-id='io.appium.android.apis:id/gallery']/android.widget.ImageView[1]"));
        Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.Gallery[@resource-id='io.appium.android.apis:id/gallery']/android.widget.ImageView[1]")).getAttribute("focusable"), "true");
        //swipe

        swipeOption(firstimage, "left");

        Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.Gallery[@resource-id='io.appium.android.apis:id/gallery']/android.widget.ImageView[1]")).getAttribute("focusable"), "false");

    }


}
