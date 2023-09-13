package Helper;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

public class iOSHelper {
    public static void Scroll(WebElement element, String direction, IOSDriver driver) {
        ((JavascriptExecutor) driver).executeScript("mobile: scroll", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction
        ));
    }

    public static void LongPress(WebElement element, String duration, IOSDriver driver) {
        ((JavascriptExecutor) driver).executeScript("mobile:touchAndHold", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "duration", duration
        ));

    }


    public static void Swipe(WebElement element, String direction, IOSDriver driver) {
        ((JavascriptExecutor) driver).executeScript("mobile:swipe", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction
        ));

    }

    public static void ClickAllowButton(WebDriver driver) {
        List<WebElement> allowButton = driver.findElements(AppiumBy.iOSNsPredicateString("label == \"Allow While Using App\""));

        if (allowButton.size() > 0) {
            allowButton.get(0).click();
        }
    }

    public static void ClickContinueButton(WebDriver driver){
        List<WebElement> continueButton = driver.findElements(AppiumBy.iOSNsPredicateString(
                "label == \"Continue\" AND name == \"Continue\" AND type == \"XCUIElementTypeButton\""));

        if (continueButton.size() > 0) {
            continueButton.get(0).click();
        }
    }

}
