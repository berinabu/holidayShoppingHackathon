package webdriver;

import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public enum DriverType implements DriverSetup {
    CHROME {
        public RemoteWebDriver getWebDriverObject() {
            HashMap<String, Object> chromePreferences = new HashMap<>();
            chromePreferences.put("profile.password_manager_enabled", false);

            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            options.addArguments("--no-default-browser-check");
            options.addArguments("--ignore-certificate-errors");
            options.setExperimentalOption("prefs", chromePreferences);

            return new ChromeDriver(options);
        }
    };

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}