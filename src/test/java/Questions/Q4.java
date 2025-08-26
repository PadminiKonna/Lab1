package Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Q4 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void f() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        WebElement dropdown = driver.findElement(By.name("my-select"));
        Select select = new Select(dropdown);

        
        select.selectByVisibleText("Two");

        WebElement selectedOption = select.getFirstSelectedOption();
        String selectedText = selectedOption.getText();

        System.out.println("Selected option: " + selectedText);
        Assert.assertEquals(selectedText, "Two", "Dropdown selection failed!");
    }

    @AfterClass
    public void afterClass() {
    	
        
            driver.quit();
        
    }
}
