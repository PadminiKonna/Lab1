package com.orangehrm.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pack1.login_pageobjects;

public class LoginSteps {
	WebDriver driver;
	
	@Given("Launch the Browser")
	public void launch_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
	   	    
	    WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    
	}

	@Given("Navigate to the URL")
	public void navigate_to_the_url() {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	   
	}

	@When("Enter the username and password")
	public void enter_the_username_and_password() {
		driver.findElement(By.name("username")).sendKeys("Admin");
				driver.findElement(By.name("password")).sendKeys("admin123");
	}

	
	@When("Enter the invalid username and password")
	public void enter_the_invalid_username_and_password() {
		driver.findElement(By.name("username")).sendKeys("fgdfgdfg");
				driver.findElement(By.name("password")).sendKeys("admin123fgdf");
	}

	@Then("Close the browser")
	public void Close_the_browser()
	
	{
		driver.quit();
	}
	@When("Click on Login Button")
	public void click_on_login_button() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}

	@Then("Login should be successful")
	public void login_should_be_successful() {
		String title=driver.getTitle();
		System.out.println("The Title is:"+title);
		if(title.equalsIgnoreCase("OrangeHRM"))
		{
			System.out.println("Login Suucessfull");
		}
		else
		{
			System.out.println("Login unSuucessfull");
		}
	}
	
	
	@Then("Login should be unsuccessful")
	public void login_should_be_unsuccessful() {
		WebElement error=driver.findElement(By.xpath("//p[text()='Invalid credentials']"));
		if(error.isDisplayed())
		{
			System.out.println("login unsccessfull");
		}
				
		
	}

	
	@Then("verify dashboard")
	public void verify_dashboard() {
	    try {
	        String dashboardHeader = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
	        if(dashboardHeader.equals("Dashboard")) {
	            System.out.println(" Dashboard verified successfully");
	        }
	    } catch (Exception e) {
	        System.out.println(" Dashboard not found, login may have failed");
	    }

}
	
}