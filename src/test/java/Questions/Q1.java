package Questions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q1 {
	WebDriver driver;
  @Test
  public void f() {
	  driver=new ChromeDriver();
	  driver.get("https://www.google.com/");
	  WebDriverManager.chromedriver().setup();
	  String title=driver.getTitle();
	  System.out.println("the Title of the page:"+title);
	  driver.quit();
  }
}
