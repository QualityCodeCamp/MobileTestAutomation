package Helper;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AndroidHelper {

    public static void LongClickAction(WebElement element, AndroidDriver driver){
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),"duration",2000
        ));
    }

    public static void swipeaction(WebElement element,String direction,AndroidDriver driver){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "left",
                "percent", 0.75
        ));
    }


    public static void draganddrop(WebElement element,int x,int y,AndroidDriver driver){
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", x,
                "endY", y
        ));
    }

    public static LocalDateTime GetDate(String dateString){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("M-d-yyyy HH:mm");
        LocalDateTime dateTime=null;
        try{
            dateTime=LocalDateTime.parse(dateString,formatter);

        }
        catch (DateTimeException e){
            System.out.println("Error parsing date:"+ e.getMessage());
        }
        return dateTime;
    }

    public static void Fling(WebElement element, String direction,  AndroidDriver driver){

        boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: flingGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "speed", 5000
        ));
    }

}
