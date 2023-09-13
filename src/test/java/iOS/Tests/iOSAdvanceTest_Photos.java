package iOS.Tests;

import Base.iOSBase;

import Enums.GestureDirection;
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

public class iOSAdvanceTest_Photos extends iOSBase {

    private IOSDriver driver;

    String bundleId="com.apple.mobileslideshow";
    String appName="com.apple.mobileslideshow";

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
    public void SwipePhotos() throws InterruptedException {
        //**/XCUIElementTypeCell
        int numberofPhotos=driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).size();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell[1]")).click();
        WebElement activeElement=driver.findElement(AppiumBy.accessibilityId("Photos"));

        while(numberofPhotos > 1){
            iOSHelper.Swipe(activeElement, GestureDirection.LEFT.getAction(),driver);
            Thread.sleep(2000);
            numberofPhotos--;
        }

    }

    //com.apple.mobileslideshow
    @AfterMethod
    public void AfterMethod(){
        System.out.println("In AfterMethod, runs after every test.");
        getDriver().terminateApp(bundleId);
    }
//

}
