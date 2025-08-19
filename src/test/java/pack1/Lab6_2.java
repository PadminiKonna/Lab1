package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class Lab6_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Step 1: Open URL
        driver.get("https://tutorialsninja.com/demo/index.php");

        // Step 2: Login with credentials (created in Lab 1)
       /* driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("your_email_here"); // replace with your Lab 1 email
        driver.findElement(By.id("input-password")).sendKeys("your_password_here"); // replace with your Lab 1 password
        driver.findElement(By.xpath("//input[@value='Login']")).click();*/

        // Step 3: Go to 'Components' tab -> Monitors
        driver.findElement(By.linkText("Components")).click();
        driver.findElement(By.linkText("Monitors (2)")).click();

        // Step 4: Select '25' from Show dropdown
        Select showDropdown = new Select(driver.findElement(By.id("input-limit")));
        showDropdown.selectByVisibleText("25");

        // Step 5: Add first item to cart
        driver.findElement(By.xpath("(//button[@data-original-title='Add to Cart'])[1]")).click();

        // Step 6: Click on Specification tab
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='Specification']")).click();

        // Step 7: Verify details present on the page (simple check)
        WebElement specTab = driver.findElement(By.xpath("//h3[text()='Specification']"));
        if(specTab.isDisplayed()) {
            System.out.println("✅ Specification tab is displayed.");
        }

        // Step 8: Click on Add to Wish list
        driver.findElement(By.xpath("(//button[@data-original-title='Add to Wish List'])[1]")).click();

        // Step 9: Verify message
        WebElement msg1 = driver.findElement(By.cssSelector(".alert-success"));
        if(msg1.getText().contains("Success: You have added Apple Cinema 30\" to your wish list!")) {
            System.out.println("✅ Wish list success message verified.");
        }

        // Step 10: Search 'Mobile'
        driver.findElement(By.name("search")).sendKeys("Mobile");
        driver.findElement(By.cssSelector(".btn-default.btn-lg")).click();

        // Step 11: Click Search in product descriptions
        driver.findElement(By.id("description")).click();
        driver.findElement(By.id("button-search")).click();

        // Step 12: Click on HTC Touch HD link
        driver.findElement(By.linkText("HTC Touch HD")).click();

        // Step 13: Change Qty = 3
        WebElement qty = driver.findElement(By.id("input-quantity"));
        qty.clear();
        qty.sendKeys("3");

        // Step 14: Add to Cart
        driver.findElement(By.id("button-cart")).click();

        // Step 15: Verify success message
        WebElement msg2 = driver.findElement(By.cssSelector(".alert-success"));
        if(msg2.getText().contains("Success: You have added HTC Touch HD to your shopping cart!")) {
            System.out.println("✅ Add to cart success message verified.");
        }

        // Step 16: Click on View Cart
        driver.findElement(By.xpath("//a[@title='Shopping Cart']")).click();

        // Step 17: Verify Mobile name in cart
        WebElement cartItem = driver.findElement(By.linkText("HTC Touch HD"));
        if(cartItem.isDisplayed()) {
            System.out.println("✅ HTC Touch HD is in the cart.");
        }

        // Step 18: Checkout
        driver.findElement(By.linkText("Checkout")).click();

        // Step 19: Logout
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Logout")).click();

        // Step 20: Verify Account Logout heading
        WebElement logoutHeading = driver.findElement(By.xpath("//h1[text()='Account Logout']"));
        if(logoutHeading.isDisplayed()) {
            System.out.println("✅ Account Logout verified.");
        }

        // Step 21: Click Continue
        driver.findElement(By.linkText("Continue")).click();

        driver.quit();
    }
}
