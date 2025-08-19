package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.opencart.com/");
		//Thread.sleep(3000);
		System.out.println("The Title is:" +driver.getTitle());
		//WebElement search=driver.findElement(By.id("search"));
		//search.sendKeys("Automation testing tools");
		//System.out.println("The Title is:" +driver.getTitle());
		String title = driver.getTitle();
		if(title.equals("OpenCart - Open Source Shopping Cart Solution")) {
			System.out.println("Matched");
		}
		else {
			System.out.println(" Not Matched");
		}
		//WebElement register = driver.findElement(By.linkText("REGISTER"));
		//register.click();
		driver.navigate().to("https://www.yahoo.com/");
		System.out.println("The  Current Url is:" +driver.getCurrentUrl());
		driver.navigate().back();
		System.out.println("The Url is:" +driver.getCurrentUrl());
		driver.navigate().forward();
		driver.navigate().refresh();
		System.out.println("The Url is:" +driver.getCurrentUrl());
		System.out.println("page source is:" +driver.getPageSource());
		

	}

}
