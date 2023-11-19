package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LoginTest extends BaseTest {
    static String baseUrl = "https://www.saucedemo.com/";

    @Before
    //Before Annotation to set up baseUrl
    public void setUp() {
        openBrowser(baseUrl);
    }

    /**
     * 1. userShouldLoginSuccessfullyWithValid Credentials
     * * Enter “standard_user” username
     * * Enter “secret_sauce” password
     * * Click on ‘LOGIN’ button
     * * Verify the text “PRODUCTS”
     */
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();
        //Verify the text “Products”
        String expectedText = "Products";
        WebElement actualText = driver.findElement(By.className("title"));
        Assert.assertEquals("Invalid text", expectedText, actualText.getText());
    }

    /**
     * 2. verifyThatSixProductsAreDisplayedOnPage
     * * Enter “standard_user” username
     * * Enter “secret_sauce” password
     * * Click on ‘LOGIN’ button
     * * Verify that six products are displayed on page
     */
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();
        // Store product elements in an ArrayList
        List<WebElement> productElements = driver.findElements(By.className("inventory_item"));
        // Create an ArrayList to store product names
        List<String> productNames = new ArrayList<>();
        // Iterate through product elements and store their names
        for (WebElement productElement : productElements) {
            String productName = productElement.findElement(By.className("inventory_item_name")).getText();
            productNames.add(productName);
        }
        //Verify that six products are displayed on page
        Assert.assertEquals("Expected six products to be displayed", productNames.size(), 6);
        // Print the names of the products
        System.out.println("Product Names: " + productNames);
    }

    @After
    //After Annotation to close all the browser
    public void tearDown() {
        closeBrowser();
    }
}