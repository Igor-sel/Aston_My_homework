package org.Mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


import org.Mobile.common.CommonAction;
import org.Mobile.pages.MainPageApp;
import org.testng.annotations.AfterClass;


public class BaseTest {
    protected AndroidDriver<AndroidElement> driver = CommonAction.createAndroidDriver();
    protected MainPageApp mainPageApp = new MainPageApp(driver);

    @AfterClass
    public static void teardown() {
        CommonAction.quitDriver();
    }

}
