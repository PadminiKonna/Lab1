package Questions;

import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class Q2 {
	WebDriver driver;
  @Test  
    public void f() {
	  driver.findElement(By.name("username")).sendKeys("tomsmith");
  	  driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
  	  driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
  	String smsg = driver.findElement(By.id("flash")).getText();

    
    if (smsg.contains("You logged into a secure area!")) {
        System.out.println("Login successful:" + smsg);
    } else {
        System.out.println("Login failed:" + smsg);
    }
  	 
    }
    @BeforeMethod
    public void beforeMethod() {
  	  
  	driver=new ChromeDriver();
	  driver.get("https://the-internet.herokuapp.com/login");
	  WebDriverManager.chromedriver().setup();
	  

    
    }
  }


