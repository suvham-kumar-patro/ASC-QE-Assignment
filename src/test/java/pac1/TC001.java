package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https:google.com/");
		System.out.println("The title is:" + driver.getTitle());
		System.out.println("The current URL is:" + driver.getCurrentUrl());
		WebElement search = driver.findElement(By.id("APjFqb"));
		search.sendKeys("Software Testing Tools");
		search.submit();
		// TODO Auto-generated method stub
		driver.navigate().to("https://www.amazon.in/");
		System.out.println("The title is:" + driver.getTitle());
		driver.navigate().back();
		System.out.println("The title is:" + driver.getTitle());
		driver.navigate().forward();
		System.out.println("The title is:" + driver.getTitle());
		driver.quit();

	}

}
