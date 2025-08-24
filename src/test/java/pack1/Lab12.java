package pack1;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Lab12 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Properties prob=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\Aug-07\\config.properties");
		prob.load(fis);
		String url=prob.getProperty("url");
		
		
		
		
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        
        driver.get(prob.getProperty("url"));
        Thread.sleep(2000);

        
        driver.findElement(By.xpath(prob.getProperty("usernameField"))).sendKeys("test@gmail.com");
        driver.findElement(By.xpath(prob.getProperty("passwordField"))).sendKeys("Test@123");
        driver.findElement(By.xpath(prob.getProperty("loginButton"))).click();

        
        driver.findElement(By.xpath("//a[text()='Desktops']")).click();
        driver.findElement(By.xpath(prob.getProperty("macLink"))).click();

        
        WebElement heading = driver.findElement(By.xpath(prob.getProperty("macHeading")));
        if (heading.isDisplayed()) {
            System.out.println("Mac heading verified ");
            System.out.println("sort A-Z");
            System.out.println("Monitor searched");
            
        }

        
        WebElement sort = driver.findElement(By.xpath(prob.getProperty("sortDropdown")));
        sort.sendKeys("Name (A - Z)");

       
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(prob.getProperty("addToCartButton"))
        ));
        addToCart.click();

        
        WebElement search = driver.findElement(By.xpath(prob.getProperty("searchBox")));
        search.clear();
        search.sendKeys("Monitors");
        driver.findElement(By.xpath(prob.getProperty("searchButton"))).click();

        // Clear Criteria
        WebElement criteria = driver.findElement(By.xpath(prob.getProperty("searchCriteriaBox")));
        criteria.clear();

        // Search in Descriptions
        driver.findElement(By.xpath(prob.getProperty("searchInDescriptions"))).click();
        driver.findElement(By.xpath(prob.getProperty("searchButton"))).click();

        Thread.sleep(3000);
        driver.quit();
    }



	}


