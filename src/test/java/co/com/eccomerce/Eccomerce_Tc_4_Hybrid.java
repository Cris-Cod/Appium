package co.com.eccomerce;

import co.com.project.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Eccomerce_Tc_4_Hybrid extends BaseTest {

    @Test
    public void Select_2_Product_and_navigate_browser() throws InterruptedException {
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Chin Hum");
        driver.hideKeyboard();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioMale")).click();
        driver.findElement(AppiumBy.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Argentina\"]")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text", "Cart"));
        List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int productCount = productPrices.size();
        double totalSum = 0;

        for (int i = 0; i < productCount; i++) {
            String amountString =productPrices.get(i).getText();
            Double price = Double.parseDouble(amountString.substring(1));
            totalSum += price;
        }

        String totalAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double amount = Double.parseDouble(totalAmount.substring(1));

        Assert.assertEquals(totalSum,amount);

        WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        longPressAction(ele);
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(6000);
        //Hybrid - Google page ->
        Set<String> contexts = driver.getContextHandles();
        for (String contextName: contexts) {
            System.out.println(contextName);
        }
        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.name("q")).sendKeys("Appium");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");


    }


}