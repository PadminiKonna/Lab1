package pack1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab8_4_assertion {
	 WebDriver driver;

  
  @Test(dataProvider = "dp")
  public void f(String searchItem) throws InterruptedException {
	  driver.findElement(By.linkText("Desktops")).click();
      driver.findElement(By.linkText("Mac (1)")).click();
      
      
      String heading = driver.findElement(By.xpath("//h2")).getText();
      Assert.assertEquals(heading, "Mac", " Mac page did not open!");
      
      WebElement sort = driver.findElement(By.id("input-sort"));
      sort.click();
      sort.findElement(By.xpath("//option[contains(text(),'Name (A - Z)')]")).click();

     
      driver.findElement(By.xpath("//button[contains(@onclick,'cart.add')]")).click();
      Thread.sleep(3000);
      
      
      String successMsg = driver.findElement(By.cssSelector("div.alert-success")).getText();
      Assert.assertTrue(successMsg.contains("Success"), " Product not added to cart!");

      
      WebElement searchBox = driver.findElement(By.name("search"));
      searchBox.clear();
      searchBox.sendKeys(searchItem);
      driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
      
      
     

     
      WebElement criteria = driver.findElement(By.name("search"));
      criteria.clear();
      criteria.sendKeys(searchItem);
      driver.findElement(By.name("description")).click();
      driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
      
      



      System.out.println("Search completed for: " + searchItem);
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		System.out.println("Application launched successfully");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
    	new Object[] { "Mobile" },
        new Object[] { "Monitors" }
    };
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before Class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After Class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("After Suite");
  }

}
