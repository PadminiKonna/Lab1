package Questions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Q3 {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void f() throws InterruptedException {
        
        driver.get("https://www.amazon.in/");

        
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");
        driver.findElement(By.id("nav-search-submit-button")).click();

        
        Thread.sleep(3000);

        
        List<WebElement> products = driver.findElements( By.xpath("//span[contains(@class,'a-size-medium')]"));

        
        System.out.println("Top 2 Laptops:");
        for (int i = 0; i < 2 && i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).getText());
        }
    }

    @AfterClass
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}
