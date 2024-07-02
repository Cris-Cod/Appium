package co.com.project;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;


public class LongPressButton extends BaseTest{

    @Test
    public void longPresssButton() throws MalformedURLException, URISyntaxException, InterruptedException {


        //Actual Automation
        // Xpath, id, accessiibilityId, classname, androidUiAutomator
        //tagname[@atribute='value'] -- xpath
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement ele = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
        longPressAction(ele);
        String sampleMenu = driver.findElement(By.id("android:id/title")).getText();
        Assert.assertEquals(sampleMenu,"Sample menu");
        Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
    }


}