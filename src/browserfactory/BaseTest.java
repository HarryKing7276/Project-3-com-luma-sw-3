package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public static String baseUrl = "https://magento.softwaretestingboard.com/";

    public void openBrowser(String baseUrl) {
        // Declare the driver
        driver = new ChromeDriver();
        // Launch the baseUrl
        driver.get(baseUrl);
        //Maximise
        driver.manage().window().maximize();
        //Implicit time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    // Close the Browser
    public void closeBrowser() {
        driver.quit();
    }

}
