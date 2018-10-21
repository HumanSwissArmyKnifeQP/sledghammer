package com.humanswissarmyknifeqp.sledgehammer.ui;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Performance {
    
    private static final String TIME_INTERVAL_COMMAND = "return %s - %s;";
    
    private static final String NAVIGATION_START = "performance.timing.navigationStart";
    private static final String PAGE_LOAD_END = "performance.timing.loadEventEnd";
    
    public static Long getEndToEndLoadTime(WebDriver driver){
        return (Long) ((JavascriptExecutor)driver).executeScript(
                String.format(TIME_INTERVAL_COMMAND, PAGE_LOAD_END, NAVIGATION_START));
    }
}
