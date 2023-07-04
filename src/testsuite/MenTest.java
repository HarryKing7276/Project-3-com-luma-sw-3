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

public class MenTest extends BaseTest {
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    //4. Write down the following test into ‘MenTest’ class
    //* 1. userShouldAddProductSuccessFullyToShoppingCart()
    public void userShouldAddProductSuccessfullyToShoppingCart() throws InterruptedException {
//* Mouse Hover on Men Menu
        WebElement men = driver.findElement(By.xpath("//a[@id='ui-id-5']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(men).build().perform();
//* Mouse Hover on Bottoms
        WebElement bottoms = driver.findElement(By.xpath("//a[@id='ui-id-18']"));
        actions.moveToElement(bottoms).build().perform();
//* Click on Pants
        WebElement pants = driver.findElement(By.xpath("//a[@id='ui-id-23']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actions.moveToElement(men).moveToElement(bottoms).moveToElement(pants).click().build().perform();
        //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        WebElement productName = driver.findElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        actions.moveToElement(productName).build().perform();
        // click on size 32
       WebElement cronusYogaPantSize = driver.findElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));
        actions.moveToElement(cronusYogaPantSize).click().build().perform();

        // click on colour black
       WebElement cronusYogaPantColourBlack = driver.findElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));
        actions.moveToElement(cronusYogaPantColourBlack).click().build().perform();

        // click on add to cart
       WebElement addToCart = driver.findElement(By.xpath("//li[1]//div[1]//div[1]//div[3]//div[1]//div[1]//form[1]//button[1]//span[1]"));
        actions.click(addToCart).click().build().perform();
        //Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        String expectedText="You added Cronus Yoga Pant to your shopping cart.";
        String actualText= driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();
        Assert.assertEquals(expectedText,actualText);

        //Click on ‘shopping cart’ Link into message

        driver.findElement(By.xpath("//a[normalize-space()='shopping cart']")).click();

        String expectedText1="Shopping Cart";
        String actualText1= driver.findElement(By.xpath("//body/div[1]/main[1]/div[1]/h1[1]/span[1]")).getText();
        Assert.assertEquals(expectedText1,actualText1);
        //* Verify the product name ‘Cronus Yoga Pant’

        String expectedText2="Cronus Yoga Pant";
        String actualText2= driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/strong[1]/a[1]")).getText();
        Assert.assertEquals(expectedText2,actualText2);

        String expectedText3="32";
        String actualText3= driver.findElement(By.xpath("//dd[contains(text(),'32')]")).getText();
        Assert.assertEquals(expectedText3,actualText3);

        String expectedText4="Black";
        String actualText4= driver.findElement(By.xpath("//dd[contains(text(),'Black')]")).getText();
        Assert.assertEquals(expectedText4,actualText4);
    }


    @After
    public void Teardown() {
        //   closeBrowser();
    }

}
