package Questions;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Q9 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void captureScreenshotTest() throws IOException {
        
        driver.get("https://www.wikipedia.org/");

        
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        
        File destination = new File("homepage.png");
        FileHandler.copy(screenshot, destination);

        System.out.println("Screenshot saved as: " + destination.getAbsolutePath());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
