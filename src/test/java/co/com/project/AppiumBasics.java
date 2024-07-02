package co.com.project;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;


public class AppiumBasics extends BaseTest{

    @Test
    public void wifiSettingName() throws MalformedURLException, URISyntaxException {


        //Actual Automation
        // Xpath, id, accessiibilityId, classname, androidUiAutomator
        //tagname[@atribute='value'] -- xpath
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle,"WiFi settings");

        driver.findElement(By.id("android:id/edit")).sendKeys("User wifi");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
    }
}
