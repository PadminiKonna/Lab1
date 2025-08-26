package Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Q7 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void webTableDataExtractionTest() {
        
        driver.get("https://the-internet.herokuapp.com/tables");

        
        WebElement table = driver.findElement(By.id("table1"));

        
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        System.out.println("Names from Table 1:");
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            if (cols.size() > 0) {
                String firstName = cols.get(1).getText();
                String lastName = cols.get(0).getText();
                System.out.println(firstName + " " + lastName);
            }
        }

       
        String emailOfJason = "";
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            if (cols.size() > 0) {
                String firstName = cols.get(1).getText();
                if (firstName.equalsIgnoreCase("Jason")) {
                    emailOfJason = cols.get(2).getText();
                    break;
                }
            }
        }

        System.out.println("Email of Jason: " + emailOfJason);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
