package browserfactory;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class Testing {
    String baseUrl = "https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html?product_list_order=name";
    WebDriver driver = new ChromeDriver();

    @Test
    public void testing() {
        driver.get(baseUrl);
        List<WebElement> products = driver.findElements(By.xpath("//strong[@class = 'product name product-item-name']"));
        for (WebElement p : products) {
            System.out.println(p.getText());
        }

    }

}


