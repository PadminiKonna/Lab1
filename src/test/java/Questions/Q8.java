package Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class Q8 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void multipleWindowsHandlingTest() {
        
        driver.get("https://the-internet.herokuapp.com/windows");

        
        String parentWindow = driver.getWindowHandle();

        
        driver.findElement(By.linkText("Click Here")).click();

       
        Set<String> allWindows = driver.getWindowHandles();

        
        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                System.out.println("Child Window Title: " + driver.getTitle());
                driver.close(); // optional: close child window
            }
        }

        
        driver.switchTo().window(parentWindow);
        System.out.println("Parent Window Title: " + driver.getTitle());
    }

    @AfterClass
    public void tearDown() {
        System.out.println("tear down");
            driver.quit();
        
    }
}
