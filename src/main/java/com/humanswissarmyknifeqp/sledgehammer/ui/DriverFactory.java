package com.humanswissarmyknifeqp.sledgehammer.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * TODO: Create parametrized method for instantiating specific browsers
 *
 * @author humanswissarmyknife
 */
public class DriverFactory {

    /**
     * This method MIGHT be DEPRECATED once POC is completed.
     *
     * @return
     */
    public static WebDriver createPerfomanceDriver() {

        Capabilities caps = getPerformanceCaps();
        ChromeDriver cDriver = new ChromeDriver(caps);
        return cDriver;
    }

    private static Capabilities getPerformanceCaps() {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        Map<String, Object> perfLogPrefs = new HashMap<>();
        perfLogPrefs.put("traceCategories", "browser,devtools.timeline,devtools"); // comma-separated trace categories
        perfLogPrefs.put("enableNetwork", true);
        ChromeOptions options = new ChromeOptions();
        
        // Enable experimental
        options.setExperimentalOption("perfLoggingPrefs", perfLogPrefs);
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        
        return caps;
    }

}
