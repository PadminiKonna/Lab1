package Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Q6 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void handleCheckboxesTest() {
        
        driver.get("https://the-internet.herokuapp.com/checkboxes");

       
        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

        
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }

        
        Assert.assertTrue(checkbox1.isSelected(), "Checkbox 1 is not selected!");
        Assert.assertTrue(checkbox2.isSelected(), "Checkbox 2 is not selected!");

        System.out.println("Both checkboxes are selected ✅");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("after class");
            driver.quit();
        
    }
}
