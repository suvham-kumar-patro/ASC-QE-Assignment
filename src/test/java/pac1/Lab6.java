package pac1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Lab6 {

	public static void main(String[] args){
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://tutorialsninja.com/demo/index.php?");

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("skp@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("Test@123456");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        WebElement components = driver.findElement(By.xpath("//a[text()='Components']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", components);
        driver.findElement(By.xpath("//a[contains(text(),'Monitors (2)')]")).click();

        Select showDropdown = new Select(driver.findElement(By.id("input-limit")));
        showDropdown.selectByVisibleText("25");

        driver.findElement(By.xpath("(//span[text()='Add to Cart']/parent::button)[1]")).click();

        driver.findElement(By.xpath("//a[text()='Specification']")).click();
        if (driver.findElement(By.id("tab-specification")).isDisplayed()) {
            System.out.println("Specification details are present");
        } else {
            System.out.println("Specification details are missing");
        }

        driver.findElement(By.xpath("//button[@data-original-title='Add to Wish List']")).click();
        WebElement wishlistMsg = driver.findElement(By.cssSelector(".alert-success"));
        if (wishlistMsg.getText().contains("Success: You have added Apple Cinema 30")) {
            System.out.println("Added to wishlist successfully!");
        } else {
            System.out.println("Failed to add to wishlist.");
        }

        driver.findElement(By.name("search")).sendKeys("Mobile");
        driver.findElement(By.cssSelector(".btn-default.btn-lg")).click();

        driver.findElement(By.name("description")).click();
        driver.findElement(By.id("button-search")).click();

        driver.findElement(By.linkText("HTC Touch HD")).click();

        WebElement qty = driver.findElement(By.id("input-quantity"));
        qty.clear();
        qty.sendKeys("3");

        driver.findElement(By.id("button-cart")).click();
        WebElement successMsg = driver.findElement(By.cssSelector(".alert-success"));
        if (successMsg.getText().contains("Success: You have added HTC Touch HD")) {
            System.out.println("Added HTC Touch HD to cart successfully!");
        } else {
            System.out.println("Add to cart failed.");
        }
        
        WebElement cartBtn = driver.findElement(By.xpath("//div[@id='cart']//button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartBtn);

        WebElement viewCartLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View Cart")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewCartLink);

        WebElement cartItem = driver.findElement(By.xpath("//table[@class='table table-bordered']//a[contains(text(), 'HTC Touch HD')]"));
        if (cartItem.isDisplayed()) {
            System.out.println("HTC Touch HD is present in cart.");
        } else {
            System.out.println("Item missing in cart.");
        }

        driver.findElement(By.linkText("Checkout")).click();

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Logout")).click();

        String logout = driver.getCurrentUrl();
        if (logout.contains("logout")) {
            System.out.println("Logout heading found!");
        } else {
            System.out.println("Logout heading not found!");
        }

        driver.findElement(By.linkText("Continue")).click();
        driver.quit();      
    }
}