package Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidBase {


    private String bundleid="";
    private String appName="";

    public ThreadLocal<AndroidDriver> driver= new ThreadLocal<>();
    public AndroidDriver getDriver() {
        return this.driver.get();
    }
    public String getBundleid() {
        return bundleid;
    }

    public String getAppName() {
        return appName;
    }

    public void setBundleid(String bundleid) {
        this.bundleid = bundleid;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void setDriver(AndroidDriver driver) {
        this.driver.set(driver);
    }

    @BeforeClass
    @Parameters({"deviceName","port"})
    public  void ConfigureDriver(String deviceName,String port) throws MalformedURLException {
    System.out.println("Device name recieved is and drive is " + deviceName+ " "+driver.toString());
        UiAutomator2Options dc=new UiAutomator2Options();

        //dc.setDeviceName(deviceName);
        dc.setUdid(deviceName);
        dc.setApp(appName);
        String url=String.format("http://0.0.0.0:%s",port);
        //dc.setPlatformVersion("Android 13.0");
        setDriver(new AndroidDriver(new URL(url),dc));

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public void teardown(){
        getDriver().quit();
    }







}
