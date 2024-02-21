package org.Mobile.common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonAction {
    static AndroidDriver<AndroidElement> driver = null;
    private CommonAction(){}

    public static AndroidDriver<AndroidElement>  createAndroidDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if(driver == null){
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Config.DEVICE_NAME);
            capabilities.setCapability(MobileCapabilityType.APP, Config.APP_PATH);
            capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            try {
                driver = new AndroidDriver<>(new URL(Config.DRIVER_URL), capabilities);
                driver.manage().timeouts().implicitlyWait(Config.IMPLICIT_WAIT, TimeUnit.SECONDS);
            } catch (MalformedURLException e) {
                System.out.println(e.getMessage());
            }
        }
        return driver;
    }

    public static void quitDriver(){
        driver.quit();
    }

}