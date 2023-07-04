package Utlities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    // 1. This method will find the element  and click on that element
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    // 2. This method will send text to the element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    // 3. This method will get the text from an element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();

    }

    // 4. This method will mouse hover on the element
    public void mouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
        // To do in one line  1. and 2. Together
        // actions.moveToElement(computer).moveToElement(software).click().build().perform();
    }
    //5. This method will mouse hover and click on element
    public void mouseHoverAndClickOnElement(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }
    // 6. This method will select the option from the dropdown by visible Text
    public void selectFromVisibleTextFromDropdown(By by,String text){
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }
    //7. This method select the option from the dropdown by visible Value
    public void selectByValueFromDropDown(By by, String value){
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    //8. This method select the option from the dropdown by visible Index
    public void selectByIndexFromDropDown(By by, String index) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByValue(index);

    }
    // 9. This  method will verify Text by Assert
    public void verifyTextElement(String Text, By by){
        String expectedText = Text;
        String actualText = getTextFromElement(by);
        Assert.assertEquals(actualText,expectedText);
    }
    //10. This method will select Menu and click (Tagname should be select in Dom)
    public void selectMenuAndClick1(String menu) {
        WebElement menu1= driver.findElement(By.linkText(menu));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu1).click().build().perform();
    }



}
