package Questions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Q5 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void f() {
        
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        
        Alert alert = driver.switchTo().alert();

        
        alert.accept();

        
        String resultText = driver.findElement(By.id("result")).getText();
        System.out.println("Result: " + resultText);

        Assert.assertEquals(resultText, "You successfully clicked an alert", "Alert result text mismatch!");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("after class");
            driver.quit();
        
    }
}
