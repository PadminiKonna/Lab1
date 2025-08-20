package pack1;

import org.testng.annotations.Test;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TC0012_TestNg2_pagefactory {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(String username, String password) throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
		//WebDriver driver;
		String title=driver.getTitle();
		System.out.println("The Title is:"+title);
		Thread.sleep(3000);
		//WebElement username=driver.findElement(By.name("username"));
		//username.sendKeys("Admin");
		login_pagefactory obj=PageFactory.initElements(driver, login_pagefactory.class);
		obj.enterusername(username);
		obj.enterpassword(password);
		obj.clickonlogin();

		//driver.findElement(By.name("username")).sendKeys(username);
		//driver.findElement(By.name("password")).sendKeys(password);
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method");
	  driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method");
	  driver.quit();
  }


  @DataProvider
  public Object[][] dp() {
	  
	  
	  
	  
    return new Object[][] {
      new Object[] { "Admin", "admin123" },
      new Object[] { "padmini", "Admin@345" },
     // new Object[] { "aswini", "Aswini@345" },
    };
}
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before Class");  }

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
