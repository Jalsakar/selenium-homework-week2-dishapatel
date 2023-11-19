package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    static String baseurl = "https://demo.nopcommerce.com/";

    @Before
    //Before Annotation to set up baseUrl
    public void setUp() {
        openBrowser(baseurl);
    }

    /**
     * 1. userShouldNavigateToLoginPageSuccessfully *
     * click on the ‘Login’ link
     * Verify the text ‘Welcome, Please Sign In!’
     */

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Find the login link and click on login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        //Verify the text ‘Welcome, Please Sign In!’
        String expectedText = "Welcome, Please Sign In!";

        //Find the actual text element and get the text from element
        WebElement actualTextElement = driver.findElement(By.xpath("//h1"));
        String actualText = actualTextElement.getText();

        //Verify expected text and actual text
        Assert.assertEquals(expectedText, actualText);
    }

    /**
     * 2. userShouldLoginSuccessfullyWithValidCredentials
     * * Click on the ‘Login’ link
     * * Enter valid username
     * * Enter valid password
     * * Click on ‘LOGIN’ button
     * * Verify the ‘Log out’ text is display
     */

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Click on the ‘Login’ link
        driver.findElement(By.linkText("Log in")).click();

        //Enter valid username
        driver.findElement(By.id("Email")).sendKeys("rubyjackson@gmail.com");

        //Enter valid password
        driver.findElement(By.name("Password")).sendKeys("rubyjackson@2023");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();

        //Verify the ‘Log out’ text is display
        String expectedMessage = "Log out";
        WebElement actualTextElement = driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Error Message", expectedMessage, actualMessage);
    }

    /**
     * 3. verifyTheErrorMessage
     * * Click on the ‘Login’ link
     * * Enter invalid username
     * * Enter invalid password
     * * Click on Login button
     * * Verify the error message ‘Login was unsuccessful. Please correct the errors and try again. No customer account found'
     */

    @Test
    public void verifyTheErrorMessage() {

        //Click on the ‘Login’ link
        driver.findElement(By.linkText("Log in")).click();
        //Enter invalid username
        driver.findElement(By.id("Email")).sendKeys("rubyjackson2023@gmail.com");
        //Enter invalid password
        driver.findElement(By.name("Password")).sendKeys("rubyjackson@2023");
        //Click on Login button
        driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();
        //Verify the error message ‘Login was unsuccessful. Please correct the errors and try again. No customer account found'
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @After
    //close all the browser
    public void tearDown() {
        closeBrowser();
    }
}