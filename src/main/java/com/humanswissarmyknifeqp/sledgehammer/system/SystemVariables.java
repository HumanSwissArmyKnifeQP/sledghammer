package com.humanswissarmyknifeqp.sledgehammer.system;

public class SystemVariables {
    
    public static final String CHROMEDRIVER_KEY = "webdriver.chrome.driver";
    public static final String DEFAULT_CHROMEDRIVER_PATH = "C:\\WebDrivers\\chromedriver.exe";
    
    public static String getChromeDriverPath(){
        return System.getProperty(CHROMEDRIVER_KEY);
    }
    
    public static void setDefaultChromeDriverPath(){
        System.setProperty(CHROMEDRIVER_KEY, DEFAULT_CHROMEDRIVER_PATH);
    }
}
