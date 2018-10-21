package com.humanswissarmyknifeqp.sledgehammer.demo;

import com.humanswissarmyknifeqp.sledgehammer.ui.DriverFactory;
import com.humanswissarmyknifeqp.sledgehammer.ui.Performance;
import static com.humanswissarmyknifeqp.sledgehammer.logging.DefaultLogger.*;
import com.humanswissarmyknifeqp.sledgehammer.system.SystemVariables;
import org.openqa.selenium.WebDriver;

public class DemoRunner {
    
    public static void main(String[] args){
        
        configureSystemVariables();
        WebDriver driver = DriverFactory.createPerfomanceDriver();
        driver.get("https://www.banggood.com");
        
        logFormattedMessage("End to end performance: %s", Performance.getEndToEndLoadTime(driver));
        driver.quit();
    }
    
    private static void configureSystemVariables(){
        String currChromeDriverPath = SystemVariables.getChromeDriverPath();
        logFormattedMessage("Current driver path: %s.", currChromeDriverPath);
        
        if(currChromeDriverPath == null || currChromeDriverPath.isEmpty()){
            logMessage("Attempting to set new driver path...");
            SystemVariables.setDefaultChromeDriverPath();
            logFormattedMessage("New driver path: %s", SystemVariables.getChromeDriverPath());
        }
    }
    
    
}
