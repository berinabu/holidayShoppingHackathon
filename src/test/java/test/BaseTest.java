package test;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import webdriver.DriverType;

public class BaseTest {

    protected WebDriver driver;
    protected VisualGridRunner runner;
    protected Eyes eyes;
    private static BatchInfo batchInfo;
    protected Configuration configuration;

    @BeforeSuite(alwaysRun = true)
    public void beforeTestSuite() {
        // Create the batchInfo object and set it up with the batchId
        batchInfo = new BatchInfo("Testing Lifecycle");

        runner = new VisualGridRunner(10);
    }

    @BeforeTest(alwaysRun = true)
    public void beforeSuite() {
        driver = DriverType.CHROME.getWebDriverObject();
        eyes = new Eyes(runner);

        // Setup the configuration
        configuration = new Configuration();
        configuration.setBatch(batchInfo);

        // You can get your api key from the Applitools dashboard
        configuration.setApiKey("7d99Q5zxRofSnuBVBVqZJ3FpgjQRVe111ZCkn3VpmSCGAY110");

        // Add browsers with different viewports
        configuration.addBrowser(1200, 800, BrowserType.CHROME);
        configuration.addBrowser(1200, 800, BrowserType.FIREFOX);
        configuration.addBrowser(1200, 800, BrowserType.EDGE_CHROMIUM);
        configuration.addBrowser(1200, 800, BrowserType.SAFARI);

        // Add mobile emulation devices in Portrait mode
        configuration.addDeviceEmulation(DeviceName.iPhone_X);

        eyes.setBatch(batchInfo);
        eyes.setConfiguration(configuration);
    }

    @AfterTest(alwaysRun = true)
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

    @AfterSuite(alwaysRun = true)
    public void closeRunner() {
        // Close runner
        if (runner != null) {
            TestResultsSummary allTestResults = runner.getAllTestResults(false);
            System.out.println(allTestResults);
        }
    }
}