package Android.Tests;

import Base.AndroidBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BasicAndroidTest1 extends AndroidBase {

    private  AndroidDriver driver;

    String bundleId="io.appium.android.apis";
    String appName="C:\\Users\\16473\\IdeaProjects\\TestProject\\ApiDemos-debug.apk";

    @BeforeClass
    public  void BeforeClass(){
        System.out.println("In Beforeclass of the child class");
        driver=getDriver();
        setBundleid(bundleId);
        setAppName(appName);
        System.out.println("Driver is "+driver.toString());
    }

    @BeforeMethod
    public void beforemethod(){
        System.out.println("in beforemthod , runs before every test");
        getDriver().activateApp(bundleId);
    }

//    @Test
//    public void sendkeys() throws InterruptedException {
//        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//        driver.findElement(AppiumBy.accessibilityId("4. Default values")).click();
//        driver.findElement(By.xpath("//android.widget.TextView[@text=\"Edit text preference\"]")).click();
//        driver.findElement(By.id("android:id/edit")).clear();
////        driver.setClipboardText("tiger");
////        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
//        for (int i = 0; i < 5; i++) {
//            driver.pressKey(new KeyEvent(AndroidKey.O));
//        }
//
//        String text=driver.findElement(By.id("android:id/edit")).getText();
//        Assert.assertEquals(text,"ooooo");
//    }
//
//    @Test
//    public void performsetofactions(){
//       driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//
//        //Format for Xpath: //TagName[@attribute="value"]
//        //android.widget.TextView[@content-desc="6. Advanced preferences"]
//
//        driver.findElement(By.xpath(" //android.widget.TextView[@content-desc=\"6. Advanced preferences\"]")).click();
//        String textverify=driver.findElement(By.id("android:id/summary")).getText();
//        System.out.println("text present is" +textverify);
//        Assert.assertEquals(textverify,"This is a custom counter preference");
//    }

//
//    }
//
    @Test
    public  void scroll() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));")).click();
        String text=driver.findElement(By.xpath("(//android.widget.TextView) [1]")).getText();
        Assert.assertEquals(text,"Views/WebView");

    }

    @AfterMethod
    public void aftermethod(){
        System.out.println("in aftermethod , runs after every test");
        getDriver().terminateApp(bundleId);
    }
    @AfterClass
    public void TearDown(){

        System.out.println("In teardown of the child class");
    }

}