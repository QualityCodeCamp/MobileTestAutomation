package iOS.Tests;

import Base.iOSBase;

import Base.iOSBase_Realdevice;
import Helper.iOSHelper;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class iosRealdevice extends iOSBase_Realdevice {

    private IOSDriver driver;

    String bundleId="com.example.apple-samplecode.UICatalog.bharat";
    String appName="/Users/bharatmalik/Documents/GitHub/TestProject/UIKitCatalog.app";

    @BeforeClass
    public  void BeforeClass(){
        System.out.println("In Beforeclass of the child class");
        driver=getDriver();
        setBundleid(bundleId);
        //setAppName(appName);
        System.out.println("Driver is "+driver.toString());
    }

    @BeforeMethod
    public void beforemethod(){
        System.out.println("in beforemthod , runs before every test");
        getDriver().activateApp(bundleId);
    }


    @Test
    public void LongPress_iOS() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Text Entry\"`]")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("hello world");
        driver.findElement(AppiumBy.accessibilityId("OK")).click();
        Thread.sleep(3000);
    }
    //com.apple.mobileslideshow
    @AfterMethod
    public void AfterMethod(){
        System.out.println("In AfterMethod, runs after every test.");
        getDriver().terminateApp(bundleId);
    }
//

}
