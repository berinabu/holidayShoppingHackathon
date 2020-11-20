package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FashionAppPageObject extends BasePage {

    /**
     * Web elements
     */
    @FindBy(xpath = "//*[@id='colors__Black']/..")
    public WebElement checkboxColorBlack;

    @FindBy(id = "filterBtn")
    public WebElement buttonFilter;

    @FindBy(xpath = "//div[@class='grid_item']//h3[.='Appli Air x Night']")
    public WebElement productItemAppliAirNight;

    @FindBy(id = "product_grid")
    public WebElement productGrid;

    public FashionAppPageObject(WebDriver driver) {
        super(driver);
    }

    public void clickCheckboxColorBlack() {
        waitForElementToAppear(checkboxColorBlack);
        checkboxColorBlack.click();
    }

    public void clickButtonFilter() {
        waitForElementToAppear(buttonFilter);
        buttonFilter.click();
    }

    public void clickProductItemAppliAirNight() {
        waitForElementToAppear(productItemAppliAirNight);
        productItemAppliAirNight.click();
    }
}