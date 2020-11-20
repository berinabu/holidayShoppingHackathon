package test;

import common.PageUrl;
import org.testng.annotations.Test;
import page.FashionAppPageObject;
import page.ProductDetailsPageObject;

public class AppliFashionTest extends BaseTest {

    private FashionAppPageObject fashionAppPageObject;

    @Test(description = "Main page design verification")
    public void mainPageTest() {
        // Open main page
        navigateToPage(PageUrl.PRODUCTION.getPageUrl(), "Test 1");

        // Check page window
        eyes.checkWindow("main page");
    }

    @Test(description = "Filter products design verification")
    public void filteredProductGridTest() {
        fashionAppPageObject = new FashionAppPageObject(driver);

        // Open main page
        navigateToPage(PageUrl.PRODUCTION.getPageUrl(), "Test 2");

        // Choose filter color black and click filter
        fashionAppPageObject.clickCheckboxColorBlack();
        fashionAppPageObject.clickButtonFilter();

        // Check product grid
        eyes.checkRegion(fashionAppPageObject.productGrid, "filter by color");
    }

    @Test(description = "Product details design verification")
    public void productDetailsTest() {
        fashionAppPageObject = new FashionAppPageObject(driver);
        ProductDetailsPageObject productDetailsPageObject = new ProductDetailsPageObject(driver);

        // Open main page
        navigateToPage(PageUrl.PRODUCTION.getPageUrl(), "Test 3");

        // Click on Appli Air x Night
        fashionAppPageObject.clickProductItemAppliAirNight();
        productDetailsPageObject.waitForProductName();

        // Check window
        eyes.checkWindow("product details");
    }

    private void navigateToPage(String url, String testName) {
        // Navigate to page
        driver.get(url);
        eyes.open(driver, "AppliFashion", testName);
    }
}