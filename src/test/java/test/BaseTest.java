package test;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import webdriver.DriverType;

public class BaseTest {

    protected WebDriver driver;
    protected VisualGridRunner runner = null;
    protected Eyes eyes;
    private static BatchInfo batchInfo;
    protected Configuration configuration;

    @BeforeClass()
    public void beforeSuite() {
        // Create the batchInfo object and set it up with the batchId
        batchInfo = new BatchInfo("Testing Lifecycle");

        runner = new VisualGridRunner(10);
    }

    @BeforeMethod()
    public void beforeMethod() {
        driver = DriverType.CHROME.getWebDriverObject();
        eyes = new Eyes(runner);

        // Setup the configuration
        configuration = new Configuration();

        // You can get your api key from the Applitools dashboard
        configuration.setApiKey("7d99Q5zxRofSnuBVBVqZJ3FpgjQRVe111ZCkn3VpmSCGAY110");
        configuration.setBatch(batchInfo);

        // Add browsers with different viewports
        configuration.addBrowser(1200, 800, BrowserType.CHROME);
        configuration.addBrowser(1200, 800, BrowserType.FIREFOX);
        configuration.addBrowser(1200, 800, BrowserType.EDGE_CHROMIUM);
        configuration.addBrowser(1200, 800, BrowserType.SAFARI);

        // Add mobile emulation devices in Portrait mode
        configuration.addDeviceEmulation(DeviceName.iPhone_X);

        // Add match level Exact
        configuration.setMatchLevel(MatchLevel.EXACT);

        eyes.setConfiguration(configuration);
    }

    @AfterMethod()
    public void afterSuite() {
        // Close driver
        if (driver != null)
            driver.quit();

        // Close eyes
        if (eyes != null) {
            eyes.closeAsync();
            eyes.abortAsync();
        }
    }

    @AfterClass()
    public void closeRunner() {
        // Close runner
        if (runner != null) {
            TestResultsSummary allTestResults = runner.getAllTestResults(false);
            System.out.println(allTestResults);
        }
    }
}