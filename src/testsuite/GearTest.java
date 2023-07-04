package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class GearTest extends BaseTest {
    @Before
    public void setUp() {
        openBrowser(baseUrl);


    }

    @Test
    //5.Write down the following test into ‘GearTest’ class
//1. userShouldAddProductSuccessFullyToShoppingCart()
    public void userShouldAddProductSuccessFullyToShoppingCart() {
//* Mouse Hover on Gear Menu
        WebElement gear = driver.findElement(By.xpath("//span[contains(text(),'Gear')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(gear).build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // * Click on Bags
        driver.findElement(By.xpath("//span[contains(text(),'Bags')]")).click();


        //* Click on Product Name ‘Overnight Duffle’

        driver.findElement(By.xpath("//a[contains(text(),'Overnight Duffle')]")).click();
        String expected = "Overnight Duffle";
        String actualText = driver.findElement(By.xpath("//span[contains(text(),'Overnight Duffle')]")).getText();
        Assert.assertEquals(expected, actualText);
        // * Change Qty 3
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        driver.findElement(By.xpath("//input[@id='qty']")).sendKeys("3");
//* Click on ‘Add to Cart’ Button.
        driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]")).click();

        //* Verify the text ‘You added Overnight Duffle to your shopping cart.’

        String expected1 = "You added Overnight Duffle to your shopping cart.";
        String actualText1 = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();
        Assert.assertEquals(expected1, actualText1);
//* Click on ‘shopping cart’ Link into message
        driver.findElement(By.xpath("//a[normalize-space()='shopping cart']")).click();
//* Verify the product name ‘Overnight Duffle’
        String expected2 = "Overnight Duffle";
        String actualText2 = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/strong[1]/a[1]")).getText();
        Assert.assertEquals(expected2, actualText2);
// Verify the Qty is '3'
        String expectedText3 = "3";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String actualText3 = driver.findElement(By.xpath("//input[@id='cart-236166-qty']")).getText();
        Assert.assertEquals(expectedText3, actualText3);

        //Verify the product price ‘$135.00’
        String expectedText4 = "$135.00";
        String actualText4 = driver.findElement(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$135.00']")).getText();
        Assert.assertEquals(expectedText4, actualText4);

        //Change Qty to ‘5’
        driver.findElement(By.xpath("//input[@id='cart-236154-qty']")).clear();
        driver.findElement(By.xpath("//input[@id='cart-236154-qty']")).sendKeys("5");

        //Click on ‘Update Shopping Cart’ button
        driver.findElement(By.xpath("//span[normalize-space()='Update Shopping Cart']")).click();

        //Verify the product price ‘$225.00’
        String expectedText5 = "$225.00";
        String actualText5 = driver.findElement(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$225.00']")).getText();
        Assert.assertEquals(expectedText5, actualText5);

    }


    @After
    public void tearDown() {
        // closeBrowser();
    }
}
