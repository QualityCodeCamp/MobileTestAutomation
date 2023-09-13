package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Installapplicationonemulator {

    public  static IOSDriver driver;
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
//        System.out.println("Testcode");
//        UiAutomator2Options dc=new UiAutomator2Options();
//        dc.setDeviceName("Pixel XL API 33");
//        dc.setApp("C:\\Users\\16473\\IdeaProjects\\TestProject\\ApiDemos-debug.apk");
//
//        driver=new AndroidDriver(new URL("http://0.0.0.0:4723"),dc);
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Testcode");
        XCUITestOptions dc=new XCUITestOptions();
        dc.setDeviceName("iPhone 14 Pro");
        //dc.setApp("/Users/bharatmalik/Documents/Appiumudemy/Section 11 iOS First Test Case/UICatalog.app");
        dc.setWdaLaunchTimeout(Duration.ofSeconds(20));
        driver=new IOSDriver(new URL("http://0.0.0.0:4723"),dc);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //to Setup for face id
       //driver.executeScript("mobile:enrollBiometric", ImmutableMap.of("isEnabled", true));
//            driver.toggleTouchIDEnrollment(true);

        //Face id
            driver.executeScript("mobile:sendBiometricMatch", ImmutableMap.of("type", "faceId", "match", false));


      //  sendkeys();
        driver.quit();
      //  scroll();

    }


    public static void performsetofactions(){
        WebElement element=driver.findElement(AppiumBy.accessibilityId("Preference"));
        element.click();


        //Format for Xpath: //TagName[@attribute="value"]
        //android.widget.TextView[@content-desc="6. Advanced preferences"]

        driver.findElement(By.xpath(" //android.widget.TextView[@content-desc=\"6. Advanced preferences\"]")).click();
        String textverify=driver.findElement(By.id("android:id/summary")).getText();
        System.out.println("text present is" +textverify);

        driver.quit();
    }

    public static void sendkeys() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("4. Default values")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"Edit text preference\"]")).click();
        driver.findElement(By.id("android:id/edit")).clear();
//        driver.setClipboardText("tiger");
//        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        for(int i=0;i<5;i++){
          // driver.pressKey(new KeyEvent(AndroidKey.O));
        }

        Thread.sleep(4000);
        driver.findElement(By.id("android:id/button1")).click();

    }

    public static void scroll() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));")).click();

        Thread.sleep(4000);

    }
}