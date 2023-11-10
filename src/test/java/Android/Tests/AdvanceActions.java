package Android.Tests;

import Base.AndroidBase;
import Enums.GestureDirection;
import Helper.AndroidHelper;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class AdvanceActions extends AndroidBase {

    private AndroidDriver driver;

    String bundleId = "io.appium.android.apis";
    String appName = "C:\\Users\\16473\\IdeaProjects\\TestProject\\ApiDemos-debug.apk";

    @BeforeClass
    public void BeforeClass() {
        System.out.println("In Beforeclass of the child class");
        driver = getDriver();
        setBundleid(bundleId);
        setAppName(appName);
        System.out.println("Driver is " + driver.toString());
    }

    @BeforeMethod
    public void beforemethod() {
        System.out.println("in beforemthod , runs before every test");
        getDriver().activateApp(bundleId);
    }

    @Test
    public void LongClick() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement e = driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]"));
        AndroidHelper.LongClickAction(e, driver);
        Thread.sleep(2000);
    }

    @Test
    public void swipe() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement e = driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]"));
        AndroidHelper.swipeaction(e, GestureDirection.LEFT.getAction(), driver);
        Thread.sleep(2000);


    }

    @Test
    public void DragDrop() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement e = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        AndroidHelper.draganddrop(e, 832, 749, driver);
        Thread.sleep(3000);
    }

    @Test
    public void datepicker() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Date Widgets")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Dialog")).click();


        //Get current date
        String CurrentDateOnCalender = driver.findElement(By.id("io.appium.android.apis:id/dateDisplay")).getText();
        int currentDay = AndroidHelper.GetDate(CurrentDateOnCalender).getDayOfMonth();
        System.out.println("CurrentDay is " + currentDay);
        //Change date
        driver.findElement(AppiumBy.accessibilityId("change the date")).click();

        int dayToSelect = 1;
        if (currentDay == 1) {
            ++dayToSelect;
        }

        String xpath = String.format("//android.view.View[@text=\"%s\"]", dayToSelect);
        driver.findElement(By.xpath(xpath)).click();

        driver.findElement(By.id("android:id/button1")).click();

        CurrentDateOnCalender = driver.findElement(By.id("io.appium.android.apis:id/dateDisplay")).getText();
        int newDay = AndroidHelper.GetDate(CurrentDateOnCalender).getDayOfMonth();

        Assert.assertEquals(dayToSelect, newDay);

        //Date Widgets -- Accessibility id

        //1. Dialog -- Accessibility id

        //io.appium.android.apis:id/dateDisplay -id

        //    change the date --accessibility id

        //android.view.View[@content-desc="01 June 2023"]
        //text property

        //android:id/button1 -ok button
    }

    @Test
    public void misc() {

        //Popup
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("5. Preferences from code")).click();

        //5. Preferenc
        //    @Test
        //    public void practicetest1(){
        //            driver.findElement(AppiumBy.accessibilityId("App")).click();
        //            driver.findElement(AppiumBy.accessibilityId("Fragment")).click();
        //        es from code -ai
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"List preference\"]")).click();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text=\"Charlie Option 03\"]")).click();


        //Checkbox
        WebElement element = driver.findElement(By.id("android:id/checkbox"));
        System.out.println("Before enabling checkbox . Checked attribute is " + element.getAttribute("checked"));
        element.click();
        System.out.println("After enabling checkbox . Checked attribute is " + element.getAttribute("checked"));

        //Switch
        WebElement element1 = driver.findElement(By.id("android:id/switch_widget"));
        System.out.println("Before enabling checkbox . Checked attribute is " + element1.getAttribute("checked"));
        element1.click();
        System.out.println("After enabling checkbox . Checked attribute is " + element1.getAttribute("checked"));


//android.widget.TextView[@text="List preference"]--list preference

        //android.widget.CheckedTextView[@text="Charlie Option 03"]

        //android:id/checkbox
        // android:id/switch_widget

        driver.findElement(AppiumBy.accessibilityId("Context Menu")).click();
//        WebElement element = driver.findElement(AppiumBy.accessibilityId("Long press me"));
        AndroidHelper.LongClickAction(element, driver);
        String text = driver.findElements(By.className("android.widget.TextView")).get(0).getText();
        Assert.assertEquals("Menu A", text);
    }



    @Test
    public void practicetest2(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        WebElement element =  driver.findElement(By.xpath("//android.widget.ImageView[@index=\"0\"]"));
        AndroidHelper.swipeaction(element,GestureDirection.RIGHT.getAction(), driver);
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