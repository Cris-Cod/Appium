package co.com.project;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;


public class ScrollDemo extends BaseTest{

    @Test
    public void scrollDemoTest() throws MalformedURLException, URISyntaxException, InterruptedException {


        //Actual Automation
        // Xpath, id, accessiibilityId, classname, androidUiAutomator
        //tagname[@atribute='value'] -- xpath
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

         // where to scroll is known prior
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));

        //scrollToendAction();

        Thread.sleep(2000);

    }


}
