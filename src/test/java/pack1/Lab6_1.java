package pack1;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab6_1{
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 driver.get("https://tutorialsninja.com/demo/index.php");
		 driver.findElement(By.linkText("Components")).click();
	        driver.findElement(By.linkText("Monitors (2)")).click();
	        Select showDropdown = new Select(driver.findElement(By.id("input-limit")));
	        showDropdown.selectByVisibleText("25");
	        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[2]/button[1]")).click();
	        Thread.sleep(3000);
	        
	        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/ul[2]/li[2]/a")).click();
	        WebElement specTab = driver.findElement(By.id("tab-specification"));
	        if (specTab.isDisplayed()) {
	            System.out.println("Specification tab verified.");
	        }
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//button[@data-original-title='Add to Wish List']")).click();
	        
	        
	        WebElement successMsg = driver.findElement(By.cssSelector(".alert-success"));
	        if (successMsg.getText().contains("Success: You have added Apple Cinema 30\" to your wish list!")) {
	            System.out.println("Wish list message verified.");
	        }
	        
	        driver.findElement(By.name("search")).sendKeys("Mobile");
	        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();

	        // 11. Click 'Search in product descriptions'
	        driver.findElement(By.id("description")).click();
	        driver.findElement(By.id("button-search")).click();

	        // 12. Click on HTC Touch HD link
	        driver.findElement(By.linkText("HTC Touch HD")).click();

	        // 13. Update Qty = 3
	        WebElement qtyBox = driver.findElement(By.id("input-quantity"));
	        qtyBox.clear();
	        qtyBox.sendKeys("3");

	        // 14. Add to Cart
	        driver.findElement(By.id("button-cart")).click();

	        // 15. Verify success message
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement successCart = wait.until(ExpectedConditions.elementToBeClickable (driver.findElement(By.cssSelector("div.alert.alert-success"))));
	        if (successCart.getText().contains("Success: You have added HTC Touch HD to your shopping cart!")) {
	            System.out.println("Cart success message verified.");
	        }
	        
	        
	        
	        
	        //driver.findElement(By.xpath("//*[@id=\"cart\"]/button")).click();

	        
	        
	        // 16. Click on 'View cart' 
	        
	        /* WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	         WebElement viewCart = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\\\"cart\\\"]/ul/li[2]/div/p/a[1]/strong")));
	         viewCart.click();
	         System.out.println("Clicked on View Cart.");

	        
	        //driver.findElement(By.xpath("//*[@id=\"cart\"]/button")).click();
	        //driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]/strong")).click();

	       /* // 17. Verify Mobile name in cart
	        if (driver.findElement(By.linkText("HTC Touch HD")).isDisplayed()) {
	            System.out.println("HTC Touch HD verified in cart.");
	        }

	      /*  // 18. Click on 'Checkout'
	        driver.findElement(By.linkText("Checkout")).click();

	      /*  // 19. Click on 'My Account' -> 'Logout'
	        driver.findElement(By.linkText("My Account")).click();
	        driver.findElement(By.linkText("Logout")).click();

	        // 20. Verify 'Account Logout' heading
	        if (driver.findElement(By.tagName("h1")).getText().equals("Account Logout")) {
	            System.out.println("Logout successful.");
	        }

	        // 21. Click on Continue
	        driver.findElement(By.linkText("Continue")).click();

	        // Close browser
	        //driver.quit();*/
	    }
	}
	
	
	
	








