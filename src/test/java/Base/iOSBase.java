package Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class iOSBase {

    private String bundleid="";
   // private String appName="";
    public ThreadLocal<IOSDriver> driver= new ThreadLocal<>();
    public IOSDriver getDriver() {
        return this.driver.get();
    }
    public String getBundleid() {
        return bundleid;
    }

//    public String getAppName() {
//        return appName;
//    }

    public void setBundleid(String bundleid) {
        this.bundleid = bundleid;
    }

//    public void setAppName(String appName) {
//        this.appName = appName;
//    }

    public void setDriver(IOSDriver driver) {
        this.driver.set(driver);
    }

    @BeforeClass
    @Parameters({"deviceName","port","appName"})
    public  void ConfigureDriver(String deviceName,String port,String appName) throws MalformedURLException {
        System.out.println("In Before class of the base.runs before everyone else");
        XCUITestOptions dc=new XCUITestOptions();
        dc.setDeviceName(deviceName);
        dc.setApp(appName);
        dc.setWdaLaunchTimeout(Duration.ofSeconds(20));
        String url=String.format("http://0.0.0.0:%s",port);
        // dc.setPlatformVersion("");
        setDriver(new IOSDriver(new URL(url),dc));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterClass
    public void teardown(){
        getDriver().quit();
    }







}
