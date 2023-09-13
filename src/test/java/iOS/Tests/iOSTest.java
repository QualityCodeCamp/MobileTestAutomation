package iOS.Tests;

import Base.iOSBase;

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

public class iOSTest extends iOSBase {

    private IOSDriver driver;

    String bundleId="com.example.apple-samplecode.UICatalog";
    String appName="/Users/bharatmalik/Documents/GitHub/TestProject/UICatalog.app";

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

//    @Test
//    public void sampletest(){
//        System.out.println("In Sample test");
//        Assert.assertTrue(true,"Installed the application");
//    }
    @Test
    public void Myfirsttestcase_iOS(){
     driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
     driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Text Entry\"`]")).click();
     var elements=driver.findElements(By.xpath("//XCUIElementTypeAlert"));
     System.out.println(elements.get(0).getAttribute("name"));

    }
//
//    @Test
//    public void Mysecondtestcase_iOS(){
//        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
//        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Text Entry\"`]")).click();
//        var element=driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField"));
//        element.sendKeys("New title is blue");
//        Assert.assertEquals("New title is blue",element.getAttribute("value"));
//        driver.findElement(AppiumBy.accessibilityId("OK"));
//
//    }


//    @Test
//    public void Mythirdtestcase_iOS(){
//        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
//        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Text Entry\"`]")).click();
//        //driver.findElement(AppiumBy.iOSNsPredicateString("label == \"Cancel\""));
//        driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH 'Ca' and type=='XCUIElementTypeButton'")).click();
//
//    }

//    @Test
//    public void My4thTestcase_iOS(){
//       WebElement element= driver.findElement(AppiumBy.accessibilityId("Web View"));
//        //iOSHelper.Scroll(element,"down",driver);
//        element.click();
//
//    }
   // Picker View
//    @Test
//    public void My5thTestcase_iOS(){
//        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
//        //iOSHelper.Scroll(element,"down",driver);
//       driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("80");
//
//        driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("220");
//        driver.findElement(AppiumBy.accessibilityId("Blue color component value")).sendKeys("105");
//
//        Assert.assertEquals(driver.findElement(AppiumBy.accessibilityId("Blue color component value")).getText(),"105");
//
//    }
@AfterMethod
public void aftermethod(){
    System.out.println("in aftermethod , runs after every test");
    getDriver().terminateApp(bundleId);
}
//Sliders
//@Test
//public void My6thTestcase_PracticeiOS(){
//    driver.findElement(AppiumBy.accessibilityId("Sliders")).click();
//    System.out.println("Before moving slider" + driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider")).getAttribute("value"));
//    driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider")).sendKeys("1%");
//    System.out.println("After moving slider "+driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider")).getAttribute("value"));
//}
}
