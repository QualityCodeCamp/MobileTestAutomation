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

import static Helper.iOSHelper.ClickAllowButton;
import static Helper.iOSHelper.ClickContinueButton;

public class iOSAdvanceTest_Reminder extends iOSBase {

    private IOSDriver driver;

    String bundleId="com.apple.reminders";
    String appName="com.apple.reminders";

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

//Practice
    @Test
    public void reminder() throws InterruptedException {
        //ClickAllowButton(driver);

        //ClickContinueButton(driver);


       int count = 0;

        while (count < 10) {

            //Click on Add List
            driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Reminders\"`]")).click();
            driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"New Reminder\"`]")).click();

            //Add reminder name
            WebElement listName = driver.findElement(AppiumBy.accessibilityId("Title"));
            listName.sendKeys("myReminder " +  ++count);

            //Add reminder
            driver.findElement(AppiumBy.iOSNsPredicateString("label == \"Done\"")).click();
       }

       //Scroll to lower element
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"CompleteOff\"`][8]")).click();

        Thread.sleep(5000);

    }
    //com.apple.mobileslideshow
    @AfterMethod
    public void AfterMethod(){
        System.out.println("In AfterMethod, runs after every test.");
        getDriver().terminateApp(bundleId);
    }
//

}
