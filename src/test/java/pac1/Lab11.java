package pac1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Lab11 {
	 
    WebDriver driver;
 
    public Lab11(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
 
    @FindBy(linkText = "Desktops")
    WebElement desktopsTab;
 
    @FindBy(linkText = "Mac (1)")
    WebElement macLink;
 
    @FindBy(id = "input-sort")
    WebElement sortDropdown;
 
    @FindBy(xpath = "//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12']//button[1]")
    WebElement addToCartButton;
 
    @FindBy(css = ".alert-success")
    WebElement successAlert;
 
    @FindBy(name = "search")
    WebElement searchBox;
 
    @FindBy(css = "#search button")
    WebElement searchButton;
 
    @FindBy(id = "input-search")
    WebElement inputSearchBox;
 
    @FindBy(id = "description")
    WebElement descriptionCheckbox;
 
    @FindBy(id = "button-search")
    WebElement buttonSearch;
 
    public void clickDesktops() {
        desktopsTab.click();
    }
 
    public void clickMacLink() {
        macLink.click();
    }
 
    public void sortByNameAZ() {
        new Select(sortDropdown).selectByVisibleText("Name (A - Z)");
    }
 
    public void addToCart() {
        addToCartButton.click();
    }
 
    public boolean isSuccessMessageDisplayed(String itemName) {
        return successAlert.getText().contains("Success: You have added " + itemName + " to your shopping cart!");
    }
 
    public void searchProduct(String product) {
        searchBox.clear();
        searchBox.sendKeys(product);
        searchButton.click();
    }
 
    public void searchProductWithDescription(String product) {
        inputSearchBox.clear();
        inputSearchBox.sendKeys(product);
        descriptionCheckbox.click();
        buttonSearch.click();
    }
}
