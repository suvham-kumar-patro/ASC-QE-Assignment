package pac1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC004_Alerts {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.name("proceed")).click();
		
		Alert simpleAlert=driver.switchTo().alert();
		System.out.println("message is:"+simpleAlert.getText());
		simpleAlert.accept();
		
		driver.get("https://letcode.in/alert");
		driver.findElement(By.id("confirm")).click();
		Alert confirmalert=driver.switchTo().alert();
		System.out.println("message is:"+confirmalert.getText()); 
		confirmalert.accept();
		// TODO Auto-generated method stub

	}

}
