package pac1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC005_WindowHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://letcode.in/window");
		System.out.println("parent window" +driver.getWindowHandles());
		driver.findElement(By.id("multi")).click();
		
		Set<String> windows=driver.getWindowHandles();
		System.out.println("no. of windows:" +windows.size());
		for(String childWindow: windows)
		{
			driver.switchTo().window(childWindow);
			System.out.println("url is:"+driver.getCurrentUrl());
		}
		// TODO Auto-generated method stub

	}

}
