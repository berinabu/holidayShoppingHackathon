package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPageObject extends BasePage {

    @FindBy(id = "shoe_name")
    public WebElement shoeName;

    public ProductDetailsPageObject(WebDriver driver) {
        super(driver);
    }

    public void waitForProductName(){
        waitForElementToAppear(shoeName);
    }
}