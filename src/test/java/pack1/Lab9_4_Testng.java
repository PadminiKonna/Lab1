package pack1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
//import org.testng.Reporter;
import org.testng.annotations.*;

public class Lab9_4_Testng {
  
  WebDriver driver;

  @Parameters("browser")
  @Test
  @BeforeClass
  public void test2(String browser) throws InterruptedException {
		WebDriver driver;
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			  driver=new ChromeDriver();
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			  driver.get("https://tutorialsninja.com/demo/index.php?");
			  System.out.println("chrome displayed");
			  driver.findElement(By.linkText("Desktops")).click();
			  driver.findElement(By.linkText("Mac (1)")).click();
			  System.out.println(" desktop displyaed");
			  WebElement sort=driver.findElement(By.id("input-sort"));
				Select sle=new Select(sort);
				 System.out.println("data sorted");
				sle.selectByIndex(1);
				JavascriptExecutor js=(JavascriptExecutor)driver;
				//js.executeScript("alert('helloo')");
				js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
				driver.findElement(By.xpath("//button/span[text()='Add to Cart']")).click();
				driver.findElement(By.xpath("//input[@name='search']")).sendKeys("mobile");
				driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']//i[@class='fa fa-search']")).click();
			
				WebElement cl=driver.findElement(By.id("input-search"));
				cl.clear();
				driver.findElement(By.id("description")).click();
				 System.out.println(" clicked the description");
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			  driver=new EdgeDriver();
			  driver.get("https://tutorialsninja.com/demo/index.php?");
			  System.out.println("edge displayed");
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			  driver.findElement(By.linkText("Desktops")).click();
			  driver.findElement(By.linkText("Mac (1)")).click();
			  System.out.println(" desktop displyaed");
			  WebElement sort=driver.findElement(By.id("input-sort"));
				Select sle=new Select(sort);
				 System.out.println(" sorted");
				sle.selectByIndex(1);
				JavascriptExecutor js=(JavascriptExecutor)driver;
				//js.executeScript("alert('helloo')");
				js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
				driver.findElement(By.xpath("//button/span[text()='Add to Cart']")).click();
				driver.findElement(By.xpath("//input[@name='search']")).sendKeys("mobile");
				driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']//i[@class='fa fa-search']")).click();
				Thread.sleep(3000);
				WebElement cl=driver.findElement(By.id("input-search"));
				cl.clear();
				driver.findElement(By.id("description")).click();
				 System.out.println(" decripition clicked");
			
		}
}
}
