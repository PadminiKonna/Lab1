package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab5_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a/span")).click();
		//driver.findElement(By.xpath("//*[@id=\"ap_email_login\"]")).click();
		if(driver.findElement(By.id("ap_email_login")).isDisplayed()) {
			System.out.println("email  create is displayed");
			//driver.findElement(By.id("ap_email_login")).clear();
			driver.findElement(By.id("ap_email_login")).sendKeys("dfghjf@gmail.com");
			driver.findElement(By.id("ap_email_login")).sendKeys(Keys.TAB);
			driver.findElement(By.id("ap_email_login")).sendKeys(Keys.ENTER);			
		}
		else {
			System.out.println("email create is not displayed");
		}

	}

}
