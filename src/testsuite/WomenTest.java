package testsuite;

import Utlities.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WomenTest extends Utility {
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortProductNameFilter() {
// Mouse Hover on Women Menu
        WebElement women = driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(women).build().perform();

//Mouse Hover on Tops
        WebElement tops = driver.findElement(By.xpath("//a[@id='ui-id-9']"));

        actions.moveToElement(tops).build().perform();

// Click on jackets
        WebElement jackets = driver.findElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
        actions.moveToElement(women).moveToElement(tops).moveToElement(jackets).click().build().perform();
        List<WebElement> beforeElements = driver.findElements(By.xpath("//strong[@class = 'product name product-item-name']"));
        for (WebElement product : beforeElements) {
            System.out.println(product.getText());
        }


// Select Sort By filter "Product Name"

        WebElement dropDown = driver.findElement(By.xpath("//div[2]//div[3]//select[1]"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Product Name");
        driver.navigate().back();
        System.out.println("------------------------------------");
//  Verify the products name display in alphabetical order
        List<WebElement> afterElements = driver.findElements(By.xpath("//strong[@class = 'product name product-item-name']"));
        for (WebElement product1 : afterElements) {
            System.out.println(product1.getText());
        }
    }


    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        // Mouse Hover on Women Menu
        WebElement women = driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(women).build().perform();

//Mouse Hover on Tops
        WebElement tops = driver.findElement(By.xpath("//a[@id='ui-id-9']"));

        actions.moveToElement(tops).build().perform();
// Click on jackets
        WebElement jackets = driver.findElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
        actions.moveToElement(women).moveToElement(tops).moveToElement(jackets).click().build().perform();

        List<WebElement> beforeElements1 = driver.findElements(By.xpath("//span[@id='product-price-1396']//span[@class='price'][normalize-space()='$77.00']"));
        for (WebElement product : beforeElements1) {
            System.out.println(product.getText());
        }

// Select Sort By filter " Price"
        selectFromVisibleTextFromDropdown(By.cssSelector("#sorter"), "Price");
        System.out.println("------------------------------------");


//  //* Verify the products price display in Low to High
        List<WebElement> afterElements1 = driver.findElements(By.xpath("//span[contains(text(),'$32.00')]"));
        for (WebElement product1 : afterElements1) {
            System.out.println(product1.getText());
        }

    }

    @After
    public void tearDown() {
        //   closeBrowser();
    }
}