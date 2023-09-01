package Android.Tests;

import Base.AndroidBase;
import Enums.GestureDirection;
import Helper.AndroidHelper;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class SecurityTest extends AndroidBase {

    private  AndroidDriver driver;

   // String bundleId="com.android.settings";
    String bundleId="io.appium.android.apis";

    @BeforeClass
    public  void BeforeClass(){
        System.out.println("In Beforeclass of the child class");
        driver=getDriver();
        setBundleid(bundleId);
        System.out.println("Driver is "+driver.toString());
    }

    @BeforeMethod
    public void beforemethod(){
        System.out.println("in beforemthod , runs before every test");
      // getDriver().activateApp(bundleId);
    }



//    @Test
//    public void DeviceLevelsettings(){
//       driver.openNotifications();
//        System.out.println(driver.getDeviceTime());
//        System.out.println(driver.getDeviceTime("mm/dd/yyyy"));
//
//    }
//@Test
//    public void setpin() throws InterruptedException {
//    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Security\"));")).click();
//    driver.findElement(By.xpath(" //android.widget.TextView[@text='Pixel Imprint']")).click();
//    driver.findElement(By.xpath(" //android.widget.TextView[@text='PIN']")).click();
//    //Thread.sleep(4000);
//    //System.out.println(driver.getPageSource());
//
//    driver.findElement(By.className("android.widget.EditText")).sendKeys("0000");
//    driver.findElement(By.xpath(" //android.widget.Button[@text='NEXT']")).click();
//
//    driver.findElement(By.className("android.widget.EditText")).sendKeys("0000");
//    driver.findElement(By.xpath(" //android.widget.Button[@text='CONFIRM']")).click();
//    driver.findElement(By.xpath("//android.widget.Button[@text='DONE']")).click();
//
//    //android.widget.TextView[@text='Pixel Imprint'] -
//        //android.widget.TextView[@text='PIN']
//    }

//    @Test
//    public void SETUPFINGERPRINT() throws InterruptedException {
//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Security\"));")).click();
//        driver.findElement(By.xpath("//android.widget.TextView[@text='Pixel Imprint']")).click();
//        driver.findElement(By.className("android.widget.EditText")).sendKeys("0000");
//       // driver.executeScript("mobile:performEditorAction",ImmutableMap.of("action","done"));
//        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
//
//        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"I AGREE\"));")).click();
//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"I AGREE\").instance(0))"));
//        driver.findElement(By.xpath("//android.widget.Button[@text='I AGREE']")).click();
//
//        boolean isaddedFingerprint=false;
//
//        while(!isaddedFingerprint)
//        try{
//            WebElement element= driver.findElement(By.xpath("//android.widget.Button[@text='DONE']"));
//        element.click();
//        isaddedFingerprint=true;
//        }
//        catch (Exception e){
//            driver.fingerPrint(1);
//            Thread.sleep(2000);
//        }
//
//    }


//    @Test
//    public void appactivity() throws InterruptedException {
//        System.out.println(driver.currentActivity());
//
//        System.out.println(driver.getCurrentPackage());
//        driver.terminateApp("io.appium.android.apis");
//        driver.startActivity(new Activity("io.appium.android.apis",".ApiDemos"));
//
//
//    }

    @Test
    public void networkactivity() throws InterruptedException {

        driver.toggleAirplaneMode();

        driver.toggleWifi();


    }
    @AfterMethod
    public void aftermethod(){
        System.out.println("in aftermethod , runs after every test");
       // getDriver().terminateApp(bundleId);
    }
    @AfterClass
    public void TearDown(){

        System.out.println("In teardown of the child class");
    }

}